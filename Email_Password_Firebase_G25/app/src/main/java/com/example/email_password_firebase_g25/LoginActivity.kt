package com.example.email_password_firebase_g25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var forgotPasswordTextView: TextView

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText

    lateinit var auth: FirebaseAuth

    lateinit var signInButton: Button
    lateinit var signUpButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        forgotPasswordTextView = findViewById(R.id.forgotPassword)
        emailEditText = findViewById(R.id.emailLoginEditText)
        passwordEditText = findViewById(R.id.passwordLoginEditText)
        signInButton = findViewById(R.id.loginButton)
        signUpButton = findViewById(R.id.registerButton)

        auth = FirebaseAuth.getInstance()

        forgotPasswordTextView.setOnClickListener {
            val forgotPwdIntent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(forgotPwdIntent)
            finish()
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }


        signInButton.setOnClickListener {
            val email: String = emailEditText.text.toString()
            val password: String = passwordEditText.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this@LoginActivity, "გთხოვთ შეავსოთ ყველა ველი.", Toast.LENGTH_LONG).show()
            } else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "წარმატებით გაიარეთ ავტორიზაცია", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(this, "წარუმატებელი მოქმედება.", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }
}