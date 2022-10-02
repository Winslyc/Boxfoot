package Game.state;

import Controller.NPCController;
import Controller.PlayerController;
import Entity.NPC;
import Entity.Player;
import HelperCore.Position;
import HelperCore.Size;
import Input.Input;
import Maps.GameMap;

import java.util.List;

public class GameState extends State {
    private static final int gameWidth = 20;
    private static final int gameHeight = 20;
    public GameState(Size windowSize, Input input) {
        super(windowSize, input);
        initializeCharacters(input);
        gameMap = new GameMap(new Size(gameWidth,  gameHeight), spriteLibrary);
    }
    private void initializeCharacters(Input input){

        Player player = new Player(new PlayerController(input), spriteLibrary);
        NPC npc = new NPC( new NPCController(), spriteLibrary);
        npc.setPosition( new Position(200, 240));
        NPC bitch = new NPC( new NPCController(), spriteLibrary);
        gameObjects.addAll(List.of(player, npc));

        camera.focusOn(player);
    }

    public static int getGameHeight() {
        return gameHeight;
    }
    public static int getGameWidth() {
        return gameWidth;
    }
}
