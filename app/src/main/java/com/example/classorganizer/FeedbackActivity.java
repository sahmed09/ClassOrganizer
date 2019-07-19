package com.example.classorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    Button feedbackSendButton,feedbackClearButton;
    EditText feedbackNameEditText, feedbackMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //changing title bar name
        this.setTitle("Feedback");

        //adding back button on Toolbar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        feedbackSendButton = findViewById(R.id.feedbackSendButton);
        feedbackClearButton = findViewById(R.id.feedbackClearButton);
        feedbackNameEditText = findViewById(R.id.feedbackNameEditText);
        feedbackMessageEditText = findViewById(R.id.feedbackMessageEditText);

        feedbackSendButton.setOnClickListener(this);
        feedbackClearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {

            String name = feedbackNameEditText.getText().toString();
            String message = feedbackMessageEditText.getText().toString();

            if(v.getId() == R.id.feedbackSendButton) {

                if(name.isEmpty()) {
                    feedbackNameEditText.setError("Please enter your name");
                    feedbackNameEditText.requestFocus();
                }
                else if(message.isEmpty()) {
                    feedbackMessageEditText.setError("Please enter your message");
                    feedbackMessageEditText.requestFocus();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");

                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shihab.ict.cou@gmail.com"});

                    intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                    intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\nMessage : " + message);

                    startActivity(Intent.createChooser(intent, "Feedback with "));
                }
            }
            else {
                feedbackNameEditText.setText("");
                feedbackMessageEditText.setText("");
            }
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(),"Exception : " + e, Toast.LENGTH_SHORT).show();
        }
    }
}
