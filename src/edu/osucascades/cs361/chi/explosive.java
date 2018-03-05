package edu.osucascades.cs361.chi;



public class Explosive {
    public int x = 0;
    public int y = -100;
    public Sketch canvas;

    public Explosive() {

    }
    public Explosive(Sketch p) {
        this.canvas = p;
    }

    public void launch(PlayerTank p) {
        this.x = p.x;
        this.y = p.y;

    }

    public void move() {
        this.y = this.y - 10;
    }

    public void display() {
        this.move();
        canvas.rect(this.x + 24, this.y - 10, 3, 10);
        canvas.fill(255);
    }
}