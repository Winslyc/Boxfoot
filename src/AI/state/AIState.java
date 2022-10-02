package AI.state;

import AI.AITransition;
import Entity.NPC;
import Game.state.State;

public abstract class AIState {
    private AITransition transition;

    public AIState() {
        this.transition = initializeTransition();
    }

    protected abstract AITransition initializeTransition();
    public abstract void update(State state, NPC currentCharacter);

    public boolean shouldTransition(State state, NPC currentCharacter){
        return transition.shouldTransisition(state, currentCharacter);
    }
    public String getNextState(){
        return transition.getNextState();
    }

}
