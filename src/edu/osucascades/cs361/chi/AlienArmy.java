package edu.osucascades.cs361.chi;
import java.util.ArrayList;

public class AlienArmy {
    private Sketch canvas;
    private int x;
    private int y;
    private static final int ALIEN_FLEET_COUNT = 2;
    private Fleet[] fleets;


    AlienArmy(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void buildArmy(ArrayList<Collidable> collidables, ArrayList<Drawable> entities) {
        fleets = new Fleet[ALIEN_FLEET_COUNT];
        for (int i = 0; i < ALIEN_FLEET_COUNT; i++) {
            Fleet f = new Fleet(x, y + (i*50), canvas);
            f.buildFleet(collidables, entities);
        }
    }
}