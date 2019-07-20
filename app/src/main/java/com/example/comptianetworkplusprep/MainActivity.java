package com.example.comptianetworkplusprep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // widgets
    Button btnSubmit;
    TextView tvAnswerOne, tvAnswerTwo, tvAnswerThree, tvAnswerFour, tvQuestion;
    
    // vars
    private String highlightedAnswer = "";
    boolean readyForNextQuestion = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        tvAnswerOne = (TextView) findViewById(R.id.tvAnswerOne);
        tvAnswerTwo = (TextView) findViewById(R.id.tvAnswerTwo);
        tvAnswerThree = (TextView) findViewById(R.id.tvAnswerThree);
        tvAnswerFour = (TextView) findViewById(R.id.tvAnswerFour);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
    }

    public void answerHighlighted(View view) {

        Log.d(TAG, "answerHighlighted: Highlighted: " + view.getResources().getResourceName(view.getId()));
        Log.d(TAG, "answerHighlighted: Answer One: " + view.getResources().getResourceName(tvAnswerOne.getId()));
        if (view.getId() != tvAnswerOne.getId()) {
            tvAnswerOne.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));
        }

        if (view.getId() != tvAnswerTwo.getId()) {
            tvAnswerTwo.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));
        }

        if (view.getId() != tvAnswerThree.getId()) {
            tvAnswerThree.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));
        }

        if (view.getId() != tvAnswerFour.getId()) {
            tvAnswerFour.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));
        }

        view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        TextView tvView = (TextView) view;
        highlightedAnswer = tvView.getText().toString();

        btnSubmit.setEnabled(true);
        btnSubmit.setBackgroundColor(getResources().getColor(R.color.submitAnswerAvailable));

    }

    public void checkAnswer(View view) {

        if (!readyForNextQuestion) {

            if (highlightedAnswer.equals(view.getResources().getString(R.string.answer_1_1))) {
                Log.d(TAG, "checkAnswer: Correct Answer");
                Toast.makeText(this, "Answer Correct!", Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(getResources().getColor(R.color.answerCorrect));
            } else {
                Log.d(TAG, "checkAnswer: Incorrect Answer");
                Toast.makeText(this, "Answer Not Correct!", Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(getResources().getColor(R.color.answerIncorrect));
            }

            btnSubmit.setText(getResources().getString(R.string.continue_btn));

            tvAnswerOne.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));
            tvAnswerTwo.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));
            tvAnswerThree.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));
            tvAnswerFour.setBackgroundColor(getResources().getColor(R.color.answerChoiceIdle));

            readyForNextQuestion = true;

        } else {
            tvQuestion.setText(getResources().getString(R.string.sample_question_2));
            tvAnswerOne.setText(getResources().getString(R.string.answer_2_1));
            tvAnswerTwo.setText(getResources().getString(R.string.answer_2_2));
            tvAnswerThree.setText(getResources().getString(R.string.answer_2_3));
            tvAnswerFour.setText(getResources().getString(R.string.answer_2_4));

            readyForNextQuestion = false;
            btnSubmit.setText(getResources().getString(R.string.submit_answer));
            btnSubmit.setBackgroundColor(getResources().getColor(R.color.submitAnswerNotAvailable));
            btnSubmit.setEnabled(false);
        }

    }
}
