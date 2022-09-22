package HelperCore;

import Controller.Controller;

public class Movement {
    private Vector2D vector;
    private double speed;

    public Movement(double speed) {
        this.speed = speed;
        this.vector = new Vector2D(0,0);
    }
    public void update(Controller controller) {
        int deltaX=0;
        int deltaY=0;
        if (controller.isRequestingUp()) {
            deltaY--;
        }
        if (controller.isRequestingDown()) {
            deltaY++;
        }
        if (controller.isRequestingRight()) {
            deltaX++;
        }
        if (controller.isRequestingLeft()) {
            deltaX--;
        }
        vector=new Vector2D(deltaX, deltaY);
        vector.multiply(speed);
    }

    public Vector2D getVector() {
        return vector;
    }
}
