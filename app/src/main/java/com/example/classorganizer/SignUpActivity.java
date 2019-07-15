package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, emailEditText, usernameEditText, accountTypeEditText, passwordEditText;
    Button signUpButton;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //adding back button on Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        usernameEditText = findViewById(R.id.userNameSignUp);
        accountTypeEditText = findViewById(R.id.accountType);
        passwordEditText = findViewById(R.id.passwordEditText);

        signUpButton = findViewById(R.id.signUpButton);

        databaseHelper = new DatabaseHelper(this);
        userDetails = new UserDetails();
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String accountType = accountTypeEditText.getText().toString().toLowerCase();
        String password = passwordEditText.getText().toString();

        Boolean accountCheck = false;
        if(accountType.equals("student") || accountType.equals("teacher")){
            accountCheck=true;
        }
        if(!accountCheck){
            accountTypeEditText.setError("Please check your spelling");
            accountTypeEditText.requestFocus();
            return;
        }
        if(name.isEmpty()) {
            nameEditText.setError("Please enter name");
            nameEditText.requestFocus();
            return;
        }
        else if(email.isEmpty()) {
            emailEditText.setError("Please enter your email address");
            emailEditText.requestFocus();
            return;
        }
        else if(username.isEmpty()) {
            usernameEditText.setError("Please enter the user name");
            usernameEditText.requestFocus();
            return;
        }
        else if(accountType.isEmpty()) {
            accountTypeEditText.setError("Please enter account type");
            accountTypeEditText.requestFocus();
            return;
        }
        else if(password.isEmpty()) {
            passwordEditText.setError("Please enter password");
            passwordEditText.requestFocus();
            return;
        }
        else if(password.length()<5) {
            passwordEditText.setError("Insert at least 5 characters");
            passwordEditText.requestFocus();
            return;
        }
        else {

            userDetails.setName(name);
            userDetails.setEmail(email);
            userDetails.setUsername(username);
            userDetails.setAccountType(accountType);
            userDetails.setPassword(password);

            long rowId = databaseHelper.insertData(userDetails);

            if(rowId == -1) {
                Toast.makeText(getApplicationContext(),"Data insertion failed",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Data is successfully inserted",Toast.LENGTH_LONG).show();
                nameEditText.setText("");
                emailEditText.setText("");
                usernameEditText.setText("");
                accountTypeEditText.setText("");
                passwordEditText.setText("");
            }
        }
    }
}
