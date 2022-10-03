package Entity.action;

import Entity.MovingEntity;
import Game.Game;
import Game.GameLoop;
import Game.state.State;

public class Cough extends Action{
    private int lifeSpaninSeconds;

    public Cough() {
        lifeSpaninSeconds = GameLoop.UPDATES_PER_SECOND;
    }

    @Override
    public void update(State state, MovingEntity entity) {
        lifeSpaninSeconds--;
    }

    @Override
    public boolean isDone() {
        return  lifeSpaninSeconds <= 0;
    }

    @Override
    public String getAnimationName() {
        return "cough";
    }
}
