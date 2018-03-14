package edu.osucascades.cs361.chi;

import processing.core.PApplet;

import java.util.ArrayList;
import processing.core.PImage;

public class Fort implements Collidable, Drawable  {

    private int x;
    private int y;
    private int width = 120;
    private int height = 100;
    private int lifeRemaining;
    private Sketch canvas;
    private PImage sprite;

    Fort(int x, int y, int lifeRemaining, Sketch p) {
        this.x = x;
        this.y = y;
        this.lifeRemaining = lifeRemaining;
        this.canvas = p;
        this.sprite = this.canvas.loadImage("data/img/fort.png");
    }

    private void decay(int amount) {
        lifeRemaining -= amount;
    }



    public void kill(ArrayList collidables, ArrayList entities) {
        decay(10);
        if (this.lifeRemaining == 0){
            collidables.remove(this);
            entities.remove(this);
        }
    }

    public void draw() {
        canvas.fill(255, 0 , 0);
        canvas.image(this.sprite, x, y, width, height);
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
