package com.example.comptianetworkplusprep;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class AnswerChoiceTextView extends android.support.v7.widget.AppCompatTextView {

    private TextView view = this;

    public AnswerChoiceTextView(Context context) {
        super(context);
    }

    public AnswerChoiceTextView(Context context, TextView view) {
        super(context);
        this.view = view;
//        view.setBackgroundColor(view.getResources().getColor(R.color.answerChoiceIdle));
//        view.setAllCaps(true);
    }

    public AnswerChoiceTextView(Context context, AttributeSet attrs, TextView view) {
        super(context, attrs);
        this.view = view;
    }

    public AnswerChoiceTextView(Context context, AttributeSet attrs, int defStyleAttr, TextView view) {
        super(context, attrs, defStyleAttr);
        this.view = view;
    }
}
