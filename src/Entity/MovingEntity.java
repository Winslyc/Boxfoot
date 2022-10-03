package Entity;

import Controller.Controller;
import Game.state.State;
import HelperCore.Direction;
import HelperCore.Motion;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.awt.*;

public abstract class MovingEntity extends GameObject {// Abstract class updates movement for All moving entitiies.
    protected Controller controller;
    protected Motion motion;
    protected AnimationManager animationManager;
    protected Direction direction;

    public MovingEntity(Controller controller, SpriteLibrary spriteLibrary){

        super();
        this.controller = controller;
        this.motion= new Motion(2);
        this.direction = Direction.S;
        manageDirection();
        this.animationManager = new AnimationManager(spriteLibrary.getUnit("dave"));
    }
    private void decideAnimation(){
    if(motion.isMoving()){
        animationManager.playAnimation("walk");
    }
    else{
        animationManager.playAnimation("stand");
    }
    }
    @Override
    public void update(State state){
        motion.update(controller);
        position.apply(motion);
        manageDirection();
        decideAnimation();
        animationManager.update(direction);

    }
    private void manageDirection(){
        if(motion.isMoving()){
            this.direction = Direction.fromMotion(motion);
        }
    }

    @Override
    public Image getSprite() {

        return animationManager.getSprite();
    }

    public Object getController() {
        return controller;
    }
}
