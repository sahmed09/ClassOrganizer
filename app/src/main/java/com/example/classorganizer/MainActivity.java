package com.example.classorganizer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        studentCardView = findViewById(R.id.studentSchedule);
        teacherCardView = findViewById(R.id.teacherSchedule);

        studentCardView.setOnClickListener(this);
        teacherCardView.setOnClickListener(this);

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

    @Override
    public void onBackPressed() {

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

    //creating action bar option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.shareId) {

            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "Class Routine App";
            String body = "Help to know the time schedule of class.\n com.example.classorganizer";

            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);

            startActivity(Intent.createChooser(intent, "Share with "));
        }
        else if(item.getItemId() == R.id.feedbackId) {

            intent = new Intent(getApplicationContext(),FeedbackActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId() == R.id.aboutUsId) {

            intent = new Intent(getApplicationContext(), AboutUsActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId() == R.id.fullRoutineId) {

            intent = new Intent();
        }
        return super.onOptionsItemSelected(item);
    }
}
