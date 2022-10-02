package Entity;

import Game.state.State;
import HelperCore.Position;
import HelperCore.Size;

import java.awt.*;
// Abstract class to represent objects in the game example: players, enemies, guns, powerups.
public abstract class GameObject {
    protected Position position;
    protected Size size;
    public GameObject(){
        position = new Position( 50, 50);
        size = new Size( 64, 64);

    }
    public GameObject(Position position, Size size){
        this.position = position;
        this.size = size;
    }
    public abstract void update(State state);
    public abstract Image getSprite();
    public Size getSize(){
        return size;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}