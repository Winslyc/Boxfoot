import Game.Game;
import Game.GameLoop;

public class Launcher {
    public static void main(String[]args){
        new Thread(new GameLoop(new Game(600, 600))).start();
    }
}
