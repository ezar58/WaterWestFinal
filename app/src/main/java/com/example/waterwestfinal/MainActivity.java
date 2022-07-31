package com.example.waterwestfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.waterwestfinal.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button AlertBtn;
    TextView WaterUsageBtn;
    private RecyclerView mRecycler;
    androidx.constraintlayout.widget.Guideline topwater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = (RecyclerView) findViewById(R.id.todayL);
        new FirebaseDatabaseHelper().readDays(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Day> days, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecycler, MainActivity.this, days, keys);

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
        topwater = findViewById(R.id.watertop);
        //  topwater.setGuidelinePercent((float) 0.3); // to raise water in the tank
        WaterUsageBtn = findViewById(R.id.WaterUsageBtn);
        AlertBtn = findViewById(R.id.AlertBtn);
        AlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),alerts_activity.class);
                startActivity(intent);
                finish();

            }
        });
       /* WaterUsageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),water_usage.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}