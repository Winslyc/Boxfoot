package AI;

import Entity.NPC;
import Game.state.State;

public class AITransition {
    private String nextState;
    private AICondition condition;

    public AITransition(String nextState, AICondition condition) {
        this.nextState=nextState;
        this.condition=condition;
    }
    public boolean shouldTransisition(State state, NPC currentCharacter){
        return condition.isMet(state, currentCharacter);
    }

    public String getNextState() {
        return nextState;
    }
}
