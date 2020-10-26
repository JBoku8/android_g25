package com.example.activity_and_intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public final static String MAIN_ACTIVITY_NUMBER = "com.example.activity_and_intents.AGE";
    public final static String MAIN_ACTIVITY_USERNAME = "com.example.activity_and_intents.USERNAME";

    public final static int REQUEST_FirstName = 1;
    public final static int REQUEST_LastName = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartSecondActivity(View view) {
        Intent customIntent = new Intent(this, SecondActivity.class);

//        URI
//        customIntent.setData(Uri.parse());

//        customIntent.putExtra(MAIN_ACTIVITY_NUMBER, 45);
//        customIntent.putExtra(MAIN_ACTIVITY_USERNAME, "SuperMan");

        Bundle bundle = new Bundle();
        bundle.putString(MAIN_ACTIVITY_USERNAME, "SUPERMAN");
        bundle.putInt(MAIN_ACTIVITY_NUMBER, 89);

        customIntent.putExtras(bundle);
        startActivityForResult(customIntent, REQUEST_FirstName);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if( requestCode == REQUEST_FirstName ) {
                if( resultCode == RESULT_OK ) {
                    String responseText = data.getStringExtra(SecondActivity.RESPONSE);
                    TextView textView = (TextView) findViewById(R.id.textView);

                    textView.setText(responseText);
                }
            }
        }
        catch (Exception e){

        }

    }


    //    STACK
    /*
    C
    B
    A
    Z
    Y
    X
     */

    //        getResources().getIdentifier("music.mp3", "raw", getPackageName());

//        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
//
//        myMap.put("JOHN", 34);
//        myMap.put("Samuel", 23);
//
//
//        try {
//            for (String key: myMap.keySet()) {
//                Log.i("KEY", myMap.get(key).toString());
//            }
//
//        }
//        catch (Exception e){
//            Log.i("EXCEPTION", e.getMessage());
//        }


}