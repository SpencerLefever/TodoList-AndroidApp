package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
    TextView settings;
    TextView fonts;
    TextView themes;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        theme = getIntent().getIntExtra("Theme", R.style.Theme_TodoList);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settings = (TextView) findViewById(R.id.textView);
        fonts = (TextView) findViewById(R.id.textView2);
        themes = (TextView) findViewById(R.id.textView3);
        backButton = findViewById(R.id.Back);
        Log.i("SettingsTask", "Oncreate invoked theme: " + theme);

        backButton.setOnClickListener(backButtonOnClickListener);
    }

    public void red(View view){
//        RelativeLayout relativeLayout = findViewById(R.id.rl);
//        relativeLayout.setBackgroundColor(Color.RED);
        theme=R.style.Theme_Red;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void blue(View view){
//        RelativeLayout relativeLayout = findViewById(R.id.rl);
//        relativeLayout.setBackgroundColor(Color.BLUE);
        theme=R.style.Theme_Blue;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void yellow(View view){
//        RelativeLayout relativeLayout = findViewById(R.id.rl);
//        relativeLayout.setBackgroundColor(Color.YELLOW);
        theme=R.style.Theme_Yellow;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void white(View view){
//        RelativeLayout relativeLayout = findViewById(R.id.rl);
//        relativeLayout.setBackgroundColor(Color.WHITE);
        theme=R.style.Theme_TodoList;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void magenta(View view){
//        RelativeLayout relativeLayout = findViewById(R.id.rl);
//        relativeLayout.setBackgroundColor(Color.MAGENTA);
        theme=R.style.Theme_Magenta;
        getIntent().putExtra("Theme", theme);
        recreate();
    }

    public void serif(View view){
        settings.setTypeface(Typeface.SERIF);
        themes.setTypeface(Typeface.SERIF);
        fonts.setTypeface(Typeface.SERIF);
    }

    public void monospace(View view){
        settings.setTypeface(Typeface.MONOSPACE);
        themes.setTypeface(Typeface.MONOSPACE);
        fonts.setTypeface(Typeface.MONOSPACE);
    }

    //Go back to main page when back button is clicked
    private final View.OnClickListener backButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("Theme", theme);
            SettingsActivity.this.startActivity(i);
        }
    };
}

