package edu.osucascades.cs361.chi;
import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {

    private PlayerTank player;
    private int playerMovementDirection = 0;

    public ArrayList<Explosive> explosives = new ArrayList<>();

    public ArrayList<Explosive> getExplosives() {
        return this.explosives;
    }
    public void settings() {
        this.size(800,800);
    }

    public ArrayList<Fort> forts = new ArrayList<>();


    public void setup() {
        smooth();
       this.player = new PlayerTank(0,600, this);

    }

    public void draw() {
        background(55);
        this.player.move(playerMovementDirection);
        this.player.display();

        //cycle through explosives
        for (int i=0; i<this.explosives.size(); i++) {
            Explosive projectile = this.explosives.get(i);
            projectile.move();
            projectile.display();
        }

    }
    public void keyPressed()
    {
        if (key == 'a')
        {
            this.playerMovementDirection = -1;
        }

        if (key == 'd')
        {
            this.playerMovementDirection = 1;
        }
    }

    public void keyReleased()
    {
        if (key == 'a' || key == 'd' ){
            this.playerMovementDirection = 0;
        }

         if (key == ' ' && this.player.isReloading() == false) {
           this.player.shoot(this);
           }

    }
}
