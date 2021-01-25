package com.example.email_password_firebase_g25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class UpdateProfileActivity : AppCompatActivity() {
    private lateinit var newPasswordEditText: EditText
    private lateinit var confirmPasswordButton: Button
    private lateinit var profileViewButton: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        newPasswordEditText = findViewById(R.id.newPasswordEditText)
        confirmPasswordButton = findViewById(R.id.confirmPasswordButton)
        profileViewButton = findViewById(R.id.profileViewButton)
        auth = FirebaseAuth.getInstance()

        profileViewButton.setOnClickListener {
           finish()
        }

        confirmPasswordButton.setOnClickListener {
            val password: String = newPasswordEditText.text.toString()
            Log.i("NEW_PASSWORD", password)
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "გთხოვთ შეიყვანოთ პაროლი", Toast.LENGTH_LONG).show()
            } else {
                auth.currentUser?.updatePassword(password)
                    ?.addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "პაროლი შეიცვალა წარმატებით", Toast.LENGTH_LONG)
                                .show()
                            finish()
                        } else {
                            Toast.makeText(this, "პაროლი არ შეიცვალა", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
            }
        }
    }
}