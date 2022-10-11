package Entity;

import AI.AIManager;
import Controller.Controller;
import Entity.MovingEntity;
import Game.state.State;
import HelperCore.Position;
import HelperCore.Size;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

public class NPC extends MovingEntity {
    private AIManager aiManager;
    public NPC(Controller controller, SpriteLibrary spriteLibrary){
        super(controller,spriteLibrary);
        animationManager = new AnimationManager(spriteLibrary.getUnit("matt"));
        aiManager = new AIManager();
    }
    public void update(State state){
        super.update(state);
        aiManager.update(state, this);

    }

    @Override
    protected void handleCollision(GameObject other) {
        if(other instanceof Player){
            motion.stop(willCollideX(other), willCollideY(other));
        }
    }
}
