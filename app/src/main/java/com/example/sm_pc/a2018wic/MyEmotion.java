package com.example.sm_pc.a2018wic;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MyEmotion extends Fragment implements View.OnClickListener{
    ImageView title;
    View view;
    ImageButton good,happy,soso,sad,tired,angry,mood;
    Boolean choose = false;
    RelativeLayout current_mood,emotion;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.choose_feeling, container, false);

        good = (ImageButton)view.findViewById(R.id.good);
        happy = (ImageButton)view.findViewById(R.id.happy);
        soso = (ImageButton)view.findViewById(R.id.soso);
        sad = (ImageButton)view.findViewById(R.id.sad);
        tired = (ImageButton)view.findViewById(R.id.tired);
        angry = (ImageButton)view.findViewById(R.id.angry);
        title = (ImageView)view.findViewById(R.id.title);
        mood = (ImageButton) view.findViewById(R.id.mood);

        emotion = (RelativeLayout)view.findViewById(R.id.emotion);
        current_mood = (RelativeLayout)view.findViewById(R.id.current_mood);
        current_mood.setVisibility(View.GONE);

        good.setOnClickListener(this);
        happy.setOnClickListener(this);
        soso.setOnClickListener(this);
        sad.setOnClickListener(this);
        tired.setOnClickListener(this);
        angry.setOnClickListener(this);
        mood.setOnClickListener(this);

        return view;

//
//        LineChart lineChart = (LineChart)view.findViewById(R.id.chart);
//
//        ArrayList<Entry> entries = new ArrayList<>();
//        entries.add(new Entry(4f, 0));
//        entries.add(new Entry(8f, 1));
//        entries.add(new Entry(6f, 2));
//        entries.add(new Entry(2f, 3));
//        entries.add(new Entry(18f, 4));
//        entries.add(new Entry(9f, 5));
//        entries.add(new Entry(16f, 6));
//        entries.add(new Entry(5f, 7));
//        entries.add(new Entry(3f, 8));
//        entries.add(new Entry(7f, 10));
//        entries.add(new Entry(9f, 11));
//
//        LineDataSet dataset = new LineDataSet(entries, "# of Calls");
//
//        ArrayList<String> labels = new ArrayList<String>();
//        labels.add("January");
//        labels.add("February");
//        labels.add("March");
//        labels.add("April");
//        labels.add("May");
//        labels.add("June");
//        labels.add("July");
//        labels.add("August");
//        labels.add("September");
//        labels.add("October");
//        labels.add("November");
//        labels.add("December");
//
//        //LineData data = new LineData(labels,dataset);
//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
//        /*dataset.setDrawCubic(true); //선 둥글게 만들기
//        dataset.setDrawFilled(true); //그래프 밑부분 색칠*/
//
//        //lineChart.setData(data);
//        lineChart.animateY(5000);
    }
    public void onClick(View view) {
        if(choose == true){
            Log.d("choose",choose.toString());
            title.setBackgroundResource(R.drawable.how_was_your_day);
            choose = false;
            current_mood.setVisibility(View.GONE);
            emotion.setVisibility(View.VISIBLE);
            choose = false;
        }
        else{
            Log.d("choose",choose.toString());
            title.setBackgroundResource(R.drawable.today_s_feeling);
            emotion.setVisibility(view.GONE);

            if (view.getId() == R.id.good){
                Log.d("SELECT",choose.toString());
                mood.setBackgroundResource(R.drawable.good);
            }
            if (view.getId() == R.id.happy) {
                mood.setBackgroundResource(R.drawable.happy);
            }
            if (view.getId() == R.id.soso) {
                mood.setBackgroundResource(R.drawable.soso);
            }
            if (view.getId() == R.id.sad) {
                mood.setBackgroundResource(R.drawable.sad);
            }
            if (view.getId() == R.id.tired) {
                mood.setBackgroundResource(R.drawable.tired);
            }
            if (view.getId() == R.id.angry) {
                mood.setBackgroundResource(R.drawable.angry);
            }
            current_mood.setVisibility(view.VISIBLE);
            choose = true;
         }
    }

}
