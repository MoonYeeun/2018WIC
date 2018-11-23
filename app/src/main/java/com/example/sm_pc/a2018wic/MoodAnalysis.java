package com.example.sm_pc.a2018wic;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MoodAnalysis extends Dialog implements View.OnClickListener {

    private Context context;

    public MoodAnalysis(Context context) {
        super(context);
        this.context = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_feeling);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);

        ArrayList<Entry> Goodentries = new ArrayList<>();
        Goodentries.add(new Entry(4f, 0));
        Goodentries.add(new Entry(8f, 1));
        Goodentries.add(new Entry(6f, 2));
        Goodentries.add(new Entry(2f, 3));
        Goodentries.add(new Entry(18f, 4));
        Goodentries.add(new Entry(9f, 5));

        ArrayList<Entry> Happyentries = new ArrayList<>();
        Happyentries.add(new Entry(6f, 0));
        Happyentries.add(new Entry(7f, 1));
        Happyentries.add(new Entry(2f, 2));
        Happyentries.add(new Entry(4f, 3));
        Happyentries.add(new Entry(15f, 4));
        Happyentries.add(new Entry(7f, 5));

        ArrayList<Entry> Sosoentries = new ArrayList<>();
        Sosoentries.add(new Entry(4f, 0));
        Sosoentries.add(new Entry(8f, 1));
        Sosoentries.add(new Entry(6f, 2));
        Sosoentries.add(new Entry(2f, 3));
        Sosoentries.add(new Entry(18f, 4));
        Sosoentries.add(new Entry(9f, 5));

        ArrayList<Entry> Sadentries = new ArrayList<>();
        Sadentries.add(new Entry(3f, 0));
        Sadentries.add(new Entry(4f, 1));
        Sadentries.add(new Entry(6f, 2));
        Sadentries.add(new Entry(2f, 3));
        Sadentries.add(new Entry(9f, 4));
        Sadentries.add(new Entry(9f, 5));

        ArrayList<Entry> Tiredentries = new ArrayList<>();
        Tiredentries.add(new Entry(2f, 0));
        Tiredentries.add(new Entry(6f, 1));
        Tiredentries.add(new Entry(8f, 2));
        Tiredentries.add(new Entry(4f, 3));
        Tiredentries.add(new Entry(10f, 4));
        Tiredentries.add(new Entry(15f, 5));

        ArrayList<Entry> Angryentries = new ArrayList<>();
        Angryentries.add(new Entry(10f, 0));
        Angryentries.add(new Entry(2f, 1));
        Angryentries.add(new Entry(7f, 2));
        Angryentries.add(new Entry(5f, 3));
        Angryentries.add(new Entry(11f, 4));
        Angryentries.add(new Entry(8f, 5));

        LineDataSet Gooddataset = new LineDataSet(Goodentries, "Good");
        Gooddataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        Gooddataset.setColor(Color.YELLOW);
        Gooddataset.setLineWidth(4);

        LineDataSet Happydataset = new LineDataSet(Happyentries, "Happy");
        Happydataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        Happydataset.setColor(Color.CYAN);
        Happydataset.setLineWidth(4);

        LineDataSet Sosodataset = new LineDataSet(Sosoentries, "Just fine");
        Sosodataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        Sosodataset.setColor(Color.GRAY);
        Sosodataset.setLineWidth(4);

        LineDataSet Saddataset = new LineDataSet(Sadentries, "Sad");
        Saddataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        Saddataset.setColor(Color.BLUE);
        Saddataset.setLineWidth(4);

        LineDataSet Tireddataset = new LineDataSet(Tiredentries, "Tired");
        Tireddataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        Tireddataset.setColor(Color.GREEN);
        Tireddataset.setLineWidth(4);

        LineDataSet Angrydataset = new LineDataSet(Angryentries, "Angry");
        Angrydataset.setAxisDependency(YAxis.AxisDependency.LEFT);
        Angrydataset.setColor(Color.RED);
        Angrydataset.setLineWidth(4);

//        ArrayList<String> labels = new ArrayList<String>();
//        labels.add("");
//        labels.add("");
//        labels.add("");
//        labels.add("");
//        labels.add("");
//        labels.add("");



//        LineData data = new LineData(labels,dataset);
//        dataset.setLineWidth(5);
//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
//        /*dataset.setDrawCubic(true); //선 둥글게 만들기
//       dataset.setDrawFilled(true); //그래프 밑부분 색칠*/

//
        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(Gooddataset);
        dataSets.add(Happydataset);
        dataSets.add(Sosodataset);
        dataSets.add(Saddataset);
        dataSets.add(Tireddataset);
        dataSets.add(Angrydataset);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q");
        xVals.add("5.Q"); xVals.add("6.Q");

        lineChart.setData(new LineData(xVals,dataSets));

//        LineData data1 = new LineData(labels,Gooddataset);
//        LineData data2 = new LineData(labels,Happydataset);
//        LineData data3 = new LineData(labels,Sosodataset);
//        LineData data4 = new LineData(labels,Saddataset);
//        LineData data5 = new LineData(labels,Tireddataset);
//        LineData data6 = new LineData(labels,Angrydataset);
//
//        lineChart.setData(data1);
//        lineChart.setData(data2);
//        lineChart.setData(data3);
//        lineChart.setData(data4);
//        lineChart.setData(data5);
//        lineChart.setData(data6);

        lineChart.animateY(5000);


    }

    public void onClick(View v) {

    }

}

