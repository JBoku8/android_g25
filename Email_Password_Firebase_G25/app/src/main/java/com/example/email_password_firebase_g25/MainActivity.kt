package com.example.email_password_firebase_g25

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var logOutButton: Button
    lateinit var updateProfileButton: Button
    lateinit var displayNameTextView: TextView
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logOutButton = findViewById(R.id.logOutButton)
        updateProfileButton = findViewById(R.id.updateProfileButton)
        displayNameTextView = findViewById(R.id.displayNameTextView)
        auth = FirebaseAuth.getInstance()

        logOutButton.setOnClickListener {
            auth.signOut()

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        updateProfileButton.setOnClickListener {
            val intent = Intent(this, UpdateProfileActivity::class.java)
            startActivity(intent)
        }


        if( auth.currentUser != null ){
            val user = auth.currentUser;
            displayNameTextView.text = user?.displayName
            Toast.makeText(this, "უკვე ავტორიზებული", Toast.LENGTH_LONG).show()
        }
    }
}