package Test;

import application.Controller;
import application.Robot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller c;
    Robot r;

    @BeforeEach
    void setUp() {
        r = new Robot(1, 2, 'N');
        c = new Controller(5, 5, "RFRFFRFRF", r);
    }

    @AfterEach
    void tearDown() {
        c = null;
    }

    @Test
    void moveToDestination() {
        c.moveToDestination();
        assertEquals(1, r.getX(), "X coordinate is wrong");
        assertEquals(3, r.getY(), "Y coordinate is wrong");
        assertEquals('N', r.convertAngleToDirection(), "The direction ins not correct, it should be N");

    }
}