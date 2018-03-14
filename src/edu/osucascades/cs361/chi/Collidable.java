package edu.osucascades.cs361.chi;

import java.util.ArrayList;

public interface Collidable {
     default boolean isTouching(Collidable collidableEntity) {
          boolean isTouchingEntity = false;
          if (this.getX() >= collidableEntity.getX() && this.getX() +  this.getWidth() <= collidableEntity.getX() + collidableEntity. getWidth()) {
               if (this.getY() >= collidableEntity.getY() && this.getY()  + this.getHeight() <= collidableEntity.getY() +  collidableEntity.getHeight()) {
                    isTouchingEntity = true;
               }
          }
          return isTouchingEntity;
     }

     int getX();
     int getY();

     int getHeight();
     int getWidth();

     void kill(ArrayList collidable, ArrayList entities);
}

