package com.example.todolist;

import android.os.Parcel;
import android.os.Parcelable;

//Interface for types of tasks in TodoList
public class Task implements Parcelable {
    String title;
    String description;
    String type;


    private Task(Parcel in) {
        title = in.readString();
        description = in.readString();
        type = in.readString();
    }

    public Task(String t, String d, String ty) {
        title = t;
        description = d;
        type = ty;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(title);
        out.writeString(description);
        out.writeString(type);
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {

        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int i) {
            return new Task[0];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}
