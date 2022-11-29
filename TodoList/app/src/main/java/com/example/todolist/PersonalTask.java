package com.example.todolist;

public class PersonalTask extends Task {
    String title;
    String description;
    String type;
    String color;

    PersonalTask (String ti, String d, String ty, String c){
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
