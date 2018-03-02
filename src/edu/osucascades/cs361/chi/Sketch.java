package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Sketch extends PApplet {

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(55);
    }

    public void draw() {
        fill(255, 255, 0);
        ellipse(width/2, height/2, 100, 100);
    }
}
