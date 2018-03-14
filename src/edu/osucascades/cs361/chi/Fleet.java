package edu.osucascades.cs361.chi;
import java.util.ArrayList;

public class Fleet implements Drawable {
    private Sketch canvas;
    private int x;
    private int y;
    private static final int ALIEN_COUNT = 11;
    private Alien[] aliens;


    Fleet(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        this.aliens = new Alien[ALIEN_COUNT];
    }

    public void buildFleet(ArrayList<Collidable> collidables) {
        for (int i = 0; i < ALIEN_COUNT; i++) {
            aliens[i] = new Alien(x + (i*50), y, canvas);
            collidables.add(aliens[i]);
        }
    }

    public void draw() {
        for (int i = 0; i < ALIEN_COUNT; i++) {
            aliens[i].draw();
            this.move(aliens[i]);
        }
    }

    public void move(Alien alien) {
        alien.move();
    }
}
