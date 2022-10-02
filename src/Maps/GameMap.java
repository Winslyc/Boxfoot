package Maps;

import Game.Game;
import HelperCore.Size;
import gfx.SpriteLibrary;

import java.util.Arrays;

public class GameMap {
    private Tile [][] tiles;

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
}
