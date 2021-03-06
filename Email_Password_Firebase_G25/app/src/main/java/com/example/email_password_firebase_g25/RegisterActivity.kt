package com.example.email_password_firebase_g25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegisterActivity : AppCompatActivity() {
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText

    lateinit var auth: FirebaseAuth

    lateinit var signInButton: Button
    lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        signInButton = findViewById(R.id.sign_in_button)
        signUpButton = findViewById(R.id.sing_up_button)

        auth = FirebaseAuth.getInstance()

        signInButton.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java);
            startActivity(loginIntent)
            finish()
        }


        signUpButton.setOnClickListener {
            val email: String = emailEditText.text.toString()
            val password: String = passwordEditText.text.toString()

            if( TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ) {
                Toast.makeText(this, "გთხოვთ შეავსოთ ყველა ველი", Toast.LENGTH_LONG).show()
            }
            else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                    this,
                    OnCompleteListener { newUser ->
                        if (newUser.isSuccessful) {
                            val user = auth.currentUser;
                            val profileUpdates = UserProfileChangeRequest.Builder()
                                .setDisplayName(email).build()

                            user?.updateProfile(profileUpdates)
                                ?.addOnCompleteListener(OnCompleteListener<Void?> { userUpdated ->
                                    if (userUpdated.isSuccessful) {
                                        Toast.makeText(this, "წარმატებით დარეგისტრირდით", Toast.LENGTH_LONG)
                                            .show()
                                        val intent = Intent(this, MainActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    }
                                })
                        } else {
                            Toast.makeText(this, "რეგისტრაცია წარუმატებელია", Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }

    }

    override fun onStart() {
        super.onStart()

        if(auth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}