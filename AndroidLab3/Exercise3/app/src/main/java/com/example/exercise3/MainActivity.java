package com.example.exercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ImageView> allPetals;
    private LayoutInflater layoutInflater;
    private Button pinkBtn;
    private Button goldBtn;
    private Button clearBtn;
    private RelativeLayout relativeLayout;

    Flower flower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flower = new Flower();
        allPetals = new ArrayList<ImageView>();

        initialize();

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        pinkBtn = (Button) findViewById(R.id.AddPink);
        goldBtn = (Button) findViewById(R.id.AddGold);
        clearBtn = (Button) findViewById(R.id.ClearButton);
        pinkBtn.setOnClickListener(addPetal);
        goldBtn.setOnClickListener(addPetal);
        clearBtn.setOnClickListener(clearPetals);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        flower.set_xCenter(metrics.widthPixels / 2 - 100);
        flower.set_yCenter(metrics.heightPixels / 2);
    }

    private void initialize(){
        flower.setRotate(0);
        flower.setScaleX((float) .3);
        flower.setScaleY((float) .3);
        flower.setDegenerate((float) 1.001);
        flower.initializeAngle();
    }

    private View.OnClickListener addPetal = new View.OnClickListener() {
        public void onClick (View view) {
            String buttonText = ((Button) view).getText().toString();
            ImageView petal;

            if (buttonText.equals("Pink")) {
                petal = (ImageView) layoutInflater.inflate(R.layout.petal_pink, null);
            } else {
                petal = (ImageView) layoutInflater.inflate(R.layout.petal_gold, null);
            }

            petal.setX(flower.get_xCenter());
            petal.setY(flower.get_yCenter());
            petal.setPivotY(0);
            petal.setPivotX(100);
            petal.setScaleX(flower.getScaleX());
            petal.setScaleY(flower.getScaleY());
            petal.setRotation(flower.getRotate());

            relativeLayout.addView(petal, 0);

            allPetals.add(petal);

            flower.updatePetalValues();
        }
    };

    private View.OnClickListener clearPetals  = new View.OnClickListener() {
        public void onClick (View view) {
            for (int i = 0; i < allPetals.size(); i++) {
                ImageView petal = allPetals.get(i);
                relativeLayout.removeView(petal);
            }

            allPetals.clear();
            initialize();
        }
    };
}