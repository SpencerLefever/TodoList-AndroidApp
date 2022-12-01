package com.example.exercise3;

public class Flower {
    public final double GOLDEN_RATIO = .618033989;
    public final double GROW_WIDTH = .03 * GOLDEN_RATIO;
    public final double GROW_HEIGHT = .03 * GOLDEN_RATIO;

    private double angle;
    private int rotate;
    private float scaleX;
    private float scaleY;
    private int xCenter;
    private int yCenter;
    private float degenerate;

    public Flower() {
        rotate = 0;
        scaleX = (float) .3;
        scaleY = (float) .3;
        degenerate = (float) 1.00;
        angle = 360 * GOLDEN_RATIO;
    }

    public void initialize() {
        rotate = 0;
        scaleX = (float) .3;
        scaleY = (float) .3;
        degenerate = (float) 1.00;
        angle = 360 * GOLDEN_RATIO;
    }

    public float getScaleX(){
        return scaleX;
    }
    public void setScaleX(float scale){
        scaleX = scale;
    }
    public float getScaleY(){
        return scaleY;
    }
    public void setScaleY(float scale){
        scaleY = scale;
    }
    public void setRotate(int rot) {
        rotate =rot;
    }
    public int getRotate() {
        return rotate;
    }
    public void set_xCenter(int x){
        xCenter = x;
    }
    public int get_xCenter(){
        return xCenter;
    }

    public void set_yCenter(int y){
        yCenter = y;
    }
    public int get_yCenter(){
        return yCenter;
    }

    public void setDegenerate(float deg){
        degenerate = deg;
    }
    public void initializeAngle (){
        angle = 360 * GOLDEN_RATIO;
    }

    public void updatePetalValues() {
        rotate += angle;
        scaleX += scaleX * GROW_WIDTH;
        scaleY += scaleY * GROW_HEIGHT;
        angle *= degenerate;
    }
}
