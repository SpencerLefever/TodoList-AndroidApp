package com.example.todolist;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.media.MediaPlayer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskLayoutRecyclerViewAdapter extends RecyclerView.Adapter<TaskLayoutRecyclerViewAdapter.MyViewHolder> {
    static Context context;
    static User user;
    static int theme;

    public TaskLayoutRecyclerViewAdapter(Context context, User user, int theme) {
        this.context = context;
        this.user = user;
        this.theme = theme;
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button taskButton, deleteButton;
        CheckBox taskCheckBox;
        // MediaPlayers for deleting and completing tasks
        MediaPlayer taskCompletedAudio;
        MediaPlayer removeTaskAudio;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            taskButton = itemView.findViewById(R.id.TaskButton);
            deleteButton = itemView.findViewById(R.id.DeleteTaskButton);
            taskCheckBox = itemView.findViewById(R.id.TaskCheckBox);

            // Sounds for deleting and completing tasks
            taskCompletedAudio = MediaPlayer.create(itemView.getContext(), R.raw.taskcompleted);
            removeTaskAudio = MediaPlayer.create(itemView.getContext(), R.raw.removetask);

            taskButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
            taskCheckBox.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Intent intent;
            Animation completeAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_out_right);
            completeAnimation.setDuration(500);
            Animation deleteAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_out_left);
            deleteAnimation.setDuration(500);
            //Animation for going to expanded task
            if(R.id.TaskButton == view.getId()) {
                intent = new Intent(context, ExpandedTaskActivity.class);
                Button selectedButton = (Button) view;
                Task selectedTask = findTask((String) selectedButton.getText());
                intent.putExtra("SelectedTask", selectedTask);
                intent.putExtra("Theme", theme);
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
            }
            //Animation for complete task
            else if(R.id.TaskCheckBox == view.getId()) {
                view.startAnimation(completeAnimation);
                removeAt(getAdapterPosition());
                //view.requestLayout();
                taskCompletedAudio.start();
            }
            //Animation for deleted task
            else if (R.id.DeleteTaskButton == view.getId()) {
                view.startAnimation(deleteAnimation);
                removeAt(getAdapterPosition());
                //view.requestLayout();
                removeTaskAudio.start();
            }
        }

        public void removeAt(int position) {
            user.getTaskArray().remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, user.getTaskArray().size());
        }

        public Task findTask(String title) {
            return user.getTaskByTitle(title);
        }
        public void removeTask(Task t) {
            user.removeTask(t);
        }
    }

}
