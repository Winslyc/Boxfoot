package Entity;

import Controller.Controller;
import gfx.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends MovingEntity{// Creates a controllable player that can be controlled with controller
public Player(Controller controller, SpriteLibrary spriteLibrary){
    super(controller, spriteLibrary);
}


}
