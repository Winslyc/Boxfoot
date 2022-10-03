package Controller;

import HelperCore.Position;

public class NPCController implements Controller {
    private boolean up;
    private boolean right;
    private boolean down;
    private boolean left;
    @Override
    public boolean isRequestingUp() {
        return up;
    }

    @Override
    public boolean isRequestingRight() {
        return right;
    }

    @Override
    public boolean isRequestingDown() {
        return down;
    }

    @Override
    public boolean isRequestingLeft() {
        return left;
    }

    public void moveToTarget(Position target, Position current) {
        double deltax = target.getX() - current.getX();
        double deltay = target.getY() - current.getY();

        up = deltay < 0 && Math.abs(deltay)> Position.PROXIMITY_RANGE;
        right = deltax > 0 && Math.abs(deltax)> Position.PROXIMITY_RANGE;
        down = deltay > 0 && Math.abs(deltay)> Position.PROXIMITY_RANGE;
        left = deltax < 0 && Math.abs(deltax)> Position.PROXIMITY_RANGE;


    }

    public void stop() {
        up = false;
        right = false;
        down = false;
        left = false;
    }
}
