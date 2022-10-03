package Display;

import Game.state.State;
import HelperCore.CollisionBox;

import java.awt.*;

public class DebugRenderer {

    public void render(State state, Graphics graphics){
    Camera camera = state.getCamera();
        state.getGameObjects().stream().filter(gameObject -> camera.isInView(gameObject)).map(gameObject -> gameObject.getCollisionBox())
            .forEach( collisionBox -> drawCollisionBox(collisionBox, graphics, camera));
}
    private  void drawCollisionBox(CollisionBox collisionBox,Graphics graphics, Camera camera){
        graphics.setColor(Color.red);
        graphics.drawRect((int) (collisionBox.getBounds().getX() - camera.getPosition().getX()),
                (int) (collisionBox.getBounds().getY()- camera.getPosition().getY()),
                (int) collisionBox.getBounds().getWidth(),
                (int) collisionBox.getBounds().getHeight());

    }

}
