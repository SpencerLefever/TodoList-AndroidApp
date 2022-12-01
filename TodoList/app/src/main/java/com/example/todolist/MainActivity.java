package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //User model to hold task data
    User user;
    int numTasks = 0;

    //Variables for settings and add task buttons
    private Button settingsButton;
    private Button addTaskButton;

    //Variables for task layout components
    private LinearLayout multiTaskLayout;
//    private TaskLayout taskLayout;
//    private LinearLayout taskLayout;
//    private CheckBox taskCheckBox;
//    private Button taskButton;
//    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call model constructor
        user = new User();
        updateMultiTaskView();

        //Find settings and add buttons by id
        settingsButton = findViewById(R.id.SettingsButton);
        addTaskButton = findViewById(R.id.AddTaskButton);

        //Find MultiTaskLayout by id
        multiTaskLayout = findViewById(R.id.MultiTaskLayout);


        //Add onClickListeners to settings and add task buttons
        settingsButton.setOnClickListener(settingsOnClickListener);
        addTaskButton.setOnClickListener(addTaskOnClickListener);


    } //End of onCreate()

    //Override onResume method to update task view
    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Main activity restarted", Toast.LENGTH_LONG).show();
        if(true) {

            Intent intent = getIntent();

            //Get new task from the intent
            Task newTask = intent.getParcelableExtra("NewTask");

            if(newTask != null) {
                Log.v("New Task Resume", "Main activity resumed");
                Log.v("New Task Description", "Description " + newTask.getDescription());
                Log.v("New Task Title", newTask.getTitle());
                Log.v("New Task Type", newTask.getType());

                addToView(newTask);
            }
            else {
                Log.v("New Task Resume", "Main Activity Resumes could not find newTask");
            }
        }
    }

    //Go Add tasks activity when add button is clicked
    private final View.OnClickListener addTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), AddTaskActivity.class);
            MainActivity.this.startActivity(i);
        }
    };

    //Go to expanded task activity when an activity is clicked
    private final View.OnClickListener expandedTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), ExpandedTaskActivity.class);
            MainActivity.this.startActivity(i);
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

    //TODO Animate the taskLayout view to swipe either left or right based on deletion or completion

    //Listener to delete a task from the list
    private final View.OnClickListener deleteTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            multiTaskLayout.removeView((View) view.getParent());

            //Remove the task from the model
        }
    };

    //Listener to complete a task from the list
    private final View.OnClickListener completeTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            multiTaskLayout.removeView((View) view.getParent());

            TaskLayout tl = (TaskLayout) view.getParent();
            //Remove the task from the model
            //user.taskArray.remove();
        }
    };


    //Method to check model task array to update if needed
    //This method call addToView() which calls setTaskLayoutListeners()
    public void updateMultiTaskView() {

    }

    //Method to add a task object to the view
    public void addToView(Task task) {
        //Create task layout object to be populated and added to the view
        TaskLayout tl = new TaskLayout(getApplicationContext(), task);

        setTaskLayoutListeners(tl);

        Toast.makeText(this, "Adding new task to view", Toast.LENGTH_LONG).show();

        multiTaskLayout.setVisibility(View.VISIBLE);
        multiTaskLayout.addView(tl);
    }

    //Method to set the onClick listeners for the different components of the task layout
    public void setTaskLayoutListeners(TaskLayout tl) {
        tl.taskCheckBox.setOnClickListener(completeTaskOnClickListener);
        tl.taskButton.setOnClickListener(expandedTaskOnClickListener);
        tl.deleteButton.setOnClickListener(deleteTaskOnClickListener);
    }

} //End of MainActivityClass