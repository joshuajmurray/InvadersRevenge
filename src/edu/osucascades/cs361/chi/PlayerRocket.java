package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public class PlayerRocket implements Collidable, Drawable {

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

    public void kill(ArrayList collidables, ArrayList entities) {
        collidables.remove(this);
        entities.remove(this);
        canvas.game.getPlayer().setReloading(false);
    }

    private void move() {
        if (this.y < 0){
            this.kill(this.canvas.game.getCollidables(), this.canvas.game.getEntities());
        }
        this.y = this.y + direction;
    }

    public void draw() {
        this.move();
        canvas.rect(this.x, this.y, width, height);
        canvas.fill(255);
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