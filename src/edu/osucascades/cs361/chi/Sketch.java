package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Sketch extends PApplet {
    public static final String JOSH_TEST = "test";

    public void settings() {
        fullScreen();
    }

    public void setup() {
        background(55);
    }

    public void draw() {
        drawRyderCircle();
        drawCamCircle();

        noFill();
        ellipse(width - 100, height - 100, 100, 100);
        textSize(24);
        text(JOSH_TEST, (width - 100) - (textWidth(JOSH_TEST) / 2), height - 100, 100);
        fill(255, 0, 255);
        ellipse(width - 500, height - 500, 100, 100);

    }

    private void drawRyderCircle() {
        fill(100, 0, 255);
        ellipse(width/2 - 200, height/2, 100,100);
    }

    private void drawCamCircle() {
        fill(0, 128, 0);
        ellipse(width/2 - 300, height/2, 100,100);
    }
}
