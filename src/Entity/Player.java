package Entity;

import Controller.Controller;
import Entity.effect.Caffeinated;
import HelperCore.CollisionBox;
import gfx.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends MovingEntity{// Creates a controllable player that can be controlled with controller
    @Override
    public boolean collidesWith(GameObject other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    @Override
    protected void handleCollision(GameObject other) {

    }

    public Player(Controller controller, SpriteLibrary spriteLibrary){
    super(controller, spriteLibrary);
    effects.add(new Caffeinated());
}


}
