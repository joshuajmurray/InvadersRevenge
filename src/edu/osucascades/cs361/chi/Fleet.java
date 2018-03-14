package edu.osucascades.cs361.chi;
import java.util.ArrayList;

public class Fleet implements Drawable {
    private static final int ALIEN_COUNT = 11;
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private Sketch canvas;
    private int x;
    private int y;
    private ArrayList<Alien> aliens;


    Fleet(int x, int y, Sketch canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        this.aliens = new ArrayList<>();
    }

    public void buildFleet(ArrayList<Collidable> collidables) {
        for (int i = 0; i < ALIEN_COUNT; i++) {
            Alien a = new Alien(x + (i*50), y, canvas);
            aliens.add(a);
            collidables.add(a);
        }
    }

    public void draw() {
        checkForDirectionChange();
        for (Alien alien : aliens) {
            if (!isAlienDead(alien)) {
                alien.draw();
                alien.move();
            }
        }
    }

    private void checkForDirectionChange() {
        if (isTouchingLeftEdge() || isTouchingRightEdge()) {
            changeFleetDirection();
        }
    }

    private void changeFleetDirection() {
        for (Alien alien : aliens) {
            alien.changeDirection();
        }
    }

    private boolean isTouchingRightEdge() {
        return aliens.get(aliens.size() - 1).getX() == canvas.width - aliens.get(aliens.size() - 1).getWidth();
    }

    private boolean isTouchingLeftEdge() {
        return aliens.get(0).getX() == 0;
    }

    private boolean isAlienDead(Alien alien) {
        if (alien.getIsDead()) {
            return true;
        } else {
            return false;
        }
    }
}
