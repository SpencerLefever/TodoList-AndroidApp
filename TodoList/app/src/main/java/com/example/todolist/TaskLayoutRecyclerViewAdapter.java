package com.example.todolist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
    float x1, x2;   //Holds swipe start and end position
    static final int MIN_DISTANCE = 250;


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

            setClickListeners();
            setTouchListeners();
        }

        public void setClickListeners() {
            taskButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
            taskCheckBox.setOnClickListener(this);
        }
        @SuppressLint("ClickableViewAccessibility")
        public void setTouchListeners() {
            //Detect swipe for complete a task
            taskCheckBox.setOnTouchListener((view, motionEvent) -> {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = motionEvent.getX();
                        float deltaX = x2 - x1;
                        if (Math.abs(deltaX) > MIN_DISTANCE)
                        {
                            Toast.makeText(context, "Left->Right", Toast.LENGTH_SHORT).show ();
                            completeTask(view);
                            return true;
                        }
                    break;
                }
                return false;
            });

            //Detect swipe for delete task
            deleteButton.setOnTouchListener((view, motionEvent) -> {
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = motionEvent.getX();
                        float deltaX = x2 - x1;
                        if (Math.abs(deltaX) > MIN_DISTANCE)
                        {
                            Toast.makeText(context, "Right->Left", Toast.LENGTH_SHORT).show ();
                            deleteTask(view);
                            return true;
                        }
                        break;
                }
                return false;
            });

        }

        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.TaskButton:
                    expandTask(view);
                    break;
                case R.id.TaskCheckBox:
                    completeTask(view);
                    break;
                case R.id.DeleteTaskButton:
                    deleteTask(view);
                    break;
            }
        }

        public void expandTask(View view) {
            Intent intent = new Intent(context, ExpandedTaskActivity.class);
            Button selectedButton = (Button) view;
            Task selectedTask = findTask((String) selectedButton.getText());
            intent.putExtra("SelectedTask", selectedTask);
            intent.putExtra("Theme", theme);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
        }

        public void completeTask(View view) {
            Animation completeAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_out_right);
            view.startAnimation(completeAnimation);
            removeAt(getAdapterPosition());
            taskCompletedAudio.start();
        }

        public void deleteTask(View view) {
            Animation deleteAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_out_left);
            view.startAnimation(deleteAnimation);
            removeAt(getAdapterPosition());
            removeTaskAudio.start();
        }

        public void removeAt(int position) {
            user.getTaskArray().remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, user.getTaskArray().size());
        }

        public Task findTask(String title) {
            return user.getTaskByTitle(title);
        }
    }

}
