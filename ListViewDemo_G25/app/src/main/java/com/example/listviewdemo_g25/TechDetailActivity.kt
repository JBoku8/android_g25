package com.example.listviewdemo_g25


import android.os.Bundle
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class TechDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tech_detail)


        val techTitle = intent.getStringExtra(Constants.Selected_Tech)
        val techIndex = intent.getIntExtra(Constants.Selected_Tech_Index, 0)


        val textViewTitle = findViewById<TextView>(R.id.titleTextView)
        val textViewIndex = findViewById<TextView>(R.id.indexTextView)

        textViewTitle.text = techTitle;
        textViewIndex.text = "Selected index - $techIndex"

    }
}