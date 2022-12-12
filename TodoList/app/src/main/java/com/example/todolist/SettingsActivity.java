package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    int theme;
    Button backButton;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        theme = getIntent().getIntExtra("Theme", R.style.Theme_TodoList);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        backButton = findViewById(R.id.Back);

        backButton.setOnClickListener(backButtonOnClickListener);

        relativeLayout = (RelativeLayout) findViewById(R.id.rl);
    }

    public void red(View view){
        theme=R.style.Theme_Red;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void blue(View view){
        theme=R.style.Theme_Blue;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void yellow(View view){
        theme=R.style.Theme_Yellow;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void white(View view){
        theme=R.style.Theme_TodoList;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void magenta(View view){
        theme=R.style.Theme_Magenta;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void christmas(View view){
        theme=R.style.Theme_Christmas;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void thanksgiving(View view){
        theme=R.style.Theme_Thanksgiving;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void winter(View view){
        theme=R.style.Theme_Winter;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    //Go back to main page when back button is clicked
    private final View.OnClickListener backButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("Theme", theme);
            SettingsActivity.this.startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    };

}

