package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Student extends AppCompatActivity {

    Spinner studentBatch,day;
    String[] studentBatches;
    String[] days;
    ArrayAdapter<String> studentAdapter,dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        //adding back button on Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        studentBatch = findViewById(R.id.studentBatch);
        day = findViewById(R.id.dayNameStudent);

        studentBatches = getResources().getStringArray(R.array.student_batch);
        days = getResources().getStringArray(R.array.day_name);

        studentAdapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.sampleView,studentBatches);
        studentBatch.setAdapter(studentAdapter);

        dayAdapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.sampleView,days);
        day.setAdapter(dayAdapter);
    }
}
