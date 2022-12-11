package com.example.todolist;

import android.graphics.Color;
import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class User {
    private static User instance = null;

    ArrayList taskArray;
    final int MAXTASKS = 20;

    private User() {

        taskArray = new ArrayList<Task>();
    }

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    public void addTask(Task t) {
        if(taskArray.size() < MAXTASKS) {
            taskArray.add(t);
        } else {
            //TODO Tell user they are unable to add more than 20 tasks
        }
    }

    public void moveTask(Task task, int index) {
        Task taskBuf = task;
        removeTask(task);
        taskArray.add(index, taskBuf);
    }

    public void removeTask(Task t) {
        taskArray.remove(t);
    }

    public Task getTask(Task t) {
        int index = taskArray.indexOf(t);
        return (Task) taskArray.get(index);
    }

    public void swap(int index1, int index2) {
        Collections.swap(getTaskArray(), index1, index2);
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
