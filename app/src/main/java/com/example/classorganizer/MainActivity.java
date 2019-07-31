package com.example.classorganizer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    CardView studentCardView, teacherCardView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //hiding the action bar
        //getSupportActionBar().hide();
        //hiding the title bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //creating and controlling the hamburger icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        studentCardView = findViewById(R.id.studentSchedule);
        teacherCardView = findViewById(R.id.teacherSchedule);
        studentCardView.setOnClickListener(this);
        teacherCardView.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            /*case R.id.nav_home:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                drawerLayout.clearFocus();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;*/
            case R.id.nav_full_routine :
                intent = new Intent(getApplicationContext(), FullRoutine.class);
                startActivity(intent);
                drawerLayout.clearFocus();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_courses :
                intent = new Intent(getApplicationContext(), Courses.class);
                startActivity(intent);
                drawerLayout.clearFocus();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_about_us :
                intent = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(intent);
                drawerLayout.clearFocus();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_share :
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                String subject = "Class Routine App";
                String body = "Help to know the time schedule of class.\n com.example.classorganizer";

                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,body);

                startActivity(Intent.createChooser(intent, "Share with "));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_feedback :
                intent = new Intent(getApplicationContext(),FeedbackActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            AlertDialog.Builder alertDialogBuilder;
            alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

            alertDialogBuilder.setIcon(R.drawable.warning);
            alertDialogBuilder.setTitle("Exit");
            alertDialogBuilder.setMessage("Are you sure you want to exit?");
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.studentSchedule) {

            intent = new Intent(getApplicationContext(), Student.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.teacherSchedule) {

            intent = new Intent(getApplicationContext(), Teacher.class);
            startActivity(intent);
        }
    }

    //creating action bar option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_settings) {

            intent = new Intent();
        }
        return super.onOptionsItemSelected(item);
    }
}
