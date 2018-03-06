package edu.osucascades.cs361.chi;

public class Explosive {
    private int x;
    private int y;
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
        canvas.rect(this.x + vehicle.width/2, this.y - vehicle.height/2, 3, 10);
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
}