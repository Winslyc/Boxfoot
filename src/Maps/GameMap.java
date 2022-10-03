package Maps;

import Display.Camera;
import Game.Game;
import HelperCore.Position;
import HelperCore.Size;
import gfx.SpriteLibrary;

import java.util.Arrays;

public class GameMap {
    private Tile [][] tiles;
    private static final int SAFETY_SPACE = 5;

    public GameMap(Size size, SpriteLibrary spriteLibrary) {
        tiles = new Tile[size.getWidth()][size.getHeight()];
        initializeTiles(spriteLibrary);
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    private void initializeTiles(SpriteLibrary spriteLibrary) {
        for(Tile[] row: tiles) {
            Arrays.fill(row, new Tile(spriteLibrary));
        }

    }

    public int getWidth() {
        return tiles.length * Game.SPRITE_SIZE;
    }

    public int getHeight() {
        return tiles[0].length * Game.SPRITE_SIZE;
    }

    public Position getRandomPosition() {
        double x = Math.random() * tiles.length * Game.SPRITE_SIZE;
        double y = Math.random() * tiles[0].length * Game.SPRITE_SIZE;
        return new Position(x, y);
    }

    public Position getViewableStart(Camera camera) {
        return new Position(
                Math.max(0,camera.getPosition().getX() /Game.SPRITE_SIZE - SAFETY_SPACE),
                Math.max(0, camera.getPosition().getY()/Game.SPRITE_SIZE- SAFETY_SPACE)
        );
    }

    public Position getViewableEnd(Camera camera) {
        return new Position(
                Math.min(tiles.length, camera.getPosition().getX()/Game.SPRITE_SIZE + camera.getWindowSize().getWidth() / Game.SPRITE_SIZE  + SAFETY_SPACE),
                Math.min(tiles[0].length, camera.getPosition().getY()/Game.SPRITE_SIZE + camera.getWindowSize().getHeight() / Game.SPRITE_SIZE + SAFETY_SPACE)
        );
    }
}
