package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    //User model to hold task data
    User user;

    //Variables for settings and add task buttons
    private Button settingsButton;
    private Button addTaskButton;

    private LayoutInflater layoutInflater;
    private int currentTheme;
    private RecyclerView multiTaskLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        currentTheme = getIntent().getIntExtra("Theme", R.style.Theme_TodoList);
        setTheme(currentTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = User.getInstance();

        updateModel();

        initRecyclerView();


        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Find settings and add buttons by id
        settingsButton = findViewById(R.id.SettingsButton);
        addTaskButton = findViewById(R.id.AddTaskButton);

        //Add onClickListeners to settings and add task buttons
        settingsButton.setOnClickListener(settingsOnClickListener);
        addTaskButton.setOnClickListener(addTaskOnClickListener);
    } //End of onCreate()

    public void initRecyclerView() {
        //Update view
        multiTaskLayout = findViewById(R.id.MultiTaskLayout);
        TaskLayoutRecyclerViewAdapter adapter = new TaskLayoutRecyclerViewAdapter(this, user, currentTheme);
        MoveTaskTouchHelperCallback callback = new MoveTaskTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(multiTaskLayout);
        multiTaskLayout.setAdapter(adapter);
        multiTaskLayout.setLayoutManager(new LinearLayoutManager(this));
    }

    public void updateModel() {
        Intent intent = getIntent();

        //Get new task from the intent
        Task newTask = intent.getParcelableExtra("NewTask");

        if(newTask == null) {
            return;
        }
        user.addTask(newTask);
    }

    //Go Add tasks activity when add button is clicked
    private final View.OnClickListener addTaskOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), AddTaskActivity.class);
            i.putExtra("Theme", currentTheme);
            MainActivity.this.startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    };

    //TODO Animate the taskLayout view to swipe either left or right based on deletion or completion

    //Go to settings page when settings button is clicked
    private final View.OnClickListener settingsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
            i.putExtra("Theme", currentTheme);
            MainActivity.this.startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    };
} //End of MainActivityClass