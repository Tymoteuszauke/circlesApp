package com.example.mateu_000.helloworld;

import android.graphics.Color;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Matek on 2016-03-07.
 */
public class Circle implements Serializable {

    private Random rand;
    private int x = 0;
    private int y = 0;
    private int color = 0;

    private int leftRight = 5;
    private int upDown = 5;

   // int radius = 0;

    Circle(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    Circle(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = randColor();
    }

    private int randColor(){

        rand = new Random();

        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        return this.color = Color.rgb(r, g, b);
    }

    int getX() {
        return this.x;
    }

    void setX(int x){
        this.x = x;
    }

    int getY() {
        return this.y;
    }

    void setY(int y) {
        this.y = y;
    }

    int getColor(){
        return this.color;
    }

    int getLeftRight(){
        return this.leftRight;
    }

    void setLeftRight(int x) {
        this.leftRight = x;
    }

    int getUpDown() {
        return this.upDown;
    }

    void setUpDown(int x) {
        this.upDown = x;
    }

}
