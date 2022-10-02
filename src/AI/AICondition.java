package AI;

import Entity.NPC;
import Game.state.State;

public interface AICondition {
    boolean isMet(State state, NPC currentCharacter);
}
