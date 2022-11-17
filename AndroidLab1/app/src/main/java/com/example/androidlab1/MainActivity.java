package com.example.androidlab1;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.*;
import android.widget.*;
//import androidx.navigation.NavController;

public class MainActivity extends AppCompatActivity {


        private boolean hello;
        //private Counter counter;
        private int count;
        private TextView textView;
        private TextView countTextView;
        private Button button;
        private Button counterButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                textView = findViewById(R.id.TextView);
                //counter = new Counter();
                //countTextView = findViewById(R.id.CountTextView);

                button = findViewById(R.id.button);

                counterButton = findViewById(R.id.counterButton);

                hello = true;

                button.setOnClickListener(onClickListener);
                counterButton.setOnClickListener(counterOnClickListener);
        }


        private final View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        if(hello) {
                                hello = false;
                                textView.setText("Goodbye");
                        }
                        else {
                                hello = true;
                                textView.setText("Hello");
                        }
                        //countTextView.setText(++count);
                        //counter.addCount();
                        //countTextView.setText(counter.getCount());
                }
        };

        private final View.OnClickListener counterOnClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        Intent i = new Intent(getApplicationContext(), CounterActivity.class);
                        MainActivity.this.startActivity(i);
                }
        };

}
