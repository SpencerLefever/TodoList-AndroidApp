package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskLayoutRecyclerViewAdapter extends RecyclerView.Adapter<TaskLayoutRecyclerViewAdapter.MyViewHolder> {
    Context context;
    User user;

    public TaskLayoutRecyclerViewAdapter(Context context, User user) {
        this.context = context;
        this.user = user;
    }


    @NonNull
    @Override
    public TaskLayoutRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where the layout is inflated
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.task_layout, parent, false);

        return new TaskLayoutRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskLayoutRecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assign values to the rows
        holder.taskButton.setText(user.getTaskByIndex(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return user.getTaskArray().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        Button taskButton, deleteButton;
        CheckBox taskCheckBox;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            taskButton = itemView.findViewById(R.id.TaskButton);
            deleteButton = itemView.findViewById(R.id.DeleteTaskButton);
            taskCheckBox = itemView.findViewById(R.id.TaskCheckBox);
        }

    }

}
