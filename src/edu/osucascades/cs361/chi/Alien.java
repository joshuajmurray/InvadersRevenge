package edu.osucascades.cs361.chi;


public class Alien extends VehicleSuper{
    private Sketch canvas;
    private int width = 30;
    private int height = 30;
    private boolean reloading;

    Alien(int x, int y, Sketch canvas) {
        super(x, y , canvas);
        this.canvas = canvas;

        super.setWidth(this.width);
        super.setHeight(this.height);
        super.child = 'a';
        this.canvas.vehicles.add(this);
    }

    public void kill(){
        this.canvas.screen.updateScore();
        super.kill();
    }

    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }


}
