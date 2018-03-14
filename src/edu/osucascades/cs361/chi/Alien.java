package edu.osucascades.cs361.chi;


import java.util.ArrayList;
import processing.core.PImage;
import java.util.Random;

public class Alien implements Collidable, Drawable {
    private Sketch canvas;
    private int width = 30;
    private int height = 30;
    private int x;
    private int y;
    private int xSpeed = 1;
    private boolean reloading;
    private PImage sprite;


    Alien(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        this.sprite = this.canvas.loadImage(chooseRandomAlienImage());
    }

    private String chooseRandomAlienImage() {
        Random randomImageAssigner = new Random();
        int randomImageNumber = randomImageAssigner.nextInt(4) + 1;

        switch (randomImageNumber) {
            case 1:
                return "data/img/AlienRed.png";

            case 2:
                return "data/img/AlienGreen.png";

            case 3:
                return "data/img/AlienBlue.png";

            default:
                return "data/img/AlienYellow.png";
        }
    }

    public void draw() {
        canvas.image(this.sprite, x, y, width, height);
        //canvas.fill(0, 255, 50);
        //canvas.rect(x, y, width, height);
        //move();
    }

    public void move() {
        if (this.x == canvas.width - this.width) {
            this.xSpeed = -1;
            this.y += height;
        }
        if (this.x == 0 && xSpeed == -1) {
            this.xSpeed = 1;
            this.y += height;
        }
        this.x += xSpeed;
    }

    public void kill(ArrayList collidables, ArrayList entities) {
        this.canvas.game.getScreen().updateScore();
        collidables.remove(this);
        entities.remove(this);

    }

    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }
}
