package HelperCore;

import java.awt.*;

import static Game.Game.SPRITE_SIZE;

public class CollisionBox {
    private Rectangle bounds;

    public CollisionBox(Rectangle bounds){
        this.bounds = bounds;
    }

    public static CollisionBox of(Position position, Size size) {
        return new CollisionBox(new Rectangle(
                (int)position.getX(),
                (int) position.getY(),
                size.getWidth(),
                size.getHeight()
        ));
    }

    public boolean collidesWith(CollisionBox other){
        return bounds.intersects(other.getBounds());
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
