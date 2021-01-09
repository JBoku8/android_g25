package com.example.java_and_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val person = Person("John Doe", 34)
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = person.getInfo()


        val rand = Random()
        val value: Int = rand.nextInt(50)

        val randomTextView = findViewById<TextView>(R.id.randomTextView);
        randomTextView.text = value.toString()
    }
}