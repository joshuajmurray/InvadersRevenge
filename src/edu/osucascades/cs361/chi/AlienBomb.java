package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class AlienBomb extends Explosive {
    public int x = 0;
    public int y = -100;
    public Sketch canvas;
    public boolean firing = false;

    public AlienBomb( Sketch canvas) {
        this.canvas = canvas;
        super.canvas = canvas;
    }

    public void launch(Tank p) {
        super.launch(p);
    }

    public void move() {
        if (super.y < 0){
            this.firing = false;
        }
        this.y = this.y + 15;
    }

    public void display() {
        super.display();
    }
}
