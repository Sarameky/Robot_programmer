package application;

import java.util.Scanner;


public class App {
    public static void main(String[] arg) {

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in).useDelimiter("\\R");
        //do {

        //Validate input as two positive integers indicating the size of the room, if wrong input keep asking for the correct one
        System.out.println("Hi, lets get started and make this robot exercise a bit :D");
        System.out.println("Enter the length and depth of the room!");
        while (!scanner.hasNext("\\s*\\d+\\s\\d+\\s*")) {
            System.out.println("Invalid input! Please enter 2 integers indicating the length and depth of the room, separated by a single space.");
            scanner.nextLine();

        }
        String[] s = (scanner.nextLine()).trim().split(" ");
        //System.out.println(s[0] + ", " + s[1]);
        int roomLength = Integer.parseInt(s[0]);
        int roomDepth = Integer.parseInt(s[1]);//String.valueOf(s.charAt(2)));

        int xRobot = -1;
        int yRobot = -1;
        char direction = ' ';

        // CHeck if the x and y indicating the robot position in the rooms
        // are integers in the valid range  if not keep asking for a valid input
        System.out.println("Enter the x and y coordinate of the robot and its cardinal direction in the form: x y D");
        int i = 0;
        while (xRobot < 0 || xRobot > roomLength || yRobot < 0 || yRobot > roomDepth) {
            if (i > 0)
                System.out.println("Please enter two  valid integers for the x and y position of the robot. Accepted ranges:  0<=x<=" + roomLength + " and 0<=y<=" + roomDepth);
            while (!scanner.hasNext("\\s*\\d+\\s+\\d+\\s+(?i)[NSWE]\\s*")) {

                System.out.println("Please enter two  valid integers for the x and y position of the robot( 0<=x<=" + roomLength + " and 0<=y<=" + roomDepth + ") and N, S W or E for it's direction");
                scanner.nextLine();
            }
            String[] st = (scanner.nextLine()).trim().split(" ");
            //System.out.println(st[0] + " " + st[1] + " " + st[2]);
            xRobot = Integer.parseInt(st[0]);
            yRobot = Integer.parseInt(st[1]);
            direction = (st[2].toUpperCase()).charAt(0);
            i++;
        }


        System.out.println("Enter the commands to the robot as one string: L=left, R=right F=forward.");
        //Validate commands, should a string containing only L, F or R without spaces
        while (!scanner.hasNext("\\s*(?i)[LRF]+\\s*")) {
            System.out.println("Please enter the commands R, L or F without spaces");
            scanner.nextLine();

        }
        String commands = scanner.nextLine().trim().toUpperCase();
        //System.out.println("You entered commands " + commands);
        Robot robot = new Robot(xRobot, yRobot, direction);

        Controller controller = new Controller(roomLength, roomDepth, commands, robot);
        controller.moveToDestination();
        System.out.println("The robot positioning is: " + robot.getX() + ", " + robot.getY() + ", " + robot.convertAngleToDirection());
        //System.out.println("Please enter c to continue or q to quit");
        // }while(scanner.next()!= "q");
    }
}
