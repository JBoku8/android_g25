package com.example.myfirstapplicationg_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    public void onButtonClick(View view){
//        EditText yourNameEditText = (EditText) findViewById(R.id.yourNameEditText);
//
//        TextView appTitleTextView = (TextView) findViewById(R.id.appTitleTextView);
//
//        Log.i("INFO", "Click Me Button Pressed.");
//        Log.i("Application", yourNameEditText.getText().toString());
//
//        Toast.makeText(this, "Hi, " + yourNameEditText.getText().toString(), Toast.LENGTH_LONG).show();
//
//        appTitleTextView.setText(yourNameEditText.getText().toString());
    }


    public void onSwitchCatButton(View view){
        Log.i("INFO", "onSwitchCatButton");

        ImageView image = (ImageView) findViewById(R.id.catImageView);
        image.setImageResource(R.drawable.cat_2);

        //TODO    Cat Toggle Logic

        logSomething();

    }


    private void logSomething(){
        Log.i("Function_LOG", "Log Something");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}