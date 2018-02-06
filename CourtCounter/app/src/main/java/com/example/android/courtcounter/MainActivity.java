package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as

    /**
     * Displays the given score for Team A.
     */
    int scoreTeamA = 0;

    int scoreTeamB = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        /**
         * Increase the score for Team A by 3 points
         */
        final Button button3 = findViewById(R.id.points3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                scoreTeamA = scoreTeamA + 3;
                displayForTeamA(scoreTeamA);
            }
        });

        /**
         * Increase the score for Team A by 2 points
         */
        final Button button2 = findViewById(R.id.points2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                scoreTeamA = scoreTeamA + 2;
                displayForTeamA(scoreTeamA);
            }
        });

        /**
         * Increase the score for Team A by 1 point
         */
        final Button button1 = findViewById(R.id.point1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
            }
        });

        /**
         * Increase the score for Team B by 3 points
         */
        final Button button4 = findViewById(R.id.points3B);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                scoreTeamB = scoreTeamB + 3;
                displayForTeamB(scoreTeamB);
            }
        });

        /**
         * Increase the score for Team B by 2 points
         */
        final Button button5 = findViewById(R.id.points2B);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                scoreTeamB = scoreTeamB + 2;
                displayForTeamB(scoreTeamB);
            }
        });

        /**
         * Increase the score for Team B by 1 point
         */
        final Button button6 = findViewById(R.id.point1B);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Code here executes on main thread after user presses button
                scoreTeamB = scoreTeamB + 1;
                displayForTeamB(scoreTeamB);
            }
        });

        /**
         * Reset the score for Team A & reset the score for Team B
         */
        final Button button7 = findViewById(R.id.reset);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                scoreTeamA = 0;
                displayForTeamA(scoreTeamA);
                scoreTeamB = 0;
                displayForTeamB(scoreTeamB);
            }
        });

    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    }



