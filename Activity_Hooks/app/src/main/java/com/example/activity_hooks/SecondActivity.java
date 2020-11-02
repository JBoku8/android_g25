package com.example.activity_hooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private void onFinishClick(View view){
        finish();
//        logic
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent recIntent = getIntent();

        String text = recIntent.getStringExtra(MainActivity.EXTRA_TEXT);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        Button finishBtn = (Button) findViewById(R.id.finishBtn);

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFinishClick(v);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("DESTROY", "APP :: SecondActivity.onDestroy ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DESTROY", "APP :: SecondActivity.onStop ");
    }
}