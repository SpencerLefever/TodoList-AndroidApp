package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_settings);

        //backButton = findViewById(R.id.BackButton);
    }

    //Go back to main page when back button is clicked
    private final View.OnClickListener backButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            SettingsActivity.this.startActivity(i);
        }
    };

}