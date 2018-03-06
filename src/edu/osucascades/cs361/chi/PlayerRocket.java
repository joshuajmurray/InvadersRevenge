package edu.osucascades.cs361.chi;

public class PlayerRocket extends Explosive {

    public Sketch canvas;
    private Tank player;

    public PlayerRocket(Sketch canvas, Tank player) {
        super(canvas,-10, player);
        this.canvas = canvas;
        this.player = player;
        this.canvas.explosives.add(this);
    }

    public void launch(Tank p) {
        this.player.setReloading(true);
        super.launch(p);
    }

    public void move() {
        if (super.y < 0){
            this.player.setReloading(false);
            this.canvas.explosives.remove(this);
        }
        super.move();
    }

    public void display() {
        super.display();
    }

}