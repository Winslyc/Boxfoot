import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private Canvas canvas;

    public Display(int width, int hegiht){
        setTitle(" Cool 2d game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,hegiht));
        canvas.setFocusable(false);
        add(canvas);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }
}
