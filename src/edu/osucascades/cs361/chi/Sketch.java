package edu.osucascades.cs361.chi;
import processing.core.PApplet;

public class Sketch extends PApplet {

    Game game;
    private int playerMovementDirection = 0;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        this.game = new Game(this);
    }

    public void draw() {
        game.getPlayer().updateDirection(playerMovementDirection);
        game.draw();
    }

    public void keyReleased() {
        if (key == 'a' || key == 'd' ) {
            this.playerMovementDirection = 0;
        }
        if (key == ' ' && !game.getPlayer().isReloading()) {
            game.getPlayer().shoot(this);
        }
    }
    public void keyPressed() {
        if (key == 'a') {
            this.playerMovementDirection = -1;
        }

        if (key == 'd') {
            this.playerMovementDirection = 1;
        }
    }
}
