package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Teacher extends AppCompatActivity {

    Spinner teacherName,day;
    String[] teacherNames;
    String[] days;
    ArrayAdapter<String> teacherAdapter,dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        //adding back button on Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        teacherName = findViewById(R.id.teacherName);
        day = findViewById(R.id.dayNameTeacher);

        teacherNames = getResources().getStringArray(R.array.teacher_name);
        days = getResources().getStringArray(R.array.day_name);

        teacherAdapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.sampleView,teacherNames);
        teacherName.setAdapter(teacherAdapter);

        dayAdapter = new ArrayAdapter<String>(this,R.layout.sample_view,R.id.sampleView,days);
        day.setAdapter(dayAdapter);
    }
}
