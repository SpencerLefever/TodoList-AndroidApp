package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
            Task newTask;

            //Call create task method to populate newTask with necessary data
            newTask = createTask();

            //Go to main task
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            //Add bundle object to intent extras
            intent.putExtra("NewTask", newTask);

            //Go to main task
            AddTaskActivity.this.startActivity(intent);

        } //End of onClick

        private Task createTask() {
            Task newTask;
            //Get title and description text
            String title = String.valueOf(titleTextBox.getText());
            String description = String.valueOf(descriptionTextBox.getText());
            String taskType;
            RadioButton selectedButton;

            //Get the type of task based on radio group
            int selectedButtonId = taskTypeButtonGroup.getCheckedRadioButtonId();
            //Get button that was selected
            selectedButton = findViewById(selectedButtonId);

            //Get taskType value
            taskType = (String) selectedButton.getText();

            newTask = new Task(title, description, taskType);
//            //Check which button was pressed and create appropriate object
//            if(selectedButtonId==R.id.EventTaskButton) {
//                newTask = new EventTask(title, description, taskType, null);
//            } else if(selectedButtonId==R.id.SchoolTaskButton) {
//                newTask = new SchoolTask(title, description, taskType, null);
//            } else if(selectedButtonId==R.id.PersonalTaskButton) {
//                newTask = new PersonalTask(title, description, taskType, null);
//            } else {
//                newTask = null;
//            }
            return newTask;
        }

//        private TaskLayout createTaskLayout() {
//            //TaskLayout and data members
//            TaskLayout newTaskLayout = new TaskLayout(getApplicationContext(), newTask);
//
//            return newTaskLayout;
//        }

    }; //End of confirmButtonListener


}