package Entity.effect;

import Entity.MovingEntity;
import Game.state.State;

public abstract class Effect {
    private int lifeSpanUpdates;

    public Effect(int lifeSpanUpdates) {
        this.lifeSpanUpdates=lifeSpanUpdates;
    }
    public void update(State state, MovingEntity entity){
        lifeSpanUpdates--;
    }
    public boolean shouldDelete(){
        return  lifeSpanUpdates <= 0;
    }
}
