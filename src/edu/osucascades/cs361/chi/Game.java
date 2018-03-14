package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public class Game {
    private Sketch canvas;
    public ArrayList<Collidable> collidables = new ArrayList<>();
    public ArrayList<Drawable> entities  = new ArrayList<>();

    public Tank player;
    public AlienArmy alienArmy;
    public ScoreManager scoreManager;
    public Screen screen;

    Game(Sketch canvas){
        this.canvas = canvas;
        setup();
    }

    public void setup(){
        this.scoreManager = new ScoreManager(canvas);
        this.screen = new Screen(0,4,canvas);
        this.player = new Tank(0,canvas.height - 100, canvas);
        this.alienArmy = new AlienArmy(0, 200, canvas);

        entities.add(this.player);
        collidables.add(this.player);

        alienArmy.buildArmy(collidables, entities);

        for(int i = 0; i < 4; i++) {
            Fort fort = new Fort(canvas.width/4 * i + 200, canvas.height - 200, 100, canvas);
            collidables.add(fort);
            entities.add(fort);
        }
    }
    public void draw(){
        screen.draw();
        drawEntities();
        checkForCollisions(collidables);
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
    public void checkForCollisions(ArrayList<Collidable> collidables){
        ArrayList<Collidable> collidablesToKill = new ArrayList<>();

        collisionCheck(collidables, collidablesToKill);

        for (Collidable entity : collidablesToKill) {
            entity.kill();
        }
    }
    private void collisionCheck( ArrayList<Collidable> collidables, ArrayList<Collidable> collidablesToKill){
        for (int i=0; i< collidables.size(); i++) {
            Collidable entityA = collidables.get(i);
            for (int j= 0; j< collidables.size(); j++) {
                if (i == j){
                    //do nothing if its comparing itself  otherwise everything will be marked to kill.
                }
                else {
                    Collidable entityB = collidables.get(j);
                    if (entityA.checkCollisions(entityA, entityB)) {
                        collidablesToKill.add(entityA);
                        collidablesToKill.add(entityB);
                    }
                }
            }
        }
    }
}

