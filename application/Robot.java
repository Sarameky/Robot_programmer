package application;

public class Robot {
    private int x;
    private int y;
    private double angle;


    public Robot(int x, int y, char direction) {
        setX(x);
        setY(y);
        angle = convertDirectionToRadiant(direction);
        //setCommands(commands);

    }

    public void turnLeft() {
        angle += Math.PI / 2;
    }

    public void turnRight() {
        angle -= Math.PI / 2;
    }

    public void moveForward() {
        x += (int) Math.cos(angle);

        y -= (int) Math.sin(angle);// advancing in the "negative direction"
    }

    public double convertDirectionToRadiant(char d) {
        switch (d) {
            case 'N':
                return Math.PI / 2;
            case 'S':
                return -Math.PI / 2;
            case 'E':
                return 0.0;
            case 'W':
                return Math.PI;
            default:
                return 0;
        }
    }

    public char convertAngleToDirection() {
        if (Math.sin(angle) == 1)
            return 'N';
        if (Math.sin(angle) == -1)
            return 'S';
        if (Math.cos(angle) == 1)
            return 'E';

        return 'W';
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
