package edu.osucascades.cs361.chi;

import processing.core.PApplet;

public class Fort implements Collidable, Drawable  {

    private int x;
    private int y;
    private int width = 40;
    private int height = 30;
    private int lifeRemaining;
    private PApplet p;
    public Sketch canvas;

    public Fort(int x, int y, int lifeRemaining, PApplet p) {
        this.x = x;
        this.y = y;
        this.lifeRemaining = lifeRemaining;
        this.p = p;
    }

    private void decay(int amount) {
        lifeRemaining -= amount;
    }

    public void kill() {
        decay(10);
        if (this.lifeRemaining == 0){
            this.canvas.game.collidables.remove(this);
            this.canvas.game.entities.remove(this);
        }
    }

    public void draw() {
        p.fill(255, 0 , 0);
        p.rect(x, y, width, height);
    }

    @Override
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
