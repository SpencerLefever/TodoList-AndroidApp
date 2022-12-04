package com.example.todolist;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;

public class TaskLayout extends LinearLayout {
    CheckBox taskCheckBox;
    Button taskButton;
    Button deleteButton;

    public TaskLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.TaskLayout, defStyleAttr, defStyleRes);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TaskLayout);

        taskButton.setText(a.getString(R.styleable.TaskLayout_TaskTitle));


        arr.recycle();


//        initTaskLayout(task);
//
//        addChildren();
    }


    private void initTaskLayout(Task task) {
        taskCheckBox = findViewById(R.id.TaskCheckBox);
        taskButton = findViewById(R.id.TaskButton);
        deleteButton = findViewById(R.id.DeleteTaskButton);
        taskButton.setText(task.getTitle());
    }

    private void addChildren() {
        addView(taskCheckBox);
        addView(taskButton);
        addView(deleteButton);
    }
}
