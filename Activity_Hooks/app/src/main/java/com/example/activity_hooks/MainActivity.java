package com.example.activity_hooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_TEXT = "com.example.activity_hooks.TEXT";

    String currentState;
    int score;
    int lives;


    public void onExplicitIntent(View view){
        Intent explicitIntent = new Intent();
        explicitIntent.setAction(Intent.ACTION_SEND);
        explicitIntent.putExtra(EXTRA_TEXT, "DEMO TEXT");
        explicitIntent.setType("text/plain");
//        MIME

        Intent window = Intent.createChooser(explicitIntent, "Chose Application");
        if (explicitIntent.resolveActivity(getPackageManager()) != null){
            startActivity(window);
        }
        else {
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putString("STATE", "SAVED");
        outState.putInt("SCORE", 4);
        outState.putInt("LIVE", 3);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if( savedInstanceState != null ){
            currentState = savedInstanceState.getString("STATE");
            score = savedInstanceState.getInt("SCORE", 0);
            lives = savedInstanceState.getInt("LIVE", 0);
        }
        else {
//            start from scratch

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DESTROY", "APP :: MainActivity.onStart ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("DESTROY", "APP :: MainActivity.onPause ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DESTROY", "APP :: MainActivity.onResume ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DESTROY", "APP :: MainActivity.onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("DESTROY", "APP :: MainActivity.onRestart");

    }
}