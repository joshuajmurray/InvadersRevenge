package edu.osucascades.cs361.chi;

public interface Collidable {
     boolean checkCollisions(Collidable a, Collidable b);
     int getX();
     int getY();
     int getHeight();
     int getWidth();
     void kill();
}

