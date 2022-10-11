package Entity;

import Controller.Controller;
import Entity.action.Action;
import Entity.effect.Effect;
import Game.state.State;
import HelperCore.*;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class MovingEntity extends GameObject {// Abstract class updates movement for All moving entitiies.
    protected Controller controller;
    protected Motion motion;
    protected AnimationManager animationManager;
    protected Direction direction;
    protected List<Effect> effects;
    protected Optional<Action> action;
    private int collisionBoxOffset = 10; // used 2 center Collision Box around players

    protected Size collisionBoxSize;
    public MovingEntity(Controller controller, SpriteLibrary spriteLibrary){
        super();
        this.controller = controller;
        this.motion= new Motion(2);
        this.direction = Direction.S;
        manageDirection();
        this.animationManager = new AnimationManager(spriteLibrary.getUnit("dave"));
        effects = new ArrayList<>();
        action = Optional.empty();
        this.collisionBoxSize = new Size(16, 45);
    }
    private void decideAnimation(){
        if(action.isPresent()){
            animationManager.playAnimation(action.get().getAnimationName());
        }else if(motion.isMoving()){
        animationManager.playAnimation("walk");
    }
    else{
        animationManager.playAnimation("stand");
    }
    }
    @Override
    public void update(State state){
        handleAction(state);
        handleMotion();

        animationManager.update(direction);
        effects.forEach(effect -> effect.update(state, this));

        handleCollision(state);
        manageDirection();
        decideAnimation();

        position.apply(motion);
        cleanup();
    }

    private void handleCollision(State state) {
        state.getCollidingGameObjects(this).forEach(this ::handleCollision);
    }

    @Override
    public boolean collidesWith(GameObject other) {
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    @Override
    public CollisionBox getCollisionBox() {
        Position positionWithMotion = Position.copyOf(position);
        positionWithMotion.apply((motion));
        return new CollisionBox(
                new Rectangle(
                (int) positionWithMotion.getX() - collisionBoxOffset ,
                (int) positionWithMotion.getY() - (2*collisionBoxOffset),
                collisionBoxSize.getWidth(),
                collisionBoxSize.getHeight()

             )
        );
    }

    protected abstract void handleCollision(GameObject other);


    private void handleMotion() {// Stops motion if an action is occuring
        if(!action.isPresent()) {
            motion.update(controller);
        } else {
            motion.stop(true, true);
        }
    }

    private void handleAction(State state) {
        if(action.isPresent()){
            action.get().update(state, this);
        }
    }

    private void cleanup() { // Removes effects from a character
        List.copyOf(effects).stream().filter(Effect::shouldDelete)
                .forEach(effects::remove);

        if(action.isPresent() && action.get().isDone()){
            action = Optional.empty();
        }

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

    public void multiplySpeed(double speedMultiplier) {
        motion.multiply(speedMultiplier);
    }

    public void perform(Action action) {
        this.action = Optional.of(action);

    }

    public void addEffect(Effect effect) {
        effects.add(effect);
    }
    public boolean willCollideX(GameObject other){
        CollisionBox otherBox = other.getCollisionBox();
        Position positionWithXApplied = Position.copyOf(position);
        positionWithXApplied.applyX(motion);

        return  CollisionBox.of(positionWithXApplied, collisionBoxSize).collidesWith(otherBox);
    }
    public boolean willCollideY(GameObject other){
        CollisionBox otherBox = other.getCollisionBox();
        Position positionWithYApplied = Position.copyOf(position);
        positionWithYApplied.applyY(motion);

        return  CollisionBox.of(positionWithYApplied, collisionBoxSize).collidesWith(otherBox);
    }
}
