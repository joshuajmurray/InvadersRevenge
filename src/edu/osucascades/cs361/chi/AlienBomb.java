package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class AlienBomb extends Explosive {
    public int x = 0;
    private int y = -100;
    private Sketch canvas;
    private boolean firing = false;

    public AlienBomb( Sketch canvas) {
        this.canvas = canvas;
        super.setCanvas(canvas);
        super.setDirection(10);
    }

    public void launch() {
        super.launch();
    }

    public void move() {
        if (super.getY() < 0){
            this.firing = false;
        }
        this.y = this.y + 15;
    }

    public void display() {
        super.display();
    }
}
