package HelperCore;

// provide positioning for an object.
public class Position {
    private int x;
    private int y;
    public Position (int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void apply(Motion motion) {
        Vector2D vector = motion.getVector();
        x += vector.getX();
        y += vector.getY();
        System.out.println( x + " " + y);

    }
}
