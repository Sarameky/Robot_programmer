package application;

import java.util.regex.Pattern;

public class Controller {

    private final int roomLength;
    private final int roomDepth;
    private String commands;
    private final Robot robot;

    public Controller(int xRoom, int yRoom, String commands, Robot robot) {
        roomLength = xRoom;
        roomDepth = yRoom;
        this.robot = robot;
        setCommands(commands);
    }


    public void moveToDestination() {
        for (int i = 0; i < commands.length(); i++) {
            char c = commands.charAt(i);
            switch (c) {
                case 'L':
                    robot.turnLeft();
                    break;
                case 'R':
                    robot.turnRight();
                    // System.out.println("after R: "+robot.getX()+","+ robot.getY()+","+ robot.convertAngleToDirection());
                    break;
                case 'F':
                    int xRobot = robot.getX() + (int) Math.cos(robot.getAngle());
                    int yRobot = robot.getX() - (int) Math.sin(robot.getAngle());

                    if (xRobot > roomLength || xRobot < 0 || yRobot > roomDepth || yRobot < 0)
                        throw new IllegalStateException("Error, the robot cannot proceed forward!");
                    robot.moveForward();
                    // System.out.println("after F: "+robot.getX()+","+ robot.getY()+","+ robot.convertAngleToDirection());
                    break;
            }
        }

    }

    private void setCommands(String commands) {

        //final Pattern pattern = Pattern.compile("[LRF]*");
        if (Pattern.matches("[LRF]*", commands)) {
            // if (!pattern.matcher(commands).find()) {
            // String contains other characters
            this.commands = commands;
        } else {
            // string contains only those letters
            throw new IllegalArgumentException("Please enter only L R F as commands ");
        }


    }


}
