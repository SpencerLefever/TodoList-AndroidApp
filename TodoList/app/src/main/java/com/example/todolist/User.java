package com.example.todolist;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    ArrayList taskArray;
    final int MAXTASKS = 20;

    public User() {
        taskArray = new ArrayList<Task>();

        //Add default task to the list
        addBaseTask();
    }

    public void addBaseTask() {
        //Call constructor
        String title = "Basic Task";
        String description = "Basic task created as default task for user to see layout";
        String type = "Personal";
        String color = "null";
        Task baseTask = new Task(title, description, type);

        //Add task to the list
        taskArray.add(baseTask);

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

    public ArrayList<Task> getTaskArray() {
        return taskArray;
    }
}
