package Entity.action;

import Entity.MovingEntity;
import Game.state.State;

public abstract class Action {
    public abstract void update(State state, MovingEntity entity);
    public abstract boolean isDone();
    public abstract String getAnimationName();
}
