package Entity.Weapons;

import Entity.GameObject;

import java.awt.*;

public abstract class Weapon extends GameObject {
    private String Name;
    private String type;
    private int[] damageRange;
    private int criticalChance;
    private int critMultiplier;
    public void attack() {
    }
    public void defend(){
    }


    @Override
    public Image getSprite() {return null;
    }
}
