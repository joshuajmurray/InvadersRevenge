package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Tank {
    public int x = 0;
    public int y = 0;
    private PApplet canvas;
    private int xSpeed = 0;
    private boolean reloading;

    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }

    public Tank(int x, int y, PApplet canvas){
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void move(int direction){
        this.xSpeed = direction * 5;
    }

    private void update() {
        if (this.x < 0) {
            this.x = this.canvas.width;
        }
        if (this.x > this.canvas.width) {
            this.x = 0;
        }
        this.x = this.x + this.xSpeed;
    }

    public void display() {
        this.update();
        canvas.rect(this.x,this.y,50,15);
        canvas.fill(255,0,0);
    }

    public void shoot(Sketch canvas) {
        int rocketX = this.x + 24;
        int rocketY = this.y - 10;
        PlayerRocket rocket = new PlayerRocket(rocketX,rocketY, canvas, this);
        rocket.launch(this);
    }
}
