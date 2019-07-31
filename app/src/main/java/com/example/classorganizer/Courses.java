package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Courses extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    CourseCustomAdapter courseCustomAdapter;
    int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        this.setTitle("Courses");
        //adding back button on Toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        prepareListData();
        
        expandableListView = findViewById(R.id.expandableListView);

        courseCustomAdapter = new CourseCustomAdapter(this, listDataHeader, listDataChild);
        expandableListView.setAdapter(courseCustomAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                if(lastExpandedPosition != -1 && lastExpandedPosition != groupPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });
    }

    private void prepareListData() {

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        listDataHeader.add("First Year First Semester");
        listDataHeader.add("First Year Second Semester");
        listDataHeader.add("Second Year First Semester");
        listDataHeader.add("Second Year Second Semester");
        listDataHeader.add("Third Year First Semester");
        listDataHeader.add("Third Year Second Semester");
        listDataHeader.add("Fourth Year First Semester");
        listDataHeader.add("Fourth Year Second Semester");

        List<String> first_year_first_semester = new ArrayList<>();
        first_year_first_semester.add("ICT-101: Mathematics-I");
        first_year_first_semester.add("ICT-103: Information Technology Fundamental");
        first_year_first_semester.add("ICT-105: Computer Programming(C)");
        first_year_first_semester.add("ICT-107: Bangladesh Studies");
        first_year_first_semester.add("ICT-109: Basic Electrical Engineering");
        first_year_first_semester.add("ICT-111: Physics");
        first_year_first_semester.add("ICT-106: Computer Programming Lab(C)");
        first_year_first_semester.add("ICT-110: Basic Electrical Engineering(Lab)");

        List<String> first_year_second_semester = new ArrayList<>();
        first_year_second_semester.add("ICT-201: Mathematics-II");
        first_year_second_semester.add("ICT-203: Statistics");
        first_year_second_semester.add("ICT-205: Electronic Circuits");
        first_year_second_semester.add("ICT-207: Discrete Mathematics");
        first_year_second_semester.add("ICT-209: Data Structure");
        first_year_second_semester.add("ICT-211: Economics");
        first_year_second_semester.add("ICT-206: Electronic Circuits Lab");
        first_year_second_semester.add("ICT-210: Data Structure Lab");
        first_year_second_semester.add("ICT-200: Viva-voce");

        List<String> second_year_first_semester = new ArrayList<>();
        second_year_first_semester.add("ICT-301 : Mathematics-III");
        second_year_first_semester.add("ICT-303 : Object Oriented Programming(C++)");
        second_year_first_semester.add("ICT-305 : Digital Logic Design");
        second_year_first_semester.add("ICT-307 : Algorithm Design and Analysis");
        second_year_first_semester.add("ICT-309 : Signals and Systems");
        second_year_first_semester.add("ICT-311 : Finance and Managerial Accounting");
        second_year_first_semester.add("ICT-304 : Object Oriented Programming(C++) Lab");
        second_year_first_semester.add("ICT-306 : Digital Logic Design Lab");
        second_year_first_semester.add("ICT-308 : Algorithm Design and Analysis Lab");

        List<String> second_year_second_semester = new ArrayList<>();
        second_year_second_semester.add("ICT-401 : Mathematics-IV");
        second_year_second_semester.add("ICT-403 : Electromagnetic Theory and Antenna");
        second_year_second_semester.add("ICT-405 : Microprocessor and Micro-controller");
        second_year_second_semester.add("ICT-407 : Numerical Methods");
        second_year_second_semester.add("ICT-409 : Database Management Systems");
        second_year_second_semester.add("ICT-411 : Computer Organization and Architecture");
        second_year_second_semester.add("ICT-406 : Microprocessor and Micro-controller Lab");
        second_year_second_semester.add("ICT-408 : Numerical Methods Lab");
        second_year_second_semester.add("ICT-410 : Database Management Systems Lab");
        second_year_second_semester.add("ICT-400 : Viva-voce");

        List<String> third_year_first_semester = new ArrayList<>();
        third_year_first_semester.add("ICT-501 : Microwave Engineering");
        third_year_first_semester.add("ICT-503 : Analog Communication");
        third_year_first_semester.add("ICT-505 : Software Engineering");
        third_year_first_semester.add("ICT-507 : Operating Systems");
        third_year_first_semester.add("ICT-509 : Object Oriented Programming(Java)");
        third_year_first_semester.add("ICT-511 : Computer Graphics");
        third_year_first_semester.add("ICT-502 : Microwave Engineering Lab");
        third_year_first_semester.add("ICT-504 : Analog Communication Lab");
        third_year_first_semester.add("ICT-506 : Software Engineering Lab");
        third_year_first_semester.add("ICT-508 : Operating Systems Lab");
        third_year_first_semester.add("ICT-510 : Object Oriented Programming(Java) Lab");
        third_year_first_semester.add("ICT-512 : Computer Graphics Lab");

        List<String> third_year_second_semester = new ArrayList<>();
        third_year_second_semester.add("ICT-601 : Digital Signal Processing");
        third_year_second_semester.add("ICT-603 : Digital Communication");
        third_year_second_semester.add("ICT-605 : Mobile Application and Game Development");
        third_year_second_semester.add("ICT-607 : Information Theory and Coding");
        third_year_second_semester.add("ICT-609 : Telecommunication Engineering");
        third_year_second_semester.add("ICT-602 : Digital Signal Processing Lab");
        third_year_second_semester.add("ICT-604 : Digital Communication Lab");
        third_year_second_semester.add("ICT-606 : Mobile Application and Game Development Lab");
        third_year_second_semester.add("ICT-600 : Viva-voce");

        List<String> fourth_year_first_semester = new ArrayList<>();
        fourth_year_first_semester.add("ICT-701 : Wireless and Mobile Communication Systems");
        fourth_year_first_semester.add("ICT-703 : Optical Fibre Communication");
        fourth_year_first_semester.add("ICT-705 : Web Technologies and Programming");
        fourth_year_first_semester.add("ICT-707 : Image Processing");
        fourth_year_first_semester.add("ICT-709 : VLSI Circuits Design");
        fourth_year_first_semester.add("ICT-711 : Data Communication and Computer Networks");
        fourth_year_first_semester.add("ICT-702 : Wireless and Mobile Communication Systems Lab");
        fourth_year_first_semester.add("ICT-704 : Optical Fibre Communication Lab");
        fourth_year_first_semester.add("ICT-706 : Web Technologies and Programming Lab");
        fourth_year_first_semester.add("ICT-708 : Image Processing Lab");
        fourth_year_first_semester.add("ICT-710 : VLSI Circuits Design Lab");
        fourth_year_first_semester.add("ICT-712 : Data Communication and Computer Networks Lab");

        List<String> fourth_year_second_semester = new ArrayList<>();
        fourth_year_second_semester.add("ICT-801 : E-commerce and E-governance");
        fourth_year_second_semester.add("ICT-803 : Artificial Intelligence and Expert System");
        fourth_year_second_semester.add("ICT-805 : Network Security and Cyber Law");
        fourth_year_second_semester.add("ICT-807 : Satellite and Radar Communication");
        fourth_year_second_semester.add("ICT-804 : Artificial Intelligence and Expert System Lab");
        fourth_year_second_semester.add("ICT-806 : Research Project");
        fourth_year_second_semester.add("ICT-800 : Viva-voce");

        listDataChild.put(listDataHeader.get(0), first_year_first_semester);
        listDataChild.put(listDataHeader.get(1), first_year_second_semester);
        listDataChild.put(listDataHeader.get(2), second_year_first_semester);
        listDataChild.put(listDataHeader.get(3), second_year_second_semester);
        listDataChild.put(listDataHeader.get(4), third_year_first_semester);
        listDataChild.put(listDataHeader.get(5), third_year_second_semester);
        listDataChild.put(listDataHeader.get(6), fourth_year_first_semester);
        listDataChild.put(listDataHeader.get(7), fourth_year_second_semester);
    }
}
