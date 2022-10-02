package Maps;

import gfx.SpriteLibrary;

import java.awt.*;

public class Tile {
    private Image sprite;

    public Tile(SpriteLibrary spriteLibrary){
        this.sprite = spriteLibrary.getTile("WoodFloor2");


    }

    public Image getSprite() {
        return sprite;
    }
}
