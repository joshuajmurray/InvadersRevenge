package edu.osucascades.cs361.chi;
import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {

    Screen s;
    public ArrayList<Explosive> explosives = new ArrayList<>();
    public ArrayList<Fort> forts = new ArrayList<>();
    public ArrayList<VehicleSuper> vehicles = new ArrayList<>();

    private int playerMovementDirection = 0;
    private Tank player;


    private Alien alien;



    public void settings() {

        fullScreen();
    }

    public void setup() {
        smooth();
        this.player = new Tank(0,600, this);
        this.alien = new Alien(0, 200, this);

        s = new Screen(100000,4,this);
    }

    public void draw() {
        s.draw();
        this.player.updateDirection(playerMovementDirection);
        //cycle through entities
        for (int i=0; i<this.vehicles.size(); i++) {
            VehicleSuper entity = this.vehicles.get(i);
            entity.draw();
        }
        //cycle through explosives

        for (int i=0; i<this.explosives.size(); i++) {
            Explosive projectile = this.explosives.get(i);
            projectile.move();
            projectile.display();
        }
        

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
