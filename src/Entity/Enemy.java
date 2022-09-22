package Entity;

import Controller.Controller;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends MovingEntity{
    public Enemy(Controller controller) {
        super(controller);
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
