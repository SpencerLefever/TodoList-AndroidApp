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
import android.media.MediaPlayer;

public class AddTaskActivity extends AppCompatActivity {

    RadioGroup taskTypeButtonGroup;
    Button backButton;
    Button confirmButton;
    EditText titleTextBox;
    EditText descriptionTextBox;
    Task newTask;
    int theme;
    // Media player for add task sound
    MediaPlayer taskAdded;



    @Override
    protected void onStart() {
        theme = getIntent().getIntExtra("Theme", R.style.Theme_TodoList);
        setTheme(theme);
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

        //Media players for add task sound
        taskAdded = MediaPlayer.create(this, R.raw.taskadded);
    }

    //Go back to main page when back button is clicked
    private final View.OnClickListener backButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putExtra("Theme", theme);
            AddTaskActivity.this.startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
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
            intent.putExtra("Theme", theme);

            //Play added task sound
            taskAdded.start();

            //Go to main task
            AddTaskActivity.this.startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        } //End of onClick

        private Task createTask() {
            Task newTask;
            boolean inputValidation;
            //Get title and description text
            String title = String.valueOf(titleTextBox.getText());
            String description = String.valueOf(descriptionTextBox.getText());
            String taskType;
            RadioButton selectedButton;

            //Boolean to check for empty text fields and no button pressed in radio group
            inputValidation = title.equals("") || description.equals("") || (taskTypeButtonGroup.getCheckedRadioButtonId() == -1);

            //Return null task if input is invalid
            if(inputValidation) {
                return null;
            }

            //Get the type of task based on radio group
            int selectedButtonId = taskTypeButtonGroup.getCheckedRadioButtonId();
            //Get button that was selected
            selectedButton = findViewById(selectedButtonId);

            //Get taskType value
            taskType = (String) selectedButton.getText();

            newTask = new Task(title, description, taskType);
            return newTask;
        }
    }; //End of confirmButtonListener


}