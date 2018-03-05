package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Sketch extends PApplet {

    Screen s;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        s = new Screen(100000,4,this);
    }

    public void draw() {
        s.updateScreen();
    }

}