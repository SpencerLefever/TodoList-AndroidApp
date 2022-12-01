package com.example.todolist;

import android.content.Context;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class TaskLayout extends LinearLayout {
    CheckBox taskCheckBox;
    Button taskButton;
    Button deleteButton;

    public TaskLayout(Context context, Task task) {
        super(context);
        initTaskButton(task);

        initTaskLayout(context);
    }

    private void initTaskButton(Task task) {
        taskButton.setText(task.title);
    }

    private void initTaskLayout(Context context) {
        taskCheckBox = findViewById(R.id.TaskCheckBox);
        taskButton = findViewById(R.id.TaskButton);
        deleteButton = findViewById(R.id.DeleteTaskButton);

        addView(taskCheckBox);
        addView(taskButton);
        addView(deleteButton);
    }

}
