package gfx;

import Game.Game;
import HelperCore.Direction;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private String currentAnimationName;
    private SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private int currentFrameTime;
    private int updatesperFrame;
    private int frameIndex;
    private int directionIndex;

    public AnimationManager(SpriteSet spriteSet){
        this.spriteSet = spriteSet;
        this.updatesperFrame = 10;
        this.frameIndex = 0;
        this.currentFrameTime = 0;
        this.directionIndex = 0;
        playAnimation("stand");

    }
    public Image getSprite(){/* Returns a subimage from the sprite sheet for each animation /Direction is shown by row and Frames are shown by column
         There are 8 directions and 4 fram indexes*/
        return currentAnimationSheet.getSubimage(
                frameIndex * Game.SPRITE_SIZE,
                directionIndex * Game.SPRITE_SIZE,
                Game.SPRITE_SIZE,
                Game.SPRITE_SIZE
        );
    }
    public void update( Direction direction) {// Takes in a direction then updates the animation.
        currentFrameTime++;

        if(currentFrameTime >= updatesperFrame){
            currentFrameTime = 0;
            directionIndex = direction.getAnimationRow();
            frameIndex++;

            if(frameIndex >= currentAnimationSheet.getWidth() / Game.SPRITE_SIZE){
                frameIndex = 0;
            }
        }
    }
    public void playAnimation(String name){ //Pulls Image from Resources to make an animation.
        if(!name.equals(currentAnimationName)) {
            this.currentAnimationSheet=(BufferedImage) spriteSet.get(name);
            currentAnimationName = name;
            frameIndex = 0;
        }

    }
}
