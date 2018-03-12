package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public class Tank implements Collidable, Drawable {
    private int x;
    private int y;
    private int width = 50;
    private int height = 15;
    private int xSpeed = 1;
    private Sketch canvas;
    private boolean reloading;

    Tank(int x, int y, Sketch canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void draw(){
        this.move();
        canvas.rect(this.x, this.y, this.width, this.height);
        canvas.fill(255, 0, 0);
    }

    public void move(){
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > this.canvas.width) {
            this.x = this.canvas.width;
        }
        this.x = this.x + this.xSpeed;
    }



    public void updateDirection(int direction){
        this.xSpeed = direction * 3;
    }

    public void shoot(Sketch canvas) {
        reloading = true;
        PlayerRocket rocket = new PlayerRocket(canvas, this, -10);
        canvas.game.collidables.add(rocket);
        canvas.game.entities.add(rocket);
    }

    public void kill(ArrayList collidables, ArrayList entities){
        collidables.remove(this);
        entities.remove(this);
    }
    public boolean checkCollisions(Collidable EntityA, Collidable EntityB){
        boolean b = false;
        if (EntityA.getX() >= EntityB.getX() && EntityA.getX() +  EntityA.getWidth() <= EntityB.getX() + EntityB. getWidth()) {
            if (EntityA.getY() >= EntityB.getY() && EntityA.getY()  + EntityA.getHeight() <= EntityB.getY() +  EntityB.getHeight()) {
                b = true;
            }
        }
        return b;
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
