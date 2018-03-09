package edu.osucascades.cs361.chi;


public class Alien implements Collidable, Drawable {
    private Sketch canvas;
    private int width = 30;
    private int height = 30;
    private int x;
    private int y;
    private int xSpeed = 1;
    private boolean reloading;


    Alien(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void draw(){
        canvas.fill(0, 255, 50);
        canvas.rect(x, y, width, height);
        move();
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

    public void kill(){
        this.canvas.screen.updateScore();
        this.canvas.Collidables.remove(this);
        this.canvas.entities.remove(this);

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
