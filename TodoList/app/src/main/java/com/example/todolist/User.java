package com.example.todolist;

import android.graphics.Color;
import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private static User instance = null;

    ArrayList taskArray;
    final int MAXTASKS = 20;
    Typeface typeface;
    Color backgroundColor;

    private User() {

        taskArray = new ArrayList<Task>();


        //Add default task to the list
        //addBaseTask();
    }

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    private void addBaseTask() {
        //Call constructor
        String title = "Basic Task";
        String description = "Basic task created as default task for user to see layout";
        String type = "Personal";
        String color = "null";
//        Task baseTask = new Task(title, description, type);
//
//        //Add task to the list
//        taskArray.add(baseTask);

    }

    public Task getBaseTask() {
        return (Task) taskArray.get(0);
    }

    public void addTask(Task t) {
        if(taskArray.size() < MAXTASKS) {
            taskArray.add(t);
        } else {
            //TODO Tell user they are unable to add more than 20 tasks
        }
    }

    public void removeTask(Task t) {
        taskArray.remove(t);
    }

    public Task getTask(Task t) {
        int index = taskArray.indexOf(t);
        return (Task) taskArray.get(index);
    }

    public Task getTaskByIndex(int i) {
        return (Task) taskArray.get(i);
    }

    public ArrayList<Task> getTaskArray() {
        return taskArray;
    }

    public Task getTaskByTitle(String title) {
        for(Task task : getTaskArray()) {
            if(title == task.getTitle()) {
                return task;
            }
        }
        return null;
    }
}
