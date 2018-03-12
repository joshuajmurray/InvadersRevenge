package edu.osucascades.cs361.chi;
import processing.core.PApplet;
import java.util.ArrayList;

public class AlienFleet {
    private Sketch canvas;
    private int x;
    private int y;
    private static final int ALIEN_FLEET_ROWS = 2;    //Real game uses 5
    private static final int ALIEN_FLEET_COLUMNS = 6;  //Real game uses 11
    public Alien[][] aliens;


    AlienFleet(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void buildAlienFleet(ArrayList<Collidable> collidables, ArrayList<Drawable> entities) {
        aliens = new Alien[ALIEN_FLEET_ROWS][ALIEN_FLEET_COLUMNS];
        for (int r = 0; r < ALIEN_FLEET_ROWS; r++) {
            for (int c = 0; c < ALIEN_FLEET_COLUMNS; c++) {
                Alien a = new Alien(c*50, y + (r*50), canvas);
                aliens[r][c] = a;
                collidables.add(a);
                entities.add(a);
            }
        }
    }
}