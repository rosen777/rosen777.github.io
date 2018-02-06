package com.example.android.russianquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button resetButton  = (Button) findViewById(R.id.reset);
        resetButton.setVisibility(View.GONE);
    }


    /**
     * Function called upon clicking the submit button
     */

    public int answersMethod() {
        /**
         * Checkboxes
         */
        // Is the answer five checkbox now checked?
        CheckBox answerFiveText = (CheckBox) findViewById(R.id.answerFive);
        boolean answerFive = answerFiveText.isChecked();

        // Is the answer six checkbox now checked?
        CheckBox answerSixText = (CheckBox) findViewById(R.id.answerSix);
        boolean answerSix = answerSixText.isChecked();

        // Is the answer seven checkbox now checked?
        CheckBox answerSevenText = (CheckBox) findViewById(R.id.answerSeven);
        boolean answerSeven = answerSevenText.isChecked();

        // Is the answer eight checkbox now checked?
        CheckBox answerEightText = (CheckBox) findViewById(R.id.answerEight);
        boolean answerEight = answerEightText.isChecked();

        /**
         * Radio Buttons
         */
        // Is the answer two radio button now checked?
        RadioButton answerTwoButton = (RadioButton) findViewById(R.id.answerTwo);
        boolean answerTwo = answerTwoButton.isChecked();

        //Is the answer thirteen radio button now checked?
        RadioButton answerThirteenButton = (RadioButton) findViewById(R.id.answerThirteen);
        boolean answerThirteen = answerThirteenButton.isChecked();


        /**
         * Edit Texts
         */
        // What is the user input?
        EditText answerNineEdit = (EditText) findViewById(R.id.answerNine);
        String userInput = answerNineEdit.getText().toString();

        /**
         * Strings in Edit Texts
         */
        String some = "some";
        String certain = "certain";

        // Check which radio button was clicked
        if (answerTwoButton.isChecked()) {
            //When the second answer is checked, the number of correct answers increases by 1.
            correctAnswers += 1;
        }
        if (answerFiveText.isChecked() && answerEightText.isChecked()) {
            //When the fifth answer and the eight answer is checked, the number of correct answers increases by 1.
            correctAnswers += 1;
        }
        if (answerSixText.isChecked() || answerSevenText.isChecked()) {
            //When the sixth answer is checked, the number of correct answers increases by 1.
            correctAnswers = 0;
        }
        if (some.equalsIgnoreCase(userInput)) {
            //When the user types in some, the number of correct answers increases by 1.
            correctAnswers += 1;
        }
        if (certain.equalsIgnoreCase(userInput)) {
            //When the user types in certain, the number of correct answers increases by 1.
            correctAnswers += 1;
        }
        if (answerThirteenButton.isChecked()) {
            //When the thirteenth answer is checked, the number of correct answers increases by 1.
            correctAnswers += 1;
        }
        return correctAnswers;
    }

    /**
     *Your score is calculated with these functions.
     */
        public String calculateScore() {
        correctAnswers = answersMethod();
        String scoreMessage = getString(R.string.correct_answers_summary);
        return scoreMessage;
        }

        public String calculateScore2() {
        correctAnswers = answersMethod();
        String scoreMessage2 = getString(R.string.max_answers_summary);
        return scoreMessage2;
        }

    /**
     *Your score is calculated with these functions.
     */

        public void submitAnswers(View view) {

        if (correctAnswers < 4) {
            String scoreMessage = calculateScore();
            displayMessage(scoreMessage);

            displayScoreA(correctAnswers);

            Toast.makeText(this, "Yay! You have successfully submitted your answers", Toast.LENGTH_SHORT).show();
        }

            if (correctAnswers == 4) {
                String scoreMessage2 =calculateScore2();
                displayScoreMax(scoreMessage2);
                Toast.makeText(this, "4 of 4! You are ready to go to Moscow", Toast.LENGTH_SHORT).show();
                return;
            }


            Button submitButton = (Button) findViewById(R.id.submit_button);
            submitButton.setVisibility(View.GONE);

            Button resetButton  = (Button) findViewById(R.id.reset);
            resetButton.setVisibility(View.VISIBLE);

    }

    public void resetButton(View v) {
        correctAnswers = 0;
        displayScoreA(correctAnswers);
        Toast.makeText(this, "You have reset your score. Try Again!", Toast.LENGTH_SHORT).show();


                //Restore the Submit Quiz Button once clicked
                Button submitButton = (Button) findViewById(R.id.submit_button);
                submitButton.setVisibility(View.VISIBLE);

        Button resetButton  = (Button) findViewById(R.id.reset);
        resetButton.setVisibility(View.GONE);

        String scoreMessage3 = getString(R.string.zero_summary);
        displayMax(scoreMessage3);
        String scoreMessage4 = getString(R.string.zero_summary);
        displayScoreB(scoreMessage4);
            }


    /**
     * Display the final score of the user
     */

    public void displayScoreA(int correctAnswers) {
        TextView quizScoreTextView = (TextView) findViewById(R.id.quiz_score);
        quizScoreTextView.setText("" + correctAnswers + " of 4");
    }

    public void displayScoreMax(String message2) {
        TextView scoreMaxTextView = (TextView) findViewById(R.id.quiz_score_text);
        scoreMaxTextView.setText(message2);
    }

    private void displayMessage(String message) {
        TextView calculateScoreTextView = (TextView) findViewById(R.id.quiz_score_text);
        calculateScoreTextView.setText(message);
    }

    public void displayMax(String message3) {
        TextView quizMessageTextView = (TextView) findViewById(R.id.quiz_score_text);
        quizMessageTextView.setText(message3);
    }

    public void displayScoreB(String message4) {
        TextView quizScoreTextView = (TextView) findViewById(R.id.quiz_score);
        quizScoreTextView.setText(message4);
    }

}


