package AI.state;

import AI.AITransition;
import Controller.NPCController;
import Entity.NPC;
import Game.state.State;
import HelperCore.Position;

import java.util.ArrayList;
import java.util.List;

public class Wander extends AIState{
    private List<Position> targets;

    public Wander() {
        super();
        targets = new ArrayList<>();
    }

    @Override
    protected AITransition initializeTransition() {
        return new AITransition("stand", ((state, currentCharacter) -> arrived(currentCharacter)));
    }

    @Override
    public void update(State state, NPC currentCharacter) {
        if(targets.isEmpty()){
            targets.add(state.getRandomPosition());
        }
        NPCController controller = (NPCController) currentCharacter.getController();
        controller.moveToTarget(targets.get(0), currentCharacter.getPosition());

        if(arrived(currentCharacter)){
            controller.stop();
        }

    }
    private boolean arrived(NPC currentCharacter){
        return currentCharacter.getPosition().isInRangeOf(targets.get(0));
    }
}
