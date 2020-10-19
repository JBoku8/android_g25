package com.example.crossgameg_25;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 წითელი , 1 - ყვითელი, 2 - ცარიელი
    int[] gameState = {2,2,2, 2,2,2, 2,2,2};
    int[][] winningPositions = {
            {0,1,2},
            {3,4,5},
            {6,7,8},

            {0,3,6},
            {1,4,7},
            {2,5,8},

            {0,4,8},
            {2,4,6}
    };
    boolean redIsShown = true;
    int activePlayer = 0;
    boolean gameIsActive = true;
//
//    public void onImageClick(View view) {
//        Log.d("IMAGE", "IMAGE CLICKED");
//        ImageView currentImage = (ImageView) view;
////        imageView.animate().rotation(3600).alpha(0.5f).setDuration(2000);
//
//        if( redIsShown ) {
//            ImageView yellowImage = (ImageView)findViewById(R.id.yellow);
//
//            currentImage.animate().translationY(-1000).rotation(3600).alpha(0).setDuration(300);
//            yellowImage.animate().translationY(0).rotation(3600).alpha(1).setDuration(300);
//            redIsShown = false;
//        }
//        else {
//            ImageView redImage = (ImageView)findViewById(R.id.red);
//
//            currentImage.animate().translationY(-1000).rotation(3600).alpha(0).setDuration(300);
//            redImage.animate().translationY(0).rotation(3600).alpha(1).setDuration(300);
//            redIsShown = true;
//        }
//    }

    public void playGame(View view){
        ImageView currentImage = (ImageView) view;

        int tagValue = Integer.parseInt(currentImage.getTag().toString());

        if( gameState[tagValue] == 2  && gameIsActive) {
            currentImage.setTranslationY(-1500);
            gameState[tagValue] = activePlayer;

            if( activePlayer == 0 ) {
                currentImage.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            }
            else {
                currentImage.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            currentImage.animate().rotation(3600).alpha(1).translationY(0).setDuration(300);
        }


        for(int[] positions: winningPositions){
            if( gameState[positions[0]]  == gameState[positions[1]] && gameState[positions[1]] == gameState[positions[2]] && gameState[positions[0]] != 2) {
                gameIsActive = false;
                String message;


                if(activePlayer == 1) {
                    message = "Yellow";
                }
                else {
                    message = "Red";
                }
//                Toast.makeText(this, "Winner " + message, Toast.LENGTH_SHORT).show();

                Button restartGameButton = (Button) findViewById(R.id.restartGameBtn);
                TextView gameMessageTextView = (TextView) findViewById(R.id.gameMessage);

                gameMessageTextView.setVisibility(View.VISIBLE);
                restartGameButton.setVisibility(View.VISIBLE);


                String myStr = getString(R.string.messageText, message);
                gameMessageTextView.setText(myStr);
                gameMessageTextView.setAlpha(0f);
                gameMessageTextView.setTranslationX(-2000);

                gameMessageTextView.animate().alpha(1).translationX(0).setDuration(300);

                break;
            }
        }
    }

    public void restartGame(View view){
        Button restartGameButton = (Button) (view);
        TextView gameMessageTextView = (TextView) findViewById(R.id.gameMessage);

        restartGameButton.setVisibility(View.INVISIBLE);
        gameMessageTextView.setVisibility(View.INVISIBLE);

        GridLayout gameLayout = (GridLayout) findViewById(R.id.gridLayout);

        for( int i = 0; i < gameLayout.getChildCount(); i++ ) {
            ImageView tempImage = (ImageView) gameLayout.getChildAt(i);
            tempImage.setImageDrawable(null);
        }


        for( int i = 0; i < gameState.length; i++ ) {
            gameState[i] = 2;
        }

        activePlayer = 0;
        gameIsActive = true;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}