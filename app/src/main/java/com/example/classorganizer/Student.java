package com.example.classorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class Student extends AppCompatActivity implements View.OnClickListener {

    Spinner batchPicker,dayPicker;
    Button viewButton,showCourseButton;
    ListView studentListView;
    String[] studentBatches,days;
    ArrayAdapter<String> batchArrayAdapter,dayArrayAdapter;
    CustomAdapter customAdapter;

    String[] sixSundayTime,sixSundayCourse,sixSundayTeacher;
    String[] sixMondayTime,sixMondayCourse,sixMondayTeacher;
    String[] sixTuesdayTime,sixTuesdayCourse,sixTuesdayTeacher;
    String[] sixWednesdayTime,sixWednesdayCourse,sixWednesdayTeacher;
    String[] sixThursdayTime,sixThursdayCourse,sixThursdayTeacher;

    String[] sevenSundayTime,sevenSundayCourse,sevenSundayTeacher;
    String[] sevenMondayTime,sevenMondayCourse,sevenMondayTeacher;
    String[] sevenTuesdayTime,sevenTuesdayCourse,sevenTuesdayTeacher;
    String[] sevenWednesdayTime,sevenWednesdayCourse,sevenWednesdayTeacher;
    String[] sevenThursdayTime,sevenThursdayCourse,sevenThursdayTeacher;

    String[] eightSundayTime,eightSundayCourse,eightSundayTeacher;
    String[] eightMondayTime,eightMondayCourse,eightMondayTeacher;
    String[] eightTuesdayTime,eightTuesdayCourse,eightTuesdayTeacher;
    String[] eightWednesdayTime,eightWednesdayCourse,eightWednesdayTeacher;
    String[] eightThursdayTime,eightThursdayCourse,eightThursdayTeacher;

    String[] nineSundayTime,nineSundayCourse,nineSundayTeacher;
    String[] nineMondayTime,nineMondayCourse,nineMondayTeacher;
    String[] nineTuesdayTime,nineTuesdayCourse,nineTuesdayTeacher;
    String[] nineWednesdayTime,nineWednesdayCourse,nineWednesdayTeacher;
    String[] nineThursdayTime,nineThursdayCourse,nineThursdayTeacher;

    String[] tenSundayTime,tenSundayCourse,tenSundayTeacher;
    String[] tenMondayTime,tenMondayCourse,tenMondayTeacher;
    String[] tenTuesdayTime,tenTuesdayCourse,tenTuesdayTeacher;
    String[] tenWednesdayTime,tenWednesdayCourse,tenWednesdayTeacher;
    String[] tenThursdayTime,tenThursdayCourse,tenThursdayTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //hiding the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        //hiding the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        //adding back button on Toolbar
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        batchPicker = findViewById(R.id.studentBatch);
        dayPicker = findViewById(R.id.dayNameStudent);
        viewButton = findViewById(R.id.showSchedule);
        showCourseButton = findViewById(R.id.courseDetails);
        studentListView = findViewById(R.id.studentListView);
        viewButton.setOnClickListener(this);
        showCourseButton.setOnClickListener(this);

        studentBatches = getResources().getStringArray(R.array.student_batch);
        days = getResources().getStringArray(R.array.day_name);

        batchArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentBatches);
        batchPicker.setAdapter(batchArrayAdapter);

        dayArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, days);
        dayPicker.setAdapter(dayArrayAdapter);

        sixSundayTime = getResources().getStringArray(R.array.sixSundayTime);
        sixMondayTime = getResources().getStringArray(R.array.sixMondayTime);
        sixTuesdayTime = getResources().getStringArray(R.array.sixTuesdayTime);
        sixWednesdayTime = getResources().getStringArray(R.array.sixWednesdayTime);
        sixThursdayTime = getResources().getStringArray(R.array.sixThursdayTime);
        sixSundayCourse = getResources().getStringArray(R.array.sixSundayCourse);
        sixMondayCourse = getResources().getStringArray(R.array.sixMondayCourse);
        sixTuesdayCourse = getResources().getStringArray(R.array.sixTuesdayCourse);
        sixWednesdayCourse = getResources().getStringArray(R.array.sixWednesdayCourse);
        sixThursdayCourse = getResources().getStringArray(R.array.sixThursdayCourse);
        sixSundayTeacher = getResources().getStringArray(R.array.sixSundayTeacher);
        sixMondayTeacher = getResources().getStringArray(R.array.sixMondayTeacher);
        sixTuesdayTeacher = getResources().getStringArray(R.array.sixTuesdayTeacher);
        sixWednesdayTeacher = getResources().getStringArray(R.array.sixWednesdayTeacher);
        sixThursdayTeacher = getResources().getStringArray(R.array.sixThursdayTeacher);

        sevenSundayTime = getResources().getStringArray(R.array.sevenSundayTime);
        sevenMondayTime = getResources().getStringArray(R.array.sevenMondayTime);
        sevenTuesdayTime = getResources().getStringArray(R.array.sevenTuesdayTime);
        sevenWednesdayTime = getResources().getStringArray(R.array.sevenWednesdayTime);
        sevenThursdayTime = getResources().getStringArray(R.array.sevenThursdayTime);
        sevenSundayCourse = getResources().getStringArray(R.array.sevenSundayCourse);
        sevenMondayCourse = getResources().getStringArray(R.array.sevenMondayCourse);
        sevenTuesdayCourse = getResources().getStringArray(R.array.sevenTuesdayCourse);
        sevenWednesdayCourse = getResources().getStringArray(R.array.sevenWednesdayCourse);
        sevenThursdayCourse = getResources().getStringArray(R.array.sevenThursdayCourse);
        sevenSundayTeacher = getResources().getStringArray(R.array.sevenSundayTeacher);
        sevenMondayTeacher = getResources().getStringArray(R.array.sevenMondayTeacher);
        sevenTuesdayTeacher = getResources().getStringArray(R.array.sevenTuesdayTeacher);
        sevenWednesdayTeacher = getResources().getStringArray(R.array.sevenWednesdayTeacher);
        sevenThursdayTeacher = getResources().getStringArray(R.array.sevenThursdayTeacher);

        eightSundayTime = getResources().getStringArray(R.array.eightSundayTime);
        eightMondayTime = getResources().getStringArray(R.array.eightMondayTime);
        eightTuesdayTime = getResources().getStringArray(R.array.eightTuesdayTime);
        eightWednesdayTime = getResources().getStringArray(R.array.eightWednesdayTime);
        eightThursdayTime = getResources().getStringArray(R.array.eightThursdayTime);
        eightSundayCourse = getResources().getStringArray(R.array.eightSundayCourse);
        eightMondayCourse = getResources().getStringArray(R.array.eightMondayCourse);
        eightTuesdayCourse = getResources().getStringArray(R.array.eightTuesdayCourse);
        eightWednesdayCourse = getResources().getStringArray(R.array.eightWednesdayCourse);
        eightThursdayCourse = getResources().getStringArray(R.array.eightThursdayCourse);
        eightSundayTeacher = getResources().getStringArray(R.array.eightSundayTeacher);
        eightMondayTeacher = getResources().getStringArray(R.array.eightMondayTeacher);
        eightTuesdayTeacher = getResources().getStringArray(R.array.eightTuesdayTeacher);
        eightWednesdayTeacher = getResources().getStringArray(R.array.eightWednesdayTeacher);
        eightThursdayTeacher = getResources().getStringArray(R.array.eightThursdayTeacher);

        nineSundayTime = getResources().getStringArray(R.array.nineSundayTime);
        nineMondayTime = getResources().getStringArray(R.array.nineMondayTime);
        nineTuesdayTime = getResources().getStringArray(R.array.nineTuesdayTime);
        nineWednesdayTime = getResources().getStringArray(R.array.nineWednesdayTime);
        nineThursdayTime = getResources().getStringArray(R.array.nineThursdayTime);
        nineSundayCourse = getResources().getStringArray(R.array.nineSundayCourse);
        nineMondayCourse = getResources().getStringArray(R.array.nineMondayCourse);
        nineTuesdayCourse = getResources().getStringArray(R.array.nineTuesdayCourse);
        nineWednesdayCourse = getResources().getStringArray(R.array.nineWednesdayCourse);
        nineThursdayCourse = getResources().getStringArray(R.array.nineThursdayCourse);
        nineSundayTeacher = getResources().getStringArray(R.array.nineSundayTeacher);
        nineMondayTeacher = getResources().getStringArray(R.array.nineMondayTeacher);
        nineTuesdayTeacher = getResources().getStringArray(R.array.nineTuesdayTeacher);
        nineWednesdayTeacher = getResources().getStringArray(R.array.nineWednesdayTeacher);
        nineThursdayTeacher = getResources().getStringArray(R.array.nineThursdayTeacher);

        tenSundayTime = getResources().getStringArray(R.array.tenSundayTime);
        tenMondayTime = getResources().getStringArray(R.array.tenMondayTime);
        tenTuesdayTime = getResources().getStringArray(R.array.tenTuesdayTime);
        tenWednesdayTime = getResources().getStringArray(R.array.tenWednesdayTime);
        tenThursdayTime = getResources().getStringArray(R.array.tenThursdayTime);
        tenSundayCourse = getResources().getStringArray(R.array.tenSundayCourse);
        tenMondayCourse = getResources().getStringArray(R.array.tenMondayCourse);
        tenTuesdayCourse = getResources().getStringArray(R.array.tenTuesdayCourse);
        tenWednesdayCourse = getResources().getStringArray(R.array.tenWednesdayCourse);
        tenThursdayCourse = getResources().getStringArray(R.array.tenThursdayCourse);
        tenSundayTeacher = getResources().getStringArray(R.array.tenSundayTeacher);
        tenMondayTeacher = getResources().getStringArray(R.array.tenMondayTeacher);
        tenTuesdayTeacher = getResources().getStringArray(R.array.tenTuesdayTeacher);
        tenWednesdayTeacher = getResources().getStringArray(R.array.tenWednesdayTeacher);
        tenThursdayTeacher = getResources().getStringArray(R.array.tenThursdayTeacher);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.showSchedule) {

            String batch = batchPicker.getSelectedItem().toString();
            String day = dayPicker.getSelectedItem().toString();

            switch (batch) {
                case "6th Batch":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, sixSundayTime, sixSundayCourse, sixSundayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, sixMondayTime, sixMondayCourse, sixMondayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, sixTuesdayTime, sixTuesdayCourse, sixTuesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, sixWednesdayTime, sixWednesdayCourse, sixWednesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, sixThursdayTime, sixThursdayCourse, sixThursdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "7th Batch":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, sevenSundayTime, sevenSundayCourse, sevenSundayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, sevenMondayTime, sevenMondayCourse, sevenMondayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, sevenTuesdayTime, sevenTuesdayCourse, sevenTuesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, sevenWednesdayTime, sevenWednesdayCourse, sevenWednesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, sevenThursdayTime, sevenThursdayCourse, sevenThursdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "8th Batch":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, eightSundayTime, eightSundayCourse, eightSundayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, eightMondayTime, eightMondayCourse, eightMondayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, eightTuesdayTime, eightTuesdayCourse, eightTuesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, eightWednesdayTime, eightWednesdayCourse, eightWednesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, eightThursdayTime, eightThursdayCourse, eightThursdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "9th Batch":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, nineSundayTime, nineSundayCourse, nineSundayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, nineMondayTime, nineMondayCourse, nineMondayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, nineTuesdayTime, nineTuesdayCourse, nineTuesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, nineWednesdayTime, nineWednesdayCourse, nineWednesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, nineThursdayTime, nineThursdayCourse, nineThursdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "10th Batch":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, tenSundayTime, tenSundayCourse, tenSundayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, tenMondayTime, tenMondayCourse, tenMondayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, tenTuesdayTime, tenTuesdayCourse, tenTuesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, tenWednesdayTime, tenWednesdayCourse, tenWednesdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, tenThursdayTime, tenThursdayCourse, tenThursdayTeacher);
                            studentListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Select Batch":
                    switch (day) {
                        case "Select a day":
                            studentListView.setAdapter(null);
                            break;
                    }
                    break;
            }
        }
        else if(v.getId() == R.id.courseDetails) {

            String batch = batchPicker.getSelectedItem().toString();
            if(batch.equals("Select Batch")) {
                Toast.makeText(getApplicationContext(),"Please Select a batch",Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(getApplicationContext(),CourseDetails.class);
                intent.putExtra("batchName", batch);
                startActivity(intent);
            }
        }
    }
}
