package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.Serializable;

public class AddTaskActivity extends AppCompatActivity {

    RadioGroup taskTypeButtonGroup;
    Button backButton;
    Button confirmButton;
    EditText titleTextBox;
    EditText descriptionTextBox;
    Task newTask;


    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_add_task);

        //Find GUI components
        taskTypeButtonGroup = findViewById(R.id.TaskTypeGroup);
        backButton = findViewById(R.id.RevertButton);
        confirmButton = findViewById(R.id.ConfirmButton);
        titleTextBox = findViewById(R.id.TitleTextBox);
        descriptionTextBox = findViewById(R.id.DescriptionTextMultiLine);

        //Set listeners
        backButton.setOnClickListener(backButtonOnClickListener);
        confirmButton.setOnClickListener(confirmButtonOnClickListener);
    }

    //Go back to main page when back button is clicked
    private final View.OnClickListener backButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            AddTaskActivity.this.startActivity(i);
        }
    };

    //Go back to main page and update with new task
    private final View.OnClickListener confirmButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Get title and description text
            String title = String.valueOf(titleTextBox.getText());
            String description = String.valueOf(descriptionTextBox.getText());
            String taskType;
            RadioButton selectedButton;
            LinearLayout newTaskLayout;

            //Get the type of task based on radio group
            int selectedButtonId = taskTypeButtonGroup.getCheckedRadioButtonId();

            //Get button that was selected
            selectedButton = findViewById(selectedButtonId);

            //Get taskType value
            taskType = (String) selectedButton.getText();

            //Create a task object method
            newTask = createTask(selectedButtonId, title, description, taskType, "");

            //Create TaskLayout object
            //newTaskLayout = createTaskLayout();
            newTaskLayout = new LinearLayout(getApplicationContext());
            newTaskLayout = findViewById(R.id.TaskLayout);
            View buttonView = newTaskLayout.getChildAt(0);
            Log.i("Spencer Lefever", (String) buttonView.getContentDescription());

            //Go back to main view
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//
//            //TODO Put newTaskLayout data into intent
//            //Create bundle object and put TaskLayout object in
//            Bundle b = new Bundle();
//            b.putSerializable("TaskLayoutObject", (Serializable) newTaskLayout);
//
//            //Add bundle object to intent extras
//            intent.putExtra("TaskLayout", b);
//
//            //Go to main task
//            AddTaskActivity.this.startActivity(intent);


        } //End of onClick

        private Task createTask(int id, String title, String description, String type, String color) {
            Task newTask;

            //Check which button was pressed and create appropriate object
            if(id==R.id.EventTaskButton) {
                newTask = new EventTask(title, description, type, color);
            } else if(id==R.id.SchoolTaskButton) {
                newTask = new SchoolTask(title, description, type, color);
            } else if(id==R.id.PersonalTaskButton) {
                newTask = new PersonalTask(title, description, type, color);
            } else {
                newTask = null;
            }
            return newTask;
        }

        private TaskLayout createTaskLayout() {
            //TaskLayout and data members
            TaskLayout newTaskLayout = new TaskLayout(getApplicationContext(), newTask);

            return newTaskLayout;
        }

    }; //End of confirmButtonListener


}