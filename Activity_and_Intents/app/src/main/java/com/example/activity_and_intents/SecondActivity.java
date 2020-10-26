package com.example.activity_and_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    public final static String RESPONSE = "com.example.activity_and_intents.RESPONSE";

    int intentNumber;
    String userName;

    public void onFinishActivity(View view){
        Intent responseIntent = new Intent();
        responseIntent.putExtra(RESPONSE, "Spider-Man");

        setResult(RESULT_OK, responseIntent);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Log.i("INFO", MainActivity.MAIN_ACTIVITY_MESSAGE);

        Intent receivedIntent = getIntent();
        Bundle receivedBundle = receivedIntent.getExtras();

//        intentNumber = receivedIntent.getIntExtra(MainActivity.MAIN_ACTIVITY_NUMBER, 0);
//        userName = receivedIntent.getStringExtra(MainActivity.MAIN_ACTIVITY_USERNAME);

        intentNumber = receivedBundle.getInt(MainActivity.MAIN_ACTIVITY_NUMBER);
        userName = receivedBundle.getString(MainActivity.MAIN_ACTIVITY_USERNAME);

        Button button = (Button) findViewById(R.id.onActivityFinishBtn);
        button.setText(userName + " Button");
    }

}