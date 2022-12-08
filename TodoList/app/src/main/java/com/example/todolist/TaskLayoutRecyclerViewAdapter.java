package com.example.todolist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskLayoutRecyclerViewAdapter extends RecyclerView.Adapter<TaskLayoutRecyclerViewAdapter.MyViewHolder> {
    static Context context;
    static User user;

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

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button taskButton, deleteButton;
        CheckBox taskCheckBox;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            taskButton = itemView.findViewById(R.id.TaskButton);
            deleteButton = itemView.findViewById(R.id.DeleteTaskButton);
            taskCheckBox = itemView.findViewById(R.id.TaskCheckBox);

            taskButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
            taskCheckBox.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent;
            if(R.id.TaskButton == view.getId()) {
                intent = new Intent(context, ExpandedTaskActivity.class);
                Button selectedButton = (Button) view;
                Task selectedTask = findTask((String) selectedButton.getText());
                intent.putExtra("SelectedTask", selectedTask);
                context.startActivity(intent);
            }
            else if(R.id.TaskCheckBox == view.getId() || R.id.DeleteTaskButton == view.getId()) {
                Toast.makeText(context, taskButton.getText(), Toast.LENGTH_LONG).show();
                Task selectedTask = findTask((String) taskButton.getText());
                removeTask(selectedTask);
                view.requestLayout();
            }
        }

        public Task findTask(String title) {
            return user.getTaskByTitle(title);
        }
        public void removeTask(Task t) {
            user.removeTask(t);
        }
    }

}
