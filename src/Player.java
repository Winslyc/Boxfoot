import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{
private Controller controller;
public Player(Controller controller){
    super();
    this.controller=controller;
}
    @Override
    public void update() {
    int deltaX = 0;
    int deltaY = 0;
    if(controller.isRequestingUp()){
        deltaY--;
    }
    if(controller.isRequestingDown()){
            deltaY++;
    }
    if(controller.isRequestingRight()){
            deltaX++;
    }
    if(controller.isRequestingLeft()){
            deltaX--;
        }
    position =new Position(position.getX() + deltaX, position.getY() + deltaY);
    }

    @Override
    //Create image of blue square  to represent the player in the game
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setColor(Color.blue);
        graphics.fillRect(0,0,size.getWidth(),size.getHeight());

        graphics.dispose();
        return image;
    }
}
