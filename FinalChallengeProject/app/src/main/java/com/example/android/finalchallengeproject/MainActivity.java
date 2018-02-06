package com.example.android.finalchallengeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

TextView quizQuestion = findViewById(R.id.quizQuestion);
    RadioButton answerOne = findViewById(R.id.answerOne);
    RadioButton answerTwo = findViewById(R.id.answerTwo);
    RadioButton answerThree = findViewById(R.id.answerThree);
    RadioButton answerFour = findViewById(R.id.answerFour);

    switch(changeText)
    {
        //Upon 'Submitting' an answer from the user, the text of the question and the four answers changes
        case 1:
        {
            submitAnswer();
            quizQuestion.setText("@+string/question2");
            answerOne.setText("@+string/answer5");
            answerTwo.setText("@+string/answer6");
            answerThree.setText("@+string/answer7");
            answerFour.setText("@+string/answer8");
            break;
        }
        case 2:
        {
            submitAnswer();
            quizQuestion.setText("@+string/question3");
            radioGroup.removeAllViews();
            addEditText();
        }
        case 3:{
            submitAnswer();
            quizQuestion.setText("@+string/question4");
            radioGroup.removeAllViews();
            
        }

    }
}
