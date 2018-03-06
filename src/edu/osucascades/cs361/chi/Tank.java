package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Tank extends VehicleSuper {
    public int x;
    public int y;
    private int width = 50;
    private int height = 15;
    private PApplet canvas;

    private boolean reloading;


    public Tank(int x, int y, PApplet canvas){
        super(x, y , canvas);
        this.x = x;
        this.y = y;
        super.width = this.width;
        super.height = this.height;
        this.canvas = canvas;
    }

    public void updateDirection(int direction){
        super.setxSpeed(direction);
        this.x = super.x;
        this.y = super.y;
    }

    public void draw() {
        super.draw();
    }

    public void shoot(Sketch canvas) {
        int rocketX = this.width/2;
        int rocketY = this.height/2;
        PlayerRocket rocket = new PlayerRocket(rocketX,rocketY, canvas, this);
        rocket.launch(this);
    }

    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }
}
