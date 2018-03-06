package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Alien extends VehicleSuper{
    private PApplet canvas;
    private int x;
    private int y;
    private int width = 30;
    private int height = 30;
    private int direction;private boolean reloading;

    Alien(int x, int y, PApplet canvas) {
        super(x, y , canvas);
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        super.width = this.width;
        super.height = this.height;
        this.direction = 1;
    }

    public void draw() {
        canvas.fill(0, 255, 50);
        canvas.rect(x, y, width, height);
        move();
    }

    private void move() {
        if (this.direction == 1) {
            this.x += 1;
            if (this.x == canvas.width - this.width) {
                this.direction = 0;
            }
        }
        if (this.direction == 0) {
            this.x -= 1;
            if (this.x == 0) {
                this.direction = 1;
            }
        }
    }
    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }
}
