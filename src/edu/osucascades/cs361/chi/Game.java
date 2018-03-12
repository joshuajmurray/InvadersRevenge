package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public class Game {
    private Sketch canvas;
    Screen screen;
    public ArrayList<Collidable> Collidables = new ArrayList<>();
    public ArrayList<Drawable> entities  = new ArrayList<>();

    public Tank player;
    public AlienFleet alienFleet;

    Game(Sketch canvas){
        this.canvas = canvas;
        setup();
    }

    public void setup(){
        this.screen = new Screen(0,4,canvas);
        this.player = new Tank(0,canvas.height - 100, canvas);
        this.alienFleet = new AlienFleet(0, 200, canvas);

        entities.add(this.player);
        Collidables.add(this.player);

        alienFleet.buildAlienFleet();
        for (int r = 0; r < alienFleet.aliens.length; r++) {
            for (int c = 0; c < alienFleet.aliens[r].length; c++) {
                System.out.println(alienFleet.aliens[r][c].getX());
                Collidables.add(alienFleet.aliens[r][c]);
                entities.add(alienFleet.aliens[r][c]);
            }
        }

        for(int i = 0; i < 4; i++) {
            Fort fort = new Fort(canvas.width/4 * i + 200, canvas.height - 200, 100, canvas);
            Collidables.add(fort);
            entities.add(fort);
        }
    }
    public void draw(){
        screen.draw();
        drawEntities();
        checkForCollisions(Collidables);
    }
    // cycles through the vehicle and explosive arrays drawing each of them.
    public void drawEntities(){
        //cycle through entities
        for (int i=0; i<this.entities.size(); i++) {
            Drawable entity = this.entities.get(i);
            entity.draw();
        }
    }
    //creates one "to kill" array to hold objects marked to kill by the collision check method
    //then calls kill on each marked object
    public void checkForCollisions(ArrayList<Collidable> Collidables){
        ArrayList<Collidable> CollidablesToKill = new ArrayList<>();

        collisionCheck(Collidables, CollidablesToKill);

        for (Collidable entity : CollidablesToKill) {
            entity.kill();
        }
    }
    private void collisionCheck( ArrayList<Collidable> Collidables, ArrayList<Collidable> CollidablesToKill){
        for (int i=0; i< Collidables.size(); i++) {
            Collidable entityA = Collidables.get(i);
            for (int j= 0; j< Collidables.size(); j++) {
                if (i == j){
                    //do nothing if its comparing itself  otherwise everything will be marked to kill.
                }
                else {
                    Collidable entityB = Collidables.get(j);
                    if (entityA.checkCollisions(entityA, entityB)) {
                        CollidablesToKill.add(entityA);
                        CollidablesToKill.add(entityB);
                    }
                }
            }
        }
    }
}

