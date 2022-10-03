package Display;

import Entity.GameObject;
import Game.state.State;
import HelperCore.Position;
import HelperCore.Size;

import java.util.Optional;
// Camera Follows the Player Objects and other OBjects of interest around in the game. For instance if a boss enters on SCreen It will show the boss's first entrance then return to the player.
public class Camera {
    Position position;
    private Size windowSize;
    private Optional<GameObject> objectwithFocus;

    public Camera(Size windowSize) {
        this.position=new Position(0, 0);
        this.windowSize=windowSize;
    }

    public Position getPosition() {
        return position;
    }

    public void focusOn(GameObject object) {
        // Makes an object with focus like a boss monster or player come into focus. Takes in a game object and makes it the object of focus.
        this.objectwithFocus=Optional.of(object);

    }

    public void update(State state) {// Take in a saved state of a game and then updates the camera's movement/focus.
        if (objectwithFocus.isPresent()) {
            Position objectPosition=objectwithFocus.get().getPosition();
            this.position.setX((int)objectPosition.getX() - windowSize.getWidth() / 2);
            this.position.setY((int)objectPosition.getY() - windowSize.getHeight() / 2);

            clampWithinBounds(state);
        }
    }

    private void clampWithinBounds(State state) {// Prevents Camera from moving out of bounds of the Current gameMap.
        if (position.getX() < 0) {
            position.setX(0);
        }
        if (position.getY() < 0) {
            position.setY(0);
        }
        if (position.getX() + windowSize.getWidth() > state.getGameMap().getWidth()) {
            position.setX(state.getGameMap().getWidth() - windowSize.getWidth());
        }
        if (position.getY() + windowSize.getHeight() > state.getGameMap().getHeight()) {
            position.setY(state.getGameMap().getHeight() - windowSize.getHeight());
        }

    }

    public Size getWindowSize() {
        return windowSize;
    }
}