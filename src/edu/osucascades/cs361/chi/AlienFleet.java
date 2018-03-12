package edu.osucascades.cs361.chi;
import processing.core.PApplet;
import java.util.ArrayList;

public class AlienFleet {
    private Sketch canvas;
    private int x;
    private int y;
    private static final int ALIEN_FLEET_ROWS = 5;
    private static final int ALIEN_FLEET_COLUMNS = 11;
    private Alien[][] aliens;;

    AlienFleet(int x, int y, PApplet canvas) {
        buildAlienFleet();
    }

    private void buildAlienFleet() {
        aliens = new Alien[ALIEN_FLEET_ROWS][ALIEN_FLEET_COLUMNS];
        for (int r = 0; r < aliens.length; r++) {
            for (int c = 0; c < aliens[r].length; c++) {
                aliens[r][c] = new Alien(c * 20, r * 20, canvas);
            }
        }
    }

}