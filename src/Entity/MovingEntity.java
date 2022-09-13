package Entity;

import Controller.Controller;
import HelperCore.Movement;

public abstract class MovingEntitity extends GameObject {
    private Controller controller;
    private Movement movement;
    public MovingEntitity(Controller controller){
        super();
        this.controller = controller;
    } public void update(){
        movement.update(controller);
        position.apply(movement);

    }
}
