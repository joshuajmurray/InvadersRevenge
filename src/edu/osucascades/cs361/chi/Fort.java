package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Fort {

    private int lifeRemaining = 100;

    private void updateLifeRemaining(int hitTaken) {
        lifeRemaining -= hitTaken;
    }
}
