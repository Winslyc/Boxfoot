package HelperCore;
import Controller.Controller;

public class Vector2D {
    private double x;
    private double y;


    public Vector2D(double x, double y) {
        this.x=x;
        this.y=y;

    }

    public void multiply(double speed) {
        x *= speed;
        y *= speed;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double length() {
        return (x * x + y * y);

    }
}
