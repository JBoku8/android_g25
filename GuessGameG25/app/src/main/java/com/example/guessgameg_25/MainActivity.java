package com.example.guessgameg_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    private void generateNumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;

//        Button playButton = (Button) findViewById(R.id.button);
//        playButton.setText("Play");
    }

    public void play(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
//        Button playButton = (Button) findViewById(R.id.button);
        String message;

        if( editText.getText().toString().isEmpty() ) {
            message = "Please enter the Number";
        }
        else {
            int userNumber = Integer.parseInt(editText.getText().toString());

            Log.i("Info", "Play, " + randomNumber);


            if (userNumber > randomNumber) {
                message = "Try lower.";
            }
            else if (userNumber < randomNumber) {
                message = "Try higher.";
            }
            else {
                message = "You Did it";
//                playButton.setText("Try Again");

               generateNumber();
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();
    }
}