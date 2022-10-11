package HelperCore;

// provide positioning for an object.
public class Position {
    public static int PROXIMITY_RANGE = 5;
    private double x;
    private double y;
    public Position (double x, double y){
        this.x = x;
        this.y = y;
    }

    public static Position copyOf(Position position) {
        return new Position(position.getX(), position.getY());
    }

    public void setX(int x) {
        this.x=x;
    }

    public void setY(int y) {
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void apply(Motion motion) {
        Vector2D vector = motion.getVector();
        x += vector.getX();
        y += vector.getY();
    }
    public void show(){
        System.out.println( x + " " + y);
    }

    public boolean isInRangeOf(Position position) {
        return Math.abs(x - position.getX()) < Position.PROXIMITY_RANGE && Math.abs(y - position.getY()) < Position.PROXIMITY_RANGE;
    }

    public void applyX(Motion motion) {
        x += motion.getVector().getX();
    }
    public void applyY(Motion motion) {
        y+=motion.getVector().getY();
    }
}
