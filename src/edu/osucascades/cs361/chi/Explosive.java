package edu.osucascades.cs361.chi;

public class Explosive {
    public int x;
    public int y;
    public int direction;
    public Sketch canvas;
    public VehicleSuper vehicle;

    public Explosive(){

    }
    public Explosive(Sketch canvas, int direction, VehicleSuper vehicle) {
        this.canvas = canvas;
        this.direction = direction;
        this.vehicle = vehicle;
    }

    public void launch(VehicleSuper p) {
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
}