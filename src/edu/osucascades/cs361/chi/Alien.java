package edu.osucascades.cs361.chi;


public class Alien extends VehicleSuper{
    private Sketch canvas;
    private int x;
    private int y;
    private int width = 30;
    private int height = 30;
    private int direction = 1;
    private boolean reloading;

    Alien(int x, int y, Sketch canvas) {
        super(x, y , canvas);
        this.canvas = canvas;
        this.x = x;
        this.y = y;
        super.width = this.width;
        super.height = this.height;
        super.child = 'a';
        this.canvas.vehicles.add(this);
    }

    public void draw() {
        canvas.fill(0, 255, 50);
        canvas.rect(x, y, width, height);
        move();
    }

    private void move() {
        if (this.direction == 1) {
            this.x += 1;
            if (this.x == canvas.width - this.width) {
                this.direction = 0;
            }
        }
        if (this.direction == 0) {
            this.x -= 1;
            if (this.x == 0) {
                this.direction = 1;
            }
        }
    }
    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }


}
