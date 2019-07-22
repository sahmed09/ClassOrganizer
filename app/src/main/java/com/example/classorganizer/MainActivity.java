package com.example.classorganizer;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText usernameEditText,passwordEditText;
    Button loginButton,signUpHereButton;
    Intent intent;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //hiding the action bar
        //getSupportActionBar().hide();
        //hiding the title bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.userName);
        passwordEditText = findViewById(R.id.password);

        loginButton = findViewById(R.id.loginButton);
        signUpHereButton = findViewById(R.id.signUpHereButton);

        loginButton.setOnClickListener(this);
        signUpHereButton.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(v.getId() == R.id.loginButton) {
            if(username.isEmpty()) {
                usernameErrorMessage();
            }
            else if(password.isEmpty()) {
                passwordErrorMessage();
            }
            else {
                //checking username and password
                Boolean result = databaseHelper.findPassword(username,password);

                if(result) {
                    //checking account type
                    String accountCheck = databaseHelper.findAccount(username);
                    if(accountCheck.equals("student")) {
                        intent = new Intent(MainActivity.this,Student.class);
                        startActivity(intent);
                    }
                    else if(accountCheck.equals("teacher")) {
                        intent = new Intent(MainActivity.this,Teacher.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"username and password didn't match",Toast.LENGTH_LONG).show();
                }
            }
        }
        else if (v.getId() == R.id.signUpHereButton){

            intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }

    //username error message generator
    public void usernameErrorMessage() {
        usernameEditText.setError("Enter user name");
        usernameEditText.requestFocus();
    }

    //password error message generator
    public void passwordErrorMessage() {
        passwordEditText.setError("Enter a valid password");
        passwordEditText.requestFocus();
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
