package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Fort implements Collidable {

    private int x;
    private int y;
    private int lifeRemaining;
    private PApplet p;
    public Sketch canvas;

    public Fort(int x, int y, int lifeRemaining, PApplet p) {
        this.x = x;
        this.y = y;
        this.lifeRemaining = lifeRemaining;
        this.p = p;
    }

    private void decay(int amount) {
        lifeRemaining -= amount;
    }

    public void kill() {
        this.canvas.forts.remove(this);
    }

    public void draw() {
        p.fill(255, 0 , 0);
        p.rect(x, y, 40, 30);
    }

    @Override
    public void checkCollisions(Collidable c) {

    }
}
