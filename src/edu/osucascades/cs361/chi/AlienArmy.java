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
        this.fleets = new Fleet[ALIEN_FLEET_COUNT];
    }

    public void buildArmy(ArrayList<Collidable> collidables, ArrayList<Drawable> entities) {
        for (int i = 0; i < ALIEN_FLEET_COUNT; i++) {
            fleets[i] = new Fleet(x, y + (i*50), canvas);
            fleets[i].buildFleet(collidables);
            entities.add(fleets[i]);
        }
    }
}