import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner input = new Scanner(System.in);
        DataContainer<Bike> dc = new DataContainer();
        while (run) {
            run = isRun(run, input, dc);
        }
    }

    /**
     * The isRun Method handles the execution of the command's
     * add <Type>: adds a new Object to the DataContainer
     * size: returns the size of the DataContainer
     * rm <id>: removes the element from the DataContainer with the entered id
     * printAll: prints all Objects of the DataContainer
     * print <id>: prints the element with the entered id
     * set <id>: update the Object on the entered id
     * quit: quits the program
     * @param run
     * @param input
     * @param dc
     * @return run
     */
    private static boolean isRun(boolean run, Scanner input, DataContainer dc) {
            System.out.print("Command: ");
            String command = input.next();
            String sId;
            int id;
            boolean whileLoop = true;
            switch (command) {
                case "add":
                    Bike b = createBike(input);
                    if(b == null){
                        break;
                    }
                    dc.add(b);
                    break;
                case "size":
                    System.out.println(dc.size() + " element(s) are currently stored");
                    break;
                case "rm":
                    sId = input.next();
                    while (whileLoop) {
                        try {
                            id = Integer.parseInt(sId);
                            if(id <= dc.size()-1){
                                dc.deleteObject(id);
                                System.out.println("done");
                            } else {
                                System.out.println("number does nit exist, size = " + dc.size());
                            }
                            whileLoop = false;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Please enter a valid Number!");
                            System.out.print("Index: ");
                            sId = input.next();
                            whileLoop = true;
                        }
                    }
                    break;
                case "printAll":
                    if(dc.size() < 1) {
                        System.out.println("No entries exist!");
                        break;
                    }
                    dc.printAll();
                    break;

                case "print":
                    sId = input.next();
                    while (whileLoop) {
                        try {
                            id = Integer.parseInt(sId);
                            if (id <= dc.size() - 1) {
                                System.out.println(dc.getObject(id));
                            } else {
                                System.out.println("number does nit exist, size = " + dc.size());
                            }
                            whileLoop = false;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Please enter a valid Number!");
                            System.out.print("Index: ");
                            sId = input.next();
                            whileLoop = true;
                        }
                    }
                    break;
                case "set":
                    sId = input.next();
                    while(whileLoop){
                        try {
                            id = Integer.parseInt(sId);
                            if(id <= dc.size()-1){
                                System.out.print("Type: ");
                                Bike newBike = createBike(input);
                                dc.setObject(id, newBike);
                            } else {
                                System.out.println("number does nit exist, size = " + dc.size());
                            }
                            whileLoop = false;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Please enter a valid Number!");
                            System.out.print("Index: ");
                            sId = input.next();
                            whileLoop = true;
                        }
                    }
                    break;
                case "quit":
                    run = false;
                    break;
                case "kmh":
                    id = input.nextInt();
                    if (id <= dc.size()-1){
                        Bike bTwo = (Bike) dc.getObject(id);
                        System.out.println(bTwo.getKmh() + "km/h");
                    } else {
                        System.out.println("number does nit exist, size = " + dc.size());
                    }
                    break;
                default:
                    System.out.println("Please enter a valid command (e.g. add <Type>, size, rm <Index>, printAll, print <Index>, set <Index>, quit)");
            }
            return run;
    }

    /**
     * The createBike method creates the different types of Bikes
     * @param input
     * @return
     */
    private static Bike createBike(Scanner input) {
        String type = input.next();
        String[] types = {"Bike", "CityBike", "MountainBike"};
        if (!Arrays.asList(types).contains(type)){
            System.out.println("Please enter a valid Type (Bike, CityBike or MountainBike)");
            return null;
        }
        boolean whileLoop = true;
        String light;
        String damping;
        System.out.print("Rider: ");
        String rider = input.next();
        System.out.print("Color: ");
        String color = input.next();
        System.out.print("Direction: ");
        String direction = input.next();
        int directionInt = 0;
        while (whileLoop) {
            try {
                directionInt = Integer.parseInt(direction);
                if(directionInt > 45 || directionInt < -45){
                    System.out.println("Steering angle is to big! Steering is only possible between +45 and -45 Degree");
                    throw new RuntimeException();
                }
                whileLoop = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid Number!");
                System.out.print("Direction: ");
                direction = input.next();
                whileLoop = true;
            } catch (RuntimeException re) {
                System.out.print("Direction: ");
                direction = input.next();
                whileLoop = true;
            }
        }
        System.out.print("Speed: Meter: ");
        String m = input.next();
        whileLoop = true;
        double mInt = 0;
        while (whileLoop) {
            try {
                mInt = Double.parseDouble(m);
                whileLoop = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valide Number!");
                System.out.print("Speed: Meter: ");
                m = input.next();
                whileLoop = true;
            }
        }
        System.out.print(" Seconds: ");
        String sec = input.next();
        whileLoop = true;
        double secInt = 0;
        while(whileLoop) {
            try {
                secInt = Double.parseDouble(sec);
                whileLoop = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valide Number!");
                System.out.print(" Seconds: ");
                sec = input.next();
                whileLoop = true;
            }
        }
        whileLoop = true;
        switch (type){
            case "Bike":
                Bike b = new Bike(rider, color);
                b.steer(directionInt);
                b.accelerate(mInt,secInt);
                return b;
            case "CityBike":
                // add City Bike;
                System.out.print("Light: ");
                light = input.next();
                while (whileLoop){
                    try {
                        String[] values = {"on", "true", "off", "false"};
                        if(!Arrays.asList(values).contains(light)) {
                            System.out.println("Please enter a valid value (on (true) or off (false))");
                            throw new RuntimeException();
                        }
                        Bike cb = new CityBike(rider, color, light);
                        cb.steer(directionInt);
                        cb.accelerate(mInt,secInt);
                        return cb;
                    } catch (RuntimeException re) {
                        System.out.print("Light: ");
                        light = input.next();
                        whileLoop = true;
                    }
                }
            case "MountainBike":
                // add City Bike;
                System.out.print("Damping: ");
                damping = input.next();
                while (whileLoop){
                    try {
                        String[] values = {"on", "true", "off", "false"};
                        if(!Arrays.asList(values).contains(damping)) {
                            System.out.println("Please enter a valid value (on (true) or off (false))");
                            throw new RuntimeException();
                        }
                        Bike mb = new MountainBike(rider, color, damping);
                        mb.steer(directionInt);
                        mb.accelerate(mInt,secInt);
                        return  mb;
                    } catch (RuntimeException re) {
                        System.out.print("Damping: ");
                        damping = input.next();
                        whileLoop = true;
                    }
                }
            default:
                System.out.println("Please enter a valid Type (Bike, CityBike or MountainBike)");
                return null;
        }
    }
}