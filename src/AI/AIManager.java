package AI;

import AI.state.AIState;
import AI.state.Stand;
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
        System.out.println("Transitioning to " + nextState);
        switch (nextState){

            case "stand":
            default:
                currentAIState = new Stand();
        }
    }

}
