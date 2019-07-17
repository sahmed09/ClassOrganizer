package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetails extends AppCompatActivity {

    TextView batchName,courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Courses");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        batchName = findViewById(R.id.batchName);
        courseName = findViewById(R.id.courseTextView);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {

            String value = bundle.getString("batchName");

            if ("6th Batch".equals(value)) {
                batchName.setText(value);
                courseName.setText(R.string.sixthBatchCourseName);

            } else if ("7th Batch".equals(value)) {
                batchName.setText(value);
                courseName.setText(R.string.seventhBatchCourseName);

            } else if ("8th Batch".equals(value)) {
                batchName.setText(value);
                courseName.setText(R.string.eighthBatchCourseName);

            } else if ("9th Batch".equals(value)) {
                batchName.setText(value);
                courseName.setText(R.string.ninthBatchCourseName);

            } else if ("10th Batch".equals(value)) {
                batchName.setText(value);
                courseName.setText(R.string.tenthBatchCourseName);

            }
        }
    }
}
