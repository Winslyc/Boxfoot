package Display;

import Game.Game;
import Game.state.State;
import Input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {
    private Canvas canvas;
    private Renderer renderer;

    public Display(int width, int height, Input input){
        setTitle("Box Foot");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.renderer = new Renderer();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        //Creates buffer for screens to load
        canvas.createBufferStrategy(3);
    }
    public void render(State state){//Renders Background for screen to be Drawn To
        BufferStrategy bufferStrategy= canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, canvas.getWidth(), canvas.getHeight());
        renderer.render(state, graphics);
        graphics.dispose();
        bufferStrategy.show();
    }
}
