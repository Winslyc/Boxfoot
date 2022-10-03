package Game.state;

import Controller.NPCController;
import Controller.PlayerController;
import Entity.NPC;
import Entity.Player;
import Entity.action.Cough;
import Entity.effect.Sick;
import HelperCore.Size;
import Input.Input;
import Maps.GameMap;

public class GameState extends State {
    private static final int gameWidth = 20;
    private static final int gameHeight = 20;
    public GameState(Size windowSize, Input input) {
        super(windowSize, input);
        gameMap = new GameMap(new Size(gameWidth,  gameHeight), spriteLibrary);
        initializeCharacters(input);

    }
    private void initializeCharacters(Input input){

        Player player = new Player(new PlayerController(input), spriteLibrary);
        gameObjects.add(player);
        camera.focusOn(player);
        initializeNPCS(100);
    }

    private void initializeNPCS(int numberOfNPCs) {
        for(int i = 0; i < numberOfNPCs; i ++){
            NPC npc = new NPC( new NPCController(), spriteLibrary);
            npc.setPosition(gameMap.getRandomPosition());
            gameObjects.add(npc);
            npc.addEffect(new Sick());
        }
    }

    public static int getGameHeight() {
        return gameHeight;
    }
    public static int getGameWidth() {
        return gameWidth;
    }
}
