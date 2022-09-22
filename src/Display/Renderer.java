package Display;

import Game.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Renderer {
    public void render(Game game, Graphics graphics){
        game.getGameObjects().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                null));

}

}
