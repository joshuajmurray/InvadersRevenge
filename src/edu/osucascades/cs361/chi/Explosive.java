package edu.osucascades.cs361.chi;

public class Explosive {
    private int x;
    private int y;
    private int width;
    private int height;
    private int direction;
    private Sketch canvas;
    private VehicleSuper vehicle;

    Explosive(){

    }
    Explosive(Sketch canvas, int direction, VehicleSuper vehicle) {
        this.canvas = canvas;
        this.direction = direction;
        this.vehicle = vehicle;
    }

    void launch(VehicleSuper p) {
        this.x = vehicle.x;
        this.y = vehicle.y;
    }

    public void move() {
        this.y = this.y + direction;
    }

    public void display() {
        this.move();
        canvas.rect(this.x + vehicle.width/2, this.y - vehicle.height/2, width, height);
        canvas.fill(255);
    }

    int getY() {
        return y;
    }

    void setCanvas(Sketch canvas) {
        this.canvas = canvas;
    }

    void setDirection(int direction) {
        this.direction = direction;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void isCollision(Explosive  projectile, VehicleSuper vehicle) {
        
        if (projectile.x >= vehicle.getX() && projectile.x +  projectile.width <= vehicle.getX() + vehicle. getWidth()) {
            if (projectile.y >= vehicle.getY() && projectile.y  + projectile.height <= vehicle.getY() +  vehicle.getHeight()) {
                vehicle.kill();
            }
        }
    }
}