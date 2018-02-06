package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int cardsTeamA = 0;
    int scoreTeamA = 0;
    int cardsTeamB = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /**
         * Increase the score for Team A by 1 goal
         */
        final Button button1 = findViewById(R.id.goal);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
            }
        });

        /**
         * Increase the cards for Team B by 1
         */
        final Button button2 = findViewById(R.id.yellowCard);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cardsTeamA = cardsTeamA + 1;
                displayCardsForTeamA(cardsTeamA);
            }
        });

        /**
         * Increase the cards for Team B by 2
         */
        final Button button3 = findViewById(R.id.redCard);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cardsTeamA = cardsTeamA + 2;
                displayCardsForTeamA(cardsTeamA);
            }
        });

        /**
         * Increase the score for Team B by 1 goal
         */
        final Button button4 = findViewById(R.id.goalB);
            button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    scoreTeamB = scoreTeamB +1;
                    displayForTeamB(scoreTeamB);
                }
            });

            /**
             * Increase the cards for Team B by 1
             */
            final Button button5 = findViewById(R.id.yellowCardB);
                button5.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        cardsTeamB += 1;
                        displayCardsForTeamB(cardsTeamB);
                    }
                });

        /**
         * Increase the cards for Team B by 2
         */
        final Button button6 = findViewById(R.id.redCardB);
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                cardsTeamB += 2;
                displayCardsForTeamB(cardsTeamB);
            }
        });

        final Button button7 = findViewById(R.id.reset);
        button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                scoreTeamA = 0;
                cardsTeamA = 0;
                scoreTeamB = 0;
                cardsTeamB = 0;
                displayForTeamA(scoreTeamA);
                displayCardsForTeamA(cardsTeamA);
                displayForTeamB(scoreTeamB);
                displayCardsForTeamB(cardsTeamB);
            }
        });
         }


public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
        }

public void displayCardsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_cards);
        scoreView.setText(String.valueOf(score));
        }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayCardsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_cards);
        scoreView.setText(String.valueOf(score));
    }
        }