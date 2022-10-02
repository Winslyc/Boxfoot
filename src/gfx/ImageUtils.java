package gfx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
// Pulls image path from resources for graphics.
public class ImageUtils {
    public static Image loadImage(String filepath){
        try{
            return ImageIO.read(ImageUtils.class.getResource(filepath));

        }
        catch(IOException e){
            System.out.println("Could not load image from path"+ filepath);

        }
        return null;
    }
}
