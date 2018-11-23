package com.example.sm_pc.a2018wic;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MoodAnalysis extends Dialog implements View.OnClickListener {

    private Context context;

    public MoodAnalysis(Context context) {
        super(context);
        this.context = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_feeling);


    }

    public void onClick(View v) {

    }
}
