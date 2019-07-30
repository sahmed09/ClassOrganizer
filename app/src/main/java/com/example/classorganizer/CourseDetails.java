package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

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

            switch (Objects.requireNonNull(value)) {
                case "5th Batch(MSc)":
                    batchName.setText(value);
                    courseName.setText(R.string.fifthBatchCourseName);
                    break;
                case "6th Batch":
                    batchName.setText(value);
                    courseName.setText(R.string.sixthBatchCourseName);
                    break;
                case "7th Batch":
                    batchName.setText(value);
                    courseName.setText(R.string.seventhBatchCourseName);
                    break;
                case "8th Batch":
                    batchName.setText(value);
                    courseName.setText(R.string.eighthBatchCourseName);
                    break;
                case "9th Batch":
                    batchName.setText(value);
                    courseName.setText(R.string.ninthBatchCourseName);
                    break;
                case "10th Batch":
                    batchName.setText(value);
                    courseName.setText(R.string.tenthBatchCourseName);
                    break;
            }
        }
    }
}
