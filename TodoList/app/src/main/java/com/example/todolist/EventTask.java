package com.example.todolist;

public class EventTask extends Task{
    String title;
    String description;
    String type;
    String color;

    EventTask (String ti, String d, String ty, String c){
        title = ti;
        description = d;
        type = ty;
        color = c;
    }

    @Override
    Task getTask() {
        return null;
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
