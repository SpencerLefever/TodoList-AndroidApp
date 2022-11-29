package com.example.todolist;

public class SchoolTask extends Task{
    String title;
    String description;
    String type;
    String color;

    SchoolTask (String ti, String d, String ty, String c){
        title = ti;
        description = d;
        type = ty;
        color = c;
    }
    @Override
    Task getTask() {
        return this;
    }

    @Override
    void setTask() {

    }

    String getColor() {
        return color;
    }

    void setColor(String c) {
        color = c;
    }

}
