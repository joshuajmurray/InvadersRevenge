package edu.osucascades.cs361.chi;
import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {

    Game game;
    Screen screen;
    public ArrayList<Collidable> Collidables = new ArrayList<>();
    public ArrayList<Drawable> entities  = new ArrayList<>();

    private int playerMovementDirection = 0;
    public Tank player;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        smooth();
        this.player = new Tank(0,this.height - 100, this);
        entities.add(this.player);
        Collidables.add(this.player);

        for (int i=0; i<6 ; i++){
            Alien alien =  new Alien(i * 50, 200, this);
            Collidables.add(alien);
            entities.add(alien);
        }
        for(int i = 0; i < 4; i++) {
            Fort fort = new Fort(this.width/4 * i + 200, this.height - 200, 100, this);
            Collidables.add(fort);
            entities.add(fort);
        }

        this.game = new Game(this);
        this.screen = new Screen(0,4,this);
    }

    public void draw() {
        screen.draw();
        this.player.updateDirection(playerMovementDirection);
        game.drawEntities();
        game.checkForCollisions( Collidables);
    }

    public void keyReleased() {
        if (key == 'a' || key == 'd' ) {
            this.playerMovementDirection = 0;
        }
        if (key == ' ' && !this.player.isReloading()) {
            this.player.shoot(this);
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
