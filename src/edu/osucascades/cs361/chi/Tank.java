package edu.osucascades.cs361.chi;

public class Tank extends VehicleSuper {

    private int width = 50;
    private int height = 15;
    private Sketch canvas;

    Tank(int x, int y, Sketch canvas){
        super(x, y ,'t', canvas);
        super.setHeight(this.height);
        super.setWidth(this.width);

        this.canvas = canvas;
        this.canvas.vehicles.add(this);
    }

    public void updateDirection(int direction){
        super.setxSpeed(direction);
    }

    public void shoot(Sketch canvas) {
        PlayerRocket rocket = new PlayerRocket(canvas, this);
        rocket.launch(this);
    }

}
