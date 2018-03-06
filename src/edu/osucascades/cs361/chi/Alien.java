package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Alien {
    private PApplet p;
    private int x;
    private int y;
    private int width;
    private int height;
    private int direction;

    public Alien(int x, int y, PApplet p) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 30;
        this.direction = 1;
    }

    public void draw() {
        p.fill(0, 255, 50);
        p.rect(x, y, width, height);
        move();
    }

    public void move() {
        if (this.direction == 1) {
            this.x += 1;
            if (this.x == p.width - this.width) {
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
}
