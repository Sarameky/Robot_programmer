package Test;

import application.Robot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    private Robot robot;//= new Robot(1,2, 'N');

    @BeforeEach
    void setUp() {
        robot = new Robot(1, 2, 'N');
    }

    @AfterEach
    public void tearDown() {
        robot = null;
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        robot.turnLeft();
        assertEquals('W', robot.convertAngleToDirection(), "Robot did not turn left");
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        robot.turnRight();
        assertEquals('E', robot.convertAngleToDirection(), "Robot did not turn right");
    }

    @org.junit.jupiter.api.Test
    void moveForward() {
        robot.moveForward();
        assertEquals(1, robot.getX(), "Robot did not move forward");
    }

    @org.junit.jupiter.api.Test
    void convertDirectionToRadiant() {
        double radiant = robot.convertDirectionToRadiant('S');
        assertEquals(-Math.PI / 2, radiant, "Conversion from Direction to radiants failed");
    }

    @org.junit.jupiter.api.Test
    void convertAngleToDirection() {
        robot.turnRight();
        assertEquals('E', robot.convertAngleToDirection(), "Conversion from radiant to direction failed ");
    }
}