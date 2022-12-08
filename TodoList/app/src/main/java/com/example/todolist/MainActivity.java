package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //User model to hold task data
    User user;
    int numTasks = 0;

    //Variables for settings and add task buttons
    private Button settingsButton;
    private Button addTaskButton;
    private LayoutInflater layoutInflater;

    private CheckBox taskCheckBox;
    private Button taskButton;
    private Button deleteButton;
    private RecyclerView multiTaskLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = User.getInstance();

        updateModel();

        //Update view
        multiTaskLayout = findViewById(R.id.MultiTaskLayout);
        TaskLayoutRecyclerViewAdapter adapter = new TaskLayoutRecyclerViewAdapter(this, user);
        multiTaskLayout.setAdapter(adapter);
        multiTaskLayout.setLayoutManager(new LinearLayoutManager(this));


        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Find settings and add buttons by id
        settingsButton = findViewById(R.id.SettingsButton);
        addTaskButton = findViewById(R.id.AddTaskButton);

        //Add onClickListeners to settings and add task buttons
        settingsButton.setOnClickListener(settingsOnClickListener);
        addTaskButton.setOnClickListener(addTaskOnClickListener);
    } //End of onCreate()

    public void updateModel() {
        Intent intent = getIntent();

        //Get new task from the intent
        Task newTask = intent.getParcelableExtra("NewTask");

        if(newTask == null) {
            return;
        }
        user.addTask(newTask);
    }

    //Go Add tasks activity when add button is clicked
    private final View.OnClickListener addTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.v("Add Task", "Add task clicked");
            Intent i = new Intent(getApplicationContext(), AddTaskActivity.class);
            MainActivity.this.startActivity(i);
        }
    };

    //Go to expanded task activity when an activity is clicked
    private final View.OnClickListener expandedTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Find which task was clicked based on title


            Intent i = new Intent(getApplicationContext(), ExpandedTaskActivity.class);
            MainActivity.this.startActivity(i);
        }
    };

    public void expandTask(View view){
        Button selectedTaskBtn = (Button) view;
        String taskTitle = (String) selectedTaskBtn.getText();

        Task selectedTask = user.getTaskByTitle(taskTitle);

        Intent intent = new Intent(getApplicationContext(), ExpandedTaskActivity.class);

        intent.putExtra("SelectedTask", selectedTask);

        MainActivity.this.startActivity(intent);

    }

    //TODO Animate the taskLayout view to swipe either left or right based on deletion or completion

    //Listener to delete a task from the list
    private final View.OnClickListener deleteTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            deleteTask(view);
        }
    };

    public void deleteTask(View view) {

        multiTaskLayout.removeView(view);
    }

    //Listener to complete a task from the list
    private final View.OnClickListener completeTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            deleteTask(view);
        }
    };

    //Go to settings page when settings button is clicked
    private final View.OnClickListener settingsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
            MainActivity.this.startActivity(i);
        }
    };
} //End of MainActivityClass