package Entity.effect;

import Entity.MovingEntity;
import Entity.action.Cough;
import Game.GameLoop;
import Game.state.State;

public class Sick extends Effect {
    private static final double coughRate = 1d / GameLoop.UPDATES_PER_SECOND / 10;
    public Sick() {
        super(Integer.MAX_VALUE);
    }

    public void update(State state, MovingEntity entity){
        super.update(state, entity);
        if (Math.random() < coughRate){
            entity.perform(new Cough());
        }
    }

}
