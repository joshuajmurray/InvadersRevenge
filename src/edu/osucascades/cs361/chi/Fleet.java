package edu.osucascades.cs361.chi;
import java.util.ArrayList;

public class Fleet {
    private Sketch canvas;
    private int x;
    private int y;
    private static final int ALIEN_COUNT = 11;
    private Alien[] aliens;


    Fleet(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void buildFleet(ArrayList<Collidable> collidables, ArrayList<Drawable> entities) {
        aliens = new Alien[ALIEN_COUNT];
        for (int i = 0; i < ALIEN_COUNT; i++) {
            Alien a = new Alien(x + (i*50), y, canvas);
            collidables.add(a);
            entities.add(a);
        }
    }
}
