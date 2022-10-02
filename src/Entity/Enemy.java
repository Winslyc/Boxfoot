package Entity;

import Controller.Controller;
import gfx.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends MovingEntity{
    public Enemy(Controller controller) {
        //TODO come back to this to  intialize sprite library properly.
        super(controller, new SpriteLibrary());
    }

    @Override
    public Image getSprite() {
        BufferedImage image=new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics=image.createGraphics();

        graphics.setColor(Color.red);
        graphics.fillRect(23, 25, size.getWidth(), size.getHeight());

        graphics.dispose();
        return image;
    }
}
