package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public class Game {
    private Sketch canvas;
    Game(Sketch canvas){
        this.canvas = canvas;
    }
    public void drawEntities(){
        //cycle through entities
        for (int i=0; i<this.canvas.vehicles.size(); i++) {
            VehicleSuper entity = this.canvas.vehicles.get(i);
            entity.draw();
        }
        //cycle through explosives
        for (int i=0; i<this.canvas.explosives.size(); i++) {
            Explosive projectile = this.canvas.explosives.get(i);
            projectile.display();
        }
    }
    public void checkForCollisions(ArrayList<Explosive> explosives, ArrayList<VehicleSuper> vehicles){
        ArrayList<Explosive> explosivesToKill = new ArrayList<>();
        ArrayList<VehicleSuper> vehiclesToKill = new ArrayList<>();

        collisionCheck(explosives, vehicles, explosivesToKill, vehiclesToKill);
        for (Explosive explosive : explosivesToKill) {
            explosive.kill();
        }
        for (VehicleSuper entity : vehiclesToKill) {
            entity.kill();
        }
    }
    private void collisionCheck(ArrayList<Explosive> explosives, ArrayList<VehicleSuper> vehicles, ArrayList<Explosive> explosivesToKill, ArrayList<VehicleSuper> vehiclesToKill){
        for (Explosive explosive : explosives) {
            for (VehicleSuper entity : vehicles) {
                if (explosive.isCollision( explosive,  entity)) {
                    vehiclesToKill.add(entity);
                    explosivesToKill.add(explosive);
                }
            }
        }
    }
}
