package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Fort {

    private int x;
    private int y;
    private int lifeRemaining;
    private PApplet p;

    public Fort(int x, int y, int lifeRemaining, PApplet p) {
        this.x = x;
        this.y = y;
        this.lifeRemaining = lifeRemaining;
        this.p = p;
    }

    private void decay(int amount) {
        lifeRemaining -= amount;
    }

    public void draw() {
        p.fill(255, 0 , 0);
        p.rect(x, y, 4, 3);
    }
}
