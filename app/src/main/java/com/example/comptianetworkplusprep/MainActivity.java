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
    
    // vars
    private String highlightedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
    }

    public void answerHighlighted(View view) {

        Log.d(TAG, "answerHighlighted: Highlighted: " + view.getResources().getResourceName(view.getId()));

        view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        TextView tvView = (TextView) view;
        highlightedAnswer = tvView.getText().toString();

        btnSubmit.setEnabled(true);
        btnSubmit.setBackgroundColor(getResources().getColor(R.color.submitAnswerAvailable));

    }

    public void checkAnswer(View view) {

        if (highlightedAnswer.equals(view.getResources().getString(R.string.answer_1_1))) {
            Log.d(TAG, "checkAnswer: Correct Answer");
            Toast.makeText(this, "Answer Correct!", Toast.LENGTH_SHORT).show();
            view.setBackgroundColor(getResources().getColor(R.color.answerCorrect));
            view.setEnabled(false);
        } else {
            Log.d(TAG, "checkAnswer: Incorrect Answer");
            Toast.makeText(this, "Answer Not Correct!", Toast.LENGTH_SHORT).show();
            view.setBackgroundColor(getResources().getColor(R.color.answerIncorrect));
            view.setEnabled(false);
        }

    }
}
