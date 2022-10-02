package Game;

import Controller.PlayerController;
import Display.Display;
import Entity.Enemy;
import Entity.GameObject;
import Entity.Player;
import Game.state.GameState;
import Game.state.State;
import HelperCore.Size;
import Input.Input;
import gfx.SpriteLibrary;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int SPRITE_SIZE = 64;
    private Display display;
    private Input input;
    private State state;
    // passing in parameters for game size.
    public Game(int width, int height){
        input=new Input();
        display = new Display(width,height, input);
        state = new GameState(new Size(width, height), input);

         }
         public void update(){
        state.update();
         }
    public void render(){
        display.render(state);

    }


}
