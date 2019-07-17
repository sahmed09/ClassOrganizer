package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Objects;

public class Teacher extends AppCompatActivity {

    Spinner teacherName,day;
    String[] teacherNames;
    String[] days;
    ArrayAdapter<String> teacherAdapter,dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //hiding the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        //hiding the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        //adding back button on Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        teacherName = findViewById(R.id.teacherName);
        day = findViewById(R.id.dayNameTeacher);

        teacherNames = getResources().getStringArray(R.array.teacher_name);
        days = getResources().getStringArray(R.array.day_name);

        teacherAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,teacherNames);
        teacherName.setAdapter(teacherAdapter);

        dayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,days);
        day.setAdapter(dayAdapter);
    }
}
