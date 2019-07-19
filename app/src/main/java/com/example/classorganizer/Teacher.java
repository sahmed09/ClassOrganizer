package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Objects;

public class Teacher extends AppCompatActivity implements View.OnClickListener {

    Spinner teacherNamePicker,dayPicker;
    ListView teacherListView;
    Button showDetailsButton;
    String[] teacherNames,days;
    ArrayAdapter<String> teacherAdapter,dayAdapter;
    CustomAdapter customAdapter;

    String[] tofaelSirSundayTime,tofaelSirSundayCourse,tofaelSirSundayBatch;
    String[] tofaelSirMondayTime,tofaelSirMondayCourse,tofaelSirMondayBatch;
    String[] tofaelSirTuesdayTime,tofaelSirTuesdayCourse,tofaelSirTuesdayBatch;
    String[] tofaelSirWednesdayTime,tofaelSirWednesdayCourse,tofaelSirWednesdayBatch;
    String[] tofaelSirThursdayTime,tofaelSirThursdayCourse,tofaelSirThursdayBatch;

    String[] imranSirSundayTime,imranSirSundayCourse,imranSirSundayBatch;
    String[] imranSirMondayTime,imranSirMondayCourse,imranSirMondayBatch;
    String[] imranSirTuesdayTime,imranSirTuesdayCourse,imranSirTuesdayBatch;
    String[] imranSirWednesdayTime,imranSirWednesdayCourse,imranSirWednesdayBatch;
    String[] imranSirThursdayTime,imranSirThursdayCourse,imranSirThursdayBatch;

    String[] mehediSirSundayTime,mehediSirSundayCourse,mehediSirSundayBatch;
    String[] mehediSirMondayTime,mehediSirMondayCourse,mehediSirMondayBatch;
    String[] mehediSirTuesdayTime,mehediSirTuesdayCourse,mehediSirTuesdayBatch;
    String[] mehediSirWednesdayTime,mehediSirWednesdayCourse,mehediSirWednesdayBatch;
    String[] mehediSirThursdayTime,mehediSirThursdayCourse,mehediSirThursdayBatch;

    String[] sharifSirSundayTime,sharifSirSundayCourse,sharifSirSundayBatch;
    String[] sharifSirMondayTime,sharifSirMondayCourse,sharifSirMondayBatch;
    String[] sharifSirTuesdayTime,sharifSirTuesdayCourse,sharifSirTuesdayBatch;
    String[] sharifSirWednesdayTime,sharifSirWednesdayCourse,sharifSirWednesdayBatch;
    String[] sharifSirThursdayTime,sharifSirThursdayCourse,sharifSirThursdayBatch;

    String[] sadiaMamSundayTime,sadiaMamSundayCourse,sadiaMamSundayBatch;
    String[] sadiaMamMondayTime,sadiaMamMondayCourse,sadiaMamMondayBatch;
    String[] sadiaMamTuesdayTime,sadiaMamTuesdayCourse,sadiaMamTuesdayBatch;
    String[] sadiaMamWednesdayTime,sadiaMamWednesdayCourse,sadiaMamWednesdayBatch;
    String[] sadiaMamThursdayTime,sadiaMamThursdayCourse,sadiaMamThursdayBatch;

    String[] arifulSirSundayTime,arifulSirSundayCourse,arifulSirSundayBatch;
    String[] arifulSirMondayTime,arifulSirMondayCourse,arifulSirMondayBatch;
    String[] arifulSirTuesdayTime,arifulSirTuesdayCourse,arifulSirTuesdayBatch;
    String[] arifulSirWednesdayTime,arifulSirWednesdayCourse,arifulSirWednesdayBatch;
    String[] arifulSirThursdayTime,arifulSirThursdayCourse,arifulSirThursdayBatch;

    String[] rakibSirSundayTime,rakibSirSundayCourse,rakibSirSundayBatch;
    String[] rakibSirMondayTime,rakibSirMondayCourse,rakibSirMondayBatch;
    String[] rakibSirTuesdayTime,rakibSirTuesdayCourse,rakibSirTuesdayBatch;
    String[] rakibSirWednesdayTime,rakibSirWednesdayCourse,rakibSirWednesdayBatch;
    String[] rakibSirThursdayTime,rakibSirThursdayCourse,rakibSirThursdayBatch;

    String[] amenaMamSundayTime,amenaMamSundayCourse,amenaMamSundayBatch;
    String[] amenaMamMondayTime,amenaMamMondayCourse,amenaMamMondayBatch;
    String[] amenaMamTuesdayTime,amenaMamTuesdayCourse,amenaMamTuesdayBatch;
    String[] amenaMamWednesdayTime,amenaMamWednesdayCourse,amenaMamWednesdayBatch;
    String[] amenaMamThursdayTime,amenaMamThursdayCourse,amenaMamThursdayBatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //hiding the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();
        //hiding the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        //adding back button on Toolbar
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        teacherNamePicker = findViewById(R.id.teacherName);
        dayPicker = findViewById(R.id.dayNameTeacher);
        teacherListView = findViewById(R.id.teacherListView);
        showDetailsButton = findViewById(R.id.teacherShowDetails);
        showDetailsButton.setOnClickListener(this);

        teacherNames = getResources().getStringArray(R.array.teacher_name);
        days = getResources().getStringArray(R.array.day_name);

        teacherAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,teacherNames);
        teacherNamePicker.setAdapter(teacherAdapter);

        dayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,days);
        dayPicker.setAdapter(dayAdapter);

        tofaelSirSundayTime = getResources().getStringArray(R.array.tofaelSirSundayTime);
        tofaelSirMondayTime = getResources().getStringArray(R.array.tofaelSirMondayTime);
        tofaelSirTuesdayTime = getResources().getStringArray(R.array.tofaelSirTuesdayTime);
        tofaelSirWednesdayTime = getResources().getStringArray(R.array.tofaelSirWednesdayTime);
        tofaelSirThursdayTime = getResources().getStringArray(R.array.tofaelSirThursdayTime);
        tofaelSirSundayCourse = getResources().getStringArray(R.array.tofaelSirSundayCourse);
        tofaelSirMondayCourse = getResources().getStringArray(R.array.tofaelSirMondayCourse);
        tofaelSirTuesdayCourse = getResources().getStringArray(R.array.tofaelSirTuesdayCourse);
        tofaelSirWednesdayCourse = getResources().getStringArray(R.array.tofaelSirWednesdayCourse);
        tofaelSirThursdayCourse = getResources().getStringArray(R.array.tofaelSirThursdayCourse);
        tofaelSirSundayBatch = getResources().getStringArray(R.array.tofaelSirSundayBatch);
        tofaelSirMondayBatch = getResources().getStringArray(R.array.tofaelSirMondayBatch);
        tofaelSirTuesdayBatch = getResources().getStringArray(R.array.tofaelSirTuesdayBatch);
        tofaelSirWednesdayBatch = getResources().getStringArray(R.array.tofaelSirWednesdayBatch);
        tofaelSirThursdayBatch = getResources().getStringArray(R.array.tofaelSirThursdayBatch);

        imranSirSundayTime = getResources().getStringArray(R.array.imranSirSundayTime);
        imranSirMondayTime = getResources().getStringArray(R.array.imranSirMondayTime);
        imranSirTuesdayTime = getResources().getStringArray(R.array.imranSirTuesdayTime);
        imranSirWednesdayTime = getResources().getStringArray(R.array.imranSirWednesdayTime);
        imranSirThursdayTime = getResources().getStringArray(R.array.imranSirThursdayTime);
        imranSirSundayCourse = getResources().getStringArray(R.array.imranSirSundayCourse);
        imranSirMondayCourse = getResources().getStringArray(R.array.imranSirMondayCourse);
        imranSirTuesdayCourse = getResources().getStringArray(R.array.imranSirTuesdayCourse);
        imranSirWednesdayCourse = getResources().getStringArray(R.array.imranSirWednesdayCourse);
        imranSirThursdayCourse = getResources().getStringArray(R.array.imranSirThursdayCourse);
        imranSirSundayBatch = getResources().getStringArray(R.array.imranSirSundayBatch);
        imranSirMondayBatch = getResources().getStringArray(R.array.imranSirMondayBatch);
        imranSirTuesdayBatch = getResources().getStringArray(R.array.imranSirTuesdayBatch);
        imranSirWednesdayBatch = getResources().getStringArray(R.array.imranSirWednesdayBatch);
        imranSirThursdayBatch = getResources().getStringArray(R.array.imranSirThursdayBatch);

        mehediSirSundayTime = getResources().getStringArray(R.array.mehediSirSundayTime);
        mehediSirMondayTime = getResources().getStringArray(R.array.mehediSirMondayTime);
        mehediSirTuesdayTime = getResources().getStringArray(R.array.mehediSirTuesdayTime);
        mehediSirWednesdayTime = getResources().getStringArray(R.array.mehediSirWednesdayTime);
        mehediSirThursdayTime = getResources().getStringArray(R.array.mehediSirThursdayTime);
        mehediSirSundayCourse = getResources().getStringArray(R.array.mehediSirSundayCourse);
        mehediSirMondayCourse = getResources().getStringArray(R.array.mehediSirMondayCourse);
        mehediSirTuesdayCourse = getResources().getStringArray(R.array.mehediSirTuesdayCourse);
        mehediSirWednesdayCourse = getResources().getStringArray(R.array.mehediSirWednesdayCourse);
        mehediSirThursdayCourse = getResources().getStringArray(R.array.mehediSirThursdayCourse);
        mehediSirSundayBatch = getResources().getStringArray(R.array.mehediSirSundayBatch);
        mehediSirMondayBatch = getResources().getStringArray(R.array.mehediSirMondayBatch);
        mehediSirTuesdayBatch = getResources().getStringArray(R.array.mehediSirTuesdayBatch);
        mehediSirWednesdayBatch = getResources().getStringArray(R.array.mehediSirWednesdayBatch);
        mehediSirThursdayBatch = getResources().getStringArray(R.array.mehediSirThursdayBatch);

        sharifSirSundayTime = getResources().getStringArray(R.array.sharifSirSundayTime);
        sharifSirMondayTime = getResources().getStringArray(R.array.sharifSirMondayTime);
        sharifSirTuesdayTime = getResources().getStringArray(R.array.sharifSirTuesdayTime);
        sharifSirWednesdayTime = getResources().getStringArray(R.array.sharifSirWednesdayTime);
        sharifSirThursdayTime = getResources().getStringArray(R.array.sharifSirThursdayTime);
        sharifSirSundayCourse = getResources().getStringArray(R.array.sharifSirSundayCourse);
        sharifSirMondayCourse = getResources().getStringArray(R.array.sharifSirMondayCourse);
        sharifSirTuesdayCourse = getResources().getStringArray(R.array.sharifSirTuesdayCourse);
        sharifSirWednesdayCourse = getResources().getStringArray(R.array.sharifSirWednesdayCourse);
        sharifSirThursdayCourse = getResources().getStringArray(R.array.sharifSirThursdayCourse);
        sharifSirSundayBatch = getResources().getStringArray(R.array.sharifSirSundayBatch);
        sharifSirMondayBatch = getResources().getStringArray(R.array.sharifSirMondayBatch);
        sharifSirTuesdayBatch = getResources().getStringArray(R.array.sharifSirTuesdayBatch);
        sharifSirWednesdayBatch = getResources().getStringArray(R.array.sharifSirWednesdayBatch);
        sharifSirThursdayBatch = getResources().getStringArray(R.array.sharifSirThursdayBatch);

        sadiaMamSundayTime = getResources().getStringArray(R.array.sadiaMamSundayTime);
        sadiaMamMondayTime = getResources().getStringArray(R.array.sadiaMamMondayTime);
        sadiaMamTuesdayTime = getResources().getStringArray(R.array.sadiaMamTuesdayTime);
        sadiaMamWednesdayTime = getResources().getStringArray(R.array.sadiaMamWednesdayTime);
        sadiaMamThursdayTime = getResources().getStringArray(R.array.sadiaMamThursdayTime);
        sadiaMamSundayCourse = getResources().getStringArray(R.array.sadiaMamSundayCourse);
        sadiaMamMondayCourse = getResources().getStringArray(R.array.sadiaMamMondayCourse);
        sadiaMamTuesdayCourse = getResources().getStringArray(R.array.sadiaMamTuesdayCourse);
        sadiaMamWednesdayCourse = getResources().getStringArray(R.array.sadiaMamWednesdayCourse);
        sadiaMamThursdayCourse = getResources().getStringArray(R.array.sadiaMamThursdayCourse);
        sadiaMamSundayBatch = getResources().getStringArray(R.array.sadiaMamSundayBatch);
        sadiaMamMondayBatch = getResources().getStringArray(R.array.sadiaMamMondayBatch);
        sadiaMamTuesdayBatch = getResources().getStringArray(R.array.sadiaMamTuesdayBatch);
        sadiaMamWednesdayBatch = getResources().getStringArray(R.array.sadiaMamWednesdayBatch);
        sadiaMamThursdayBatch = getResources().getStringArray(R.array.sadiaMamThursdayBatch);

        arifulSirSundayTime = getResources().getStringArray(R.array.arifulSirSundayTime);
        arifulSirMondayTime = getResources().getStringArray(R.array.arifulSirMondayTime);
        arifulSirTuesdayTime = getResources().getStringArray(R.array.arifulSirTuesdayTime);
        arifulSirWednesdayTime = getResources().getStringArray(R.array.arifulSirWednesdayTime);
        arifulSirThursdayTime = getResources().getStringArray(R.array.arifulSirThursdayTime);
        arifulSirSundayCourse = getResources().getStringArray(R.array.arifulSirSundayCourse);
        arifulSirMondayCourse = getResources().getStringArray(R.array.arifulSirMondayCourse);
        arifulSirTuesdayCourse = getResources().getStringArray(R.array.arifulSirTuesdayCourse);
        arifulSirWednesdayCourse = getResources().getStringArray(R.array.arifulSirWednesdayCourse);
        arifulSirThursdayCourse = getResources().getStringArray(R.array.arifulSirThursdayCourse);
        arifulSirSundayBatch = getResources().getStringArray(R.array.arifulSirSundayBatch);
        arifulSirMondayBatch = getResources().getStringArray(R.array.arifulSirMondayBatch);
        arifulSirTuesdayBatch = getResources().getStringArray(R.array.arifulSirTuesdayBatch);
        arifulSirWednesdayBatch = getResources().getStringArray(R.array.arifulSirWednesdayBatch);
        arifulSirThursdayBatch = getResources().getStringArray(R.array.arifulSirThursdayBatch);

        rakibSirSundayTime = getResources().getStringArray(R.array.rakibSirSundayTime);
        rakibSirMondayTime = getResources().getStringArray(R.array.rakibSirMondayTime);
        rakibSirTuesdayTime = getResources().getStringArray(R.array.rakibSirTuesdayTime);
        rakibSirWednesdayTime = getResources().getStringArray(R.array.rakibSirWednesdayTime);
        rakibSirThursdayTime = getResources().getStringArray(R.array.rakibSirThursdayTime);
        rakibSirSundayCourse = getResources().getStringArray(R.array.rakibSirSundayCourse);
        rakibSirMondayCourse = getResources().getStringArray(R.array.rakibSirMondayCourse);
        rakibSirTuesdayCourse = getResources().getStringArray(R.array.rakibSirTuesdayCourse);
        rakibSirWednesdayCourse = getResources().getStringArray(R.array.rakibSirWednesdayCourse);
        rakibSirThursdayCourse = getResources().getStringArray(R.array.rakibSirThursdayCourse);
        rakibSirSundayBatch = getResources().getStringArray(R.array.rakibSirSundayBatch);
        rakibSirMondayBatch = getResources().getStringArray(R.array.rakibSirMondayBatch);
        rakibSirTuesdayBatch = getResources().getStringArray(R.array.rakibSirTuesdayBatch);
        rakibSirWednesdayBatch = getResources().getStringArray(R.array.rakibSirWednesdayBatch);
        rakibSirThursdayBatch = getResources().getStringArray(R.array.rakibSirThursdayBatch);

        amenaMamSundayTime = getResources().getStringArray(R.array.amenaMamSundayTime);
        amenaMamMondayTime = getResources().getStringArray(R.array.amenaMamMondayTime);
        amenaMamTuesdayTime = getResources().getStringArray(R.array.amenaMamTuesdayTime);
        amenaMamWednesdayTime = getResources().getStringArray(R.array.amenaMamWednesdayTime);
        amenaMamThursdayTime = getResources().getStringArray(R.array.amenaMamThursdayTime);
        amenaMamSundayCourse = getResources().getStringArray(R.array.amenaMamSundayCourse);
        amenaMamMondayCourse = getResources().getStringArray(R.array.amenaMamMondayCourse);
        amenaMamTuesdayCourse = getResources().getStringArray(R.array.amenaMamTuesdayCourse);
        amenaMamWednesdayCourse = getResources().getStringArray(R.array.amenaMamWednesdayCourse);
        amenaMamThursdayCourse = getResources().getStringArray(R.array.amenaMamThursdayCourse);
        amenaMamSundayBatch = getResources().getStringArray(R.array.amenaMamSundayBatch);
        amenaMamMondayBatch = getResources().getStringArray(R.array.amenaMamMondayBatch);
        amenaMamTuesdayBatch = getResources().getStringArray(R.array.amenaMamTuesdayBatch);
        amenaMamWednesdayBatch = getResources().getStringArray(R.array.amenaMamWednesdayBatch);
        amenaMamThursdayBatch = getResources().getStringArray(R.array.amenaMamThursdayBatch);
    }

    @Override
    public void onClick(View v) {

        String teacherName = teacherNamePicker.getSelectedItem().toString();
        String day = dayPicker.getSelectedItem().toString();

        if(v.getId() == R.id.teacherShowDetails) {

            switch (teacherName) {
                case "Md. Tofael Ahmed":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, tofaelSirSundayTime, tofaelSirSundayCourse, tofaelSirSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, tofaelSirMondayTime, tofaelSirMondayCourse, tofaelSirMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, tofaelSirTuesdayTime, tofaelSirTuesdayCourse, tofaelSirTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, tofaelSirWednesdayTime, tofaelSirWednesdayCourse, tofaelSirWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, tofaelSirThursdayTime, tofaelSirThursdayCourse, tofaelSirThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Md. Imran Hossain":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, imranSirSundayTime, imranSirSundayCourse, imranSirSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, imranSirMondayTime, imranSirMondayCourse, imranSirMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, imranSirTuesdayTime, imranSirTuesdayCourse, imranSirTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, imranSirWednesdayTime, imranSirWednesdayCourse, imranSirWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, imranSirThursdayTime, imranSirThursdayCourse, imranSirThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Md. Mehedi Hasan":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, mehediSirSundayTime, mehediSirSundayCourse, mehediSirSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, mehediSirMondayTime, mehediSirMondayCourse, mehediSirMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, mehediSirTuesdayTime, mehediSirTuesdayCourse, mehediSirTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, mehediSirWednesdayTime, mehediSirWednesdayCourse, mehediSirWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, mehediSirThursdayTime, mehediSirThursdayCourse, mehediSirThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Md. Sharif Hossen":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, sharifSirSundayTime, sharifSirSundayCourse, sharifSirSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, sharifSirMondayTime, sharifSirMondayCourse, sharifSirMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, sharifSirTuesdayTime, sharifSirTuesdayCourse, sharifSirTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, sharifSirWednesdayTime, sharifSirWednesdayCourse, sharifSirWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, sharifSirThursdayTime, sharifSirThursdayCourse, sharifSirThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Sadia Sultana":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, sadiaMamSundayTime, sadiaMamSundayCourse, sadiaMamSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, sadiaMamMondayTime, sadiaMamMondayCourse, sadiaMamMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, sadiaMamTuesdayTime, sadiaMamTuesdayCourse, sadiaMamTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, sadiaMamWednesdayTime, sadiaMamWednesdayCourse, sadiaMamWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, sadiaMamThursdayTime, sadiaMamThursdayCourse, sadiaMamThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Md. Ariful Islam":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, arifulSirSundayTime, arifulSirSundayCourse, arifulSirSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, arifulSirMondayTime, arifulSirMondayCourse, arifulSirMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, arifulSirTuesdayTime, arifulSirTuesdayCourse, arifulSirTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, arifulSirWednesdayTime, arifulSirWednesdayCourse, arifulSirWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, arifulSirThursdayTime, arifulSirThursdayCourse, arifulSirThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Md. Rakib Hasan":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, rakibSirSundayTime, rakibSirSundayCourse, rakibSirSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, rakibSirMondayTime, rakibSirMondayCourse, rakibSirMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, rakibSirTuesdayTime, rakibSirTuesdayCourse, rakibSirTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, rakibSirWednesdayTime, rakibSirWednesdayCourse, rakibSirWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, rakibSirThursdayTime, rakibSirThursdayCourse, rakibSirThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Amena Begum":
                    switch (day) {
                        case "Sunday":
                            customAdapter = new CustomAdapter(this, amenaMamSundayTime, amenaMamSundayCourse, amenaMamSundayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Monday":
                            customAdapter = new CustomAdapter(this, amenaMamMondayTime, amenaMamMondayCourse, amenaMamMondayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Tuesday":
                            customAdapter = new CustomAdapter(this, amenaMamTuesdayTime, amenaMamTuesdayCourse, amenaMamTuesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Wednesday":
                            customAdapter = new CustomAdapter(this, amenaMamWednesdayTime, amenaMamWednesdayCourse, amenaMamWednesdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                        case "Thursday":
                            customAdapter = new CustomAdapter(this, amenaMamThursdayTime, amenaMamThursdayCourse, amenaMamThursdayBatch);
                            teacherListView.setAdapter(customAdapter);
                            break;
                    }
                    break;
                case "Select name":
                    switch (day) {
                        case "Select a day":
                            teacherListView.setAdapter(null);
                            break;
                    }
                    break;
            }
        }
    }
}
