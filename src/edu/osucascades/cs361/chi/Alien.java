package edu.osucascades.cs361.chi;


import java.util.ArrayList;
import processing.core.PImage;
import java.util.Random;

public class Alien implements Collidable, Drawable {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private Sketch canvas;
    private int width = 30;
    private int height = 30;
    private int x;
    private int y;
    private int direction;
    private boolean reloading;
    private PImage sprite;


    Alien(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        this.direction = RIGHT;
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
    }

    public void move() {
        this.x += this.direction;
    }

    public void changeDirection() {
        if (this.direction == LEFT) {
            this.direction = RIGHT;
            bringAlienDown();
        }
        else if (this.direction == RIGHT) {
            this.direction = LEFT;
            bringAlienDown();
        }
    }

    private void bringAlienDown() {
        this.y += this.height;
    }

    public void kill(ArrayList collidables, ArrayList entities) {
        this.canvas.game.getScreen().updateScore();
        collidables.remove(this);
        entities.remove(this);

    }

    public boolean isReloading() {
        return reloading;
    }
    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public int getWidth() {
        return this.width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight(){
        return this.height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
