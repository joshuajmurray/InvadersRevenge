package edu.osucascades.cs361.chi;

public class PlayerRocket implements Collidable, Entity {

    private int x;
    private int y;
    private int width = 3;
    private int height = 10;
    private int direction;
    private Sketch canvas;

    PlayerRocket(Sketch canvas, Tank player, int direction) {
        this.x = player.getX() + player.getWidth()/2;
        this.y = player.getY() - player.getHeight() - 5;
        this.canvas = canvas;
        this.direction = direction;
    }

    public void kill() {
        this.canvas.Collidables.remove(this);
        this.canvas.entities.remove(this);
        canvas.player.setReloading(false);
    }

    public void move() {
        if (this.y < 0){
            canvas.player.setReloading(false);
            this.canvas.Collidables.remove(this);
            this.canvas.entities.remove(this);
        }
        this.y = this.y + direction;
    }

    public void draw() {
        this.move();
        canvas.rect(this.x, this.y, width, height);
        canvas.fill(255);
    }
    public boolean checkCollisions(Collidable EntityA, Collidable EntityB){
        boolean b = false;
        if (EntityA.getX() >= EntityB.getX() && EntityA.getX() +  EntityA.getWidth() <= EntityB.getX() + EntityB. getWidth()) {
            if (EntityA.getY() >= EntityB.getY() && EntityA.getY()  + EntityA.getHeight() <= EntityB.getY() +  EntityB.getHeight()) {
                b = true;
            }
        }
        return b;
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

    public int getX() {
        return x;
    }
}