package Game;

import static Game.Game.SPRITE_SIZE;

public class CollisionBox {
    private int width;
    private int height;
    public CollisionBox(int width, int height){
        this.width = width * SPRITE_SIZE;
        this.height = height * SPRITE_SIZE;
    }

}
