package edu.osucascades.cs361.chi;


public class VehicleSuper {
    private int x;
    private int y;
    private int width;
    private int height;

    private Sketch canvas;
    private int xSpeed = 1;
    private boolean reloading;
    char child;

    VehicleSuper(int x, int y,char childType, Sketch canvas){
        this.x = x;
        this.y = y;
        this.child = childType;
        this.canvas = canvas;
    }

    private void move() {
        if (this.child == 't') {
            if (this.x < 0) {
                this.x = 0;
            }

            if (this.x > this.canvas.width) {
                this.x = this.canvas.width;
            }

            this.x = this.x + this.xSpeed;
        }

        if (this.child == 'a') {
            if (this.xSpeed == 1) {
                this.x += 1;

                if (this.x == canvas.width - this.width) {
                    this.xSpeed = 0;
                    this.y += 30;
                }
            }

            if (this.xSpeed == 0) {
                this.x -= 1;
                
                if (this.x == 0) {
                    this.xSpeed = 1;
                }
            }
        }
    }

    public void draw() {
        if (this.child == 't'){
            this.move();
            canvas.rect(this.x, this.y, this.width, this.height);
            canvas.fill(255, 0, 0);
        }

        if (this.child == 'a'){
            canvas.fill(0, 255, 50);
            canvas.rect(x, y, width, height);
            move();
        }
    }

    public void kill(){
        this.canvas.vehicles.remove(this);
    }

    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }

    public void setxSpeed(int x){
        this.xSpeed = x * 3;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getY() {
        return y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

}
