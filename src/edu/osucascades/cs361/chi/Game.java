package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public class Game {
    private Sketch canvas;
    Game(Sketch canvas){
        this.canvas = canvas;
    }
    // cycles through the vehicle and explosive arrays drawing each of them.
    public void drawEntities(){
        //cycle through entities
        for (int i=0; i<this.canvas.entities.size(); i++) {
            Entity entity = this.canvas.entities.get(i);
            entity.draw();
        }

    }
    //creates two "to kill" arrays to hold objects marked to kill by the collision check method
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

