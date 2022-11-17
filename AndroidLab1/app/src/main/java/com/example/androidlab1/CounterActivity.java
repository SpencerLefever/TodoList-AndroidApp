package com.example.androidlab1;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.*;
import android.widget.*;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//import com.example.androidlab1.databinding.ActivityCounterBinding;

public class CounterActivity extends AppCompatActivity {

    private int count = 0;
    private TextView countTextView;
    //private Counter counter;
    private Button addButton;

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_counter);

        //counter = new Counter();
        count=0;

        countTextView = findViewById(R.id.CounterTextView);
        addButton = findViewById(R.id.AddButton);

        addButton.setOnClickListener(addOnClickListener);
    }

    private final View.OnClickListener addOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            counter.addCount();
//            countTextView.setText(counter.getCount());
            countTextView.setText(++count + "");
            Log.i("CounterActivity", "Spencer Lefever " + count);
        }
    };
}
