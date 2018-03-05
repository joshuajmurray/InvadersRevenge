package edu.osucascades.cs361.chi;

public class playerRocket extends Explosive {

    public int x = 0;
    public int y = -100;
    public Sketch canvas;
    private Tank player;
    public int locationInExplosiveArray;

    public playerRocket( int x,int y, Sketch canvas, Tank player) {
        this.canvas = canvas;
        super.canvas = canvas;

        this.player = player;
        this.x = x;
        this.y = y;
        this.locationInExplosiveArray = this.canvas.explosives.size();
        this.canvas.explosives.add(this);
    }

    public void launch(Tank p) {
        this.player.setReloading(true);
        super.launch(p);
    }

    public void move() {
        if (super.y < 0){
            this.player.setReloading(false);
            this.canvas.explosives.remove(locationInExplosiveArray);
        }
        super.move();
    }

    public void display() {
        super.display();
    }

}