package Game;

import Display.Display;
import Game.Settings.GameSettings;
import Game.state.GameState;
import Game.state.State;
import HelperCore.Size;
import Input.Input;

public class Game {
    public static int SPRITE_SIZE = 64;
    private Display display;
    private Input input;
    private State state;
    private GameSettings settings;
    // passing in parameters for game size.
    public Game(int width, int height){
        input=new Input();
        display = new Display(width,height, input);
        state = new GameState(new Size(width, height), input);
        settings = new GameSettings(true);
         }
         public void update(){
        state.update();
         }
    public void render(){
        display.render(state, settings.isDebugMode());

    }


}
