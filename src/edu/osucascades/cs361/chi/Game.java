package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public class Game {
    private Sketch canvas;
    private Screen screen;
    private ArrayList<Collidable> collidables = new ArrayList<>();
    private ArrayList<Drawable> entities  = new ArrayList<>();

    private Tank player;
    private AlienArmy alienArmy;

    Game(Sketch canvas){
        this.canvas = canvas;
        setup();
    }

    private void setup(){
        this.screen = new Screen(0,4,canvas);
        entities.add(screen);

        this.player = new Tank(0,canvas.height - 100, canvas);
        entities.add(this.player);
        collidables.add(this.player);

        this.alienArmy = new AlienArmy(0, 200, canvas);
        alienArmy.buildArmy(collidables, entities);

        for(int i = 0; i < 4; i++) {
            Fort fort = new Fort(canvas.width/4 * i + 200, canvas.height - 250, 100, canvas);
            collidables.add(fort);
            entities.add(fort);
        }
    }
    public void draw(){
        drawEntities();
        checkForCollisions(collidables);
    }
    // cycles through the vehicles and explosives drawing each of them.
    private void drawEntities(){

        for (int i = 0; i < entities.size(); i ++) {
            Drawable entity = entities.get(i);
            entity.draw();
        }
    }
    //creates one "to kill" array to hold objects marked to kill by the collision check method
    //then calls kill on each marked object
    private void checkForCollisions(ArrayList<Collidable> collidables){
        ArrayList<Collidable> collidablesToKill = collisionCheck(collidables);

        for (Collidable entity : collidablesToKill) {
            entity.kill(collidables, this.entities);
        }
    }
    private ArrayList<Collidable> collisionCheck( ArrayList<Collidable> collidables){
        ArrayList<Collidable> collidablesToKill = new ArrayList<>();

        for (Collidable entityA : collidables) {
            for (Collidable entityB : collidables) {

                if (entityA == entityB){
                    //do nothing if its comparing itself  otherwise everything will be marked to kill.
                }
                else {
                    if (entityA.isTouching(entityB)) {
                        collidablesToKill.add(entityA);
                        collidablesToKill.add(entityB);
                    }
                }
            }
        }
        return collidablesToKill;
    }

    public Screen getScreen() {
        return screen;
    }

    public Tank getPlayer() {
        return player;
    }

    public ArrayList<Collidable> getCollidables() {
        return collidables;
    }

    public ArrayList<Drawable> getEntities() {
        return entities;
    }
}

