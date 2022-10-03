package Game.state;

import Display.Camera;
import Entity.GameObject;
import Game.Time;
import HelperCore.Position;
import HelperCore.Size;
import Input.Input;
import Maps.GameMap;
import gfx.SpriteLibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public abstract class State {
    protected GameMap gameMap;
    protected List<GameObject> gameObjects;
    protected SpriteLibrary spriteLibrary;
    private Input input;
    protected Camera camera;
    protected Time time;

    public Time getTime() {
        return time;
    }

    public State(Size WindowSize, Input input) {
        this.input = input;
        gameObjects = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        camera = new Camera(WindowSize);
        time = new Time(0);

    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void update(){
        sortObjectsByPosition();
        gameObjects.forEach(gameObject -> gameObject.update(this));
        camera.update(this);
    }

    private void sortObjectsByPosition() {
        gameObjects.sort(Comparator.comparing(gameObjects -> gameObjects.getPosition().getY()));
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Camera getCamera() {
        return camera;
    }

    public Position getRandomPosition() {

        return gameMap.getRandomPosition();
    }

    public List<GameObject> getCollidingGameObjects(GameObject gameObject) {
        return gameObjects.stream().filter(other -> other.collidesWith(gameObject))
                .collect(Collectors.toList());
    }
}
