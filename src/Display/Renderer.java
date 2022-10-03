package Display;

import Game.Game;
import Game.state.State;
import HelperCore.Position;
import Maps.GameMap;
import Maps.Tile;

import java.awt.*;
// Renders Game maps and Sprites to the screen like Player characters and obstacles.
public class Renderer {
    public void render(State state, Graphics graphics) {
        renderMap(state, graphics);
        Camera camera = state.getCamera();
        state.getGameObjects().stream().filter(gameObject -> camera.isInView(gameObject))
                .forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                (int)gameObject.getPosition().getX()  - (int)camera.getPosition().getX() - gameObject.getSize().getWidth() / 2 ,
                (int)gameObject.getPosition().getY() - (int)camera.getPosition().getY() - gameObject.getSize().getHeight() / 2,
                null));

    }

    private void renderMap(State state, Graphics graphics) {
        GameMap map = state.getGameMap();
        Camera camera = state.getCamera();
        Position start = map.getViewableStart(camera);
        Position end = map .getViewableEnd(camera);
        for (int x=(int) start.getX(); x < end.getX(); x++) {
            for (int y=(int) start.getY(); y < end.getY(); y++) {
                graphics.drawImage(
                        map.getTiles()[x][y].getSprite(),
                        x * Game.SPRITE_SIZE - (int)camera.getPosition().getX(),
                        y * Game.SPRITE_SIZE - (int)camera.getPosition().getY(),
                        null);


            }
        }

    }
}