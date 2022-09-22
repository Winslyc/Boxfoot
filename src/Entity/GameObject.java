package Entity;

import HelperCore.Position;
import HelperCore.Size;

import java.awt.*;
// Abstract class to represent objects in the game example: players, enemies, guns, powerups.
public abstract class GameObject {
    protected Position position;
    protected Size size;
    public GameObject(){
        position = new Position( 50, 50);
        size = new Size( 50, 50);

    }
    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }
}