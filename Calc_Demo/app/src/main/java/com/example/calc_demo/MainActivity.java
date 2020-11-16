package com.example.calc_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    TextView fieldFirst, fieldSecond, operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    private void init(){
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        fieldFirst = findViewById(R.id.fieldFirst);
        fieldSecond = findViewById(R.id.fieldSecond);
        operation = findViewById(R.id.operation);
    }

    public void clearBoard(View view){
        fieldFirst.setText("");
        fieldSecond.setText("");
        operation.setText("");
    }


    public void enterNumber(View view){
        Button numberBtn = (Button)view;
        Log.i("NUMBER", numberBtn.getTag().toString());
        String currentValue = fieldFirst.getText().toString() + numberBtn.getTag().toString();
        fieldFirst.setText(currentValue);
    }
}