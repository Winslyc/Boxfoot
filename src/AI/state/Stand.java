package AI.state;

import AI.AITransition;
import Entity.NPC;
import Game.state.State;

public class Stand extends AIState{
    private int updatesAlive;// Since started standing how many updates has this movement been happening.

    public Stand() {
        super();
    }


    @Override
    protected AITransition initializeTransition() {
        return new AITransition("wander", (state, currentCharacter) -> updatesAlive >= state.getTime().getUpdatesFromSeconds(3));
    }

    @Override
    public void update(State state, NPC currentCharacter) {
    updatesAlive++;
    }
}
