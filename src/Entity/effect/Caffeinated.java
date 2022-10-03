package Entity.effect;

import Entity.MovingEntity;
import Game.GameLoop;
import Game.state.State;

public class Caffeinated extends Effect {
    private double speedMultiplier;
    public Caffeinated() {
        super(GameLoop.UPDATES_PER_SECOND * 5);
        speedMultiplier = 2;
    }
    @Override
    public void update(State state, MovingEntity entity){
        super.update(state, entity);
        entity.multiplySpeed(speedMultiplier);
    }
}
