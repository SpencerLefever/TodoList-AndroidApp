package com.example.todolist;

//Interface for types of tasks in TodoList
public abstract class Task {
    String title;
    String description;
    String type;

    abstract Task getTask();
    abstract void setTask();
}
