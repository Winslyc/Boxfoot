package AI;

import AI.state.AIState;
import AI.state.Stand;
import AI.state.Wander;
import Entity.NPC;
import Game.state.State;

public class AIManager {
    private AIState currentAIState;

    public AIManager() {
        transitionTo("stand");
    }
    public void update(State state, NPC currentCharacter){
        currentAIState.update(state, currentCharacter);

        if(currentAIState.shouldTransition(state, currentCharacter)){
            transitionTo(currentAIState.getNextState());
        }

    }

    private void transitionTo(String nextState) {
        switch (nextState){

            case "stand": currentAIState = new Stand();
            return;
            case "wander": currentAIState = new Wander();
            return;

            default:
                currentAIState = new Stand();
        }
    }

}
