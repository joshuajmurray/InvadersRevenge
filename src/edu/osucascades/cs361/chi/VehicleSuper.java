package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class VehicleSuper {
    public int x;
    public int y;
    public int width;
    public int height;

    private PApplet canvas;
    private int xSpeed = 0;
    private boolean reloading;

    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }
    public void setxSpeed(int x){
        this.xSpeed = x * 3;
    }

    public VehicleSuper(int x, int y, PApplet canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    private void move() {
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > this.canvas.width) {
            this.x = this.canvas.width;
        }
        this.x = this.x + this.xSpeed;
    }

    public void draw() {
        this.move();
        canvas.rect(this.x,this.y,this.width,this.height);
        canvas.fill(255,0,0);
    }

}
