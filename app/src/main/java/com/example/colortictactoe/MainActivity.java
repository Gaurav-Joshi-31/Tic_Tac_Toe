package com.example.colortictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

int state[]={3,3,3,3,3,3,3,3,3};
int[][] wins={{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
boolean active=true;
    int player=1;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void dropIn(View view) {
        ImageView image = (ImageView) view;

        int tap = Integer.parseInt(image.getTag().toString());
        if (state[tap] == 3 && active==true) {
            image.setTranslationY(-1500);
            state[tap] = player;
            if (player == 1) {
                image.setImageResource(R.drawable.yellow);
                player = 2;
            } else {
                image.setImageResource(R.drawable.red);
                player = 1;
            }
            image.animate().translationYBy(1500).rotation(3000).setDuration(300);



                for (int[] win : wins) {

                    if (state[win[0]] == state[win[1]] && state[win[1]] == state[win[2]] && state[win[1]] != 3) {
                        active = false;
                        String message = "";
                        if (player == 1) {
                            message += "Red has won!!!!!";
                        } else {
                            message += "Yellow has won!!!!!";
                        }
                        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

                        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                        winnerTextView.setText("" + message);

                        playAgainButton.setVisibility(View.VISIBLE);

                        winnerTextView.setVisibility(View.VISIBLE);
                    }

                    count=0;
                }
            for(int i=0;i<state.length;i++) {

                if(state[i]==3) count++;

            }
            if(count==0&&active){
                active=false;
                String message="Draw!!!!!";
                Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

                TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                winnerTextView.setText("" + message);

                playAgainButton.setVisibility(View.VISIBLE);

                winnerTextView.setVisibility(View.VISIBLE);
            }
            }
        }


    public void playAgain(View view) {
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);
        active=true;
        player=1;
        for(int i=0;i<state.length;i++){
            state[i]=3;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }
    }
}