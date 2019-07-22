package com.example.classorganizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText, emailEditText, usernameEditText, accountTypeEditText, passwordEditText, confirmPasswordEditText;
    Button signUpButton;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Sign Up");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //adding back button on Toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        usernameEditText = findViewById(R.id.userNameSignUp);
        accountTypeEditText = findViewById(R.id.accountType);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

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
        String confirmPassword = confirmPasswordEditText.getText().toString();

        //checking username is already taken or not
        Boolean findUsername = databaseHelper.findUsername(username);

        boolean accountCheck = false;
        boolean matchPassword = false;
        if(accountType.equals("student") || accountType.equals("teacher")){
            accountCheck = true;
        }
        if(confirmPassword.equals(password)){
            matchPassword = true;
        }
        if(name.isEmpty()) {
            nameEditText.setError("Enter your name");
            nameEditText.requestFocus();
        }
        else if(email.isEmpty()) {
            emailEditText.setError("Enter your email address");
            emailEditText.requestFocus();
        }
        else if(username.isEmpty()) {
            usernameEditText.setError("Enter user name");
            usernameEditText.requestFocus();
        }
        else if(findUsername) {
            usernameEditText.setError("username already taken");
            usernameEditText.requestFocus();
        }
        else if(accountType.isEmpty()) {
            accountTypeEditText.setError("Enter account type");
            accountTypeEditText.requestFocus();
        }
        else if(!accountCheck){
            accountTypeEditText.setError("Please check your spelling");
            accountTypeEditText.requestFocus();
        }
        else if(password.isEmpty()) {
            passwordEditText.setError("Enter password");
            passwordEditText.requestFocus();
        }
        else if(password.length()<5) {
            passwordEditText.setError("Insert at least 5 characters");
            passwordEditText.requestFocus();
        }
        else if(confirmPassword.isEmpty()) {
            confirmPasswordEditText.setError("Retype your password");
            confirmPasswordEditText.requestFocus();
        }
        else if(!matchPassword) {
            confirmPasswordEditText.setError("Password didn't match");
            confirmPasswordEditText.requestFocus();
        }
        else {

            userDetails.setName(name);
            userDetails.setEmail(email);
            userDetails.setUsername(username);
            userDetails.setAccountType(accountType);
            userDetails.setPassword(password);

            long rowId = databaseHelper.insertData(userDetails);

            if(rowId == -1) {
                Toast.makeText(getApplicationContext(),"Registration failed",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Registration completed",Toast.LENGTH_LONG).show();
                nameEditText.setText("");
                emailEditText.setText("");
                usernameEditText.setText("");
                accountTypeEditText.setText("");
                passwordEditText.setText("");
            }
        }
    }
}
