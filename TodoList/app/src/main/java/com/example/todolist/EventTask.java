//package com.example.todolist;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class EventTask extends Task{
//    String title;
//    String description;
//    String type;
//    String color;
//
//    EventTask (String ti, String d, String ty, String c){
//        title = ti;
//        description = d;
//        type = ty;
//        color = c;
//    }
//
//    @Override
//    Task getTask() {
//        return null;
//    }
//
//    @Override
//    void setTask() {
//
//    }
//
//    String getColor() {
//        return color;
//    }
//
//    void setColor(String c) {
//        color = c;
//    }
//
//    private EventTask(Parcel in) {
//        title = in.readString();
//        description = in.readString();
//        type = in.readString();
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel out, int i) {
//        out.writeString(title);
//        out.writeString(description);
//        out.writeString(type);
//    }
//
//    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
//
//        @Override
//        public Task createFromParcel(Parcel in) {
//            return new EventTask(in);
//        }
//
//        @Override
//        public Task[] newArray(int i) {
//            return new Task[0];
//        }
//    };
//}
