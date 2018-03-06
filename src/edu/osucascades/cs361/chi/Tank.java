package edu.osucascades.cs361.chi;

public class Tank extends VehicleSuper {
    private int x;
    private int y;
    private int width = 50;
    private int height = 15;
    private Sketch canvas;
    private boolean reloading;

    Tank(int x, int y, Sketch canvas){
        super(x, y , canvas);
        this.x = x;
        this.y = y;
        super.setHeight(this.height);
        super.setWidth(this.width);
        this.canvas = canvas;
        super.child = 't';
        this.canvas.vehicles.add(this);
    }

    public void updateDirection(int direction){
        super.setxSpeed(direction);
        this.x = super.getX();
        this.y = super.getY();
    }

    public void shoot(Sketch canvas) {
        PlayerRocket rocket = new PlayerRocket(canvas, this);
        rocket.launch(this);
    }

    public void setReloading(boolean b) {
        this.reloading = b;
    }

    public boolean isReloading() {
        return reloading;
    }
}
