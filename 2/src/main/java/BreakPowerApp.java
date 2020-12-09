public class BreakPowerApp {
    public static void main(String[] args) {
        int[] arguments =  checkArguments(args);

        String fileName = args[0];
        FuzzyLogic fuzzyLogic = new FuzzyLogic(fileName, arguments);
    }

    private static int[] checkArguments(String[] args) {
        if (args.length < 4) {
            System.out.println("Not enough arguments");
            System.exit(0);
        }

        int[] arguments = new int[3];

        if (args[1].matches("\\b\\d+\\b")) {
            int carSpeed = Integer.parseInt(args[1]);
            if (carSpeed >= 0 && carSpeed <= 140) {
                arguments[0] = carSpeed;
            } else {
                System.out.println("Car speed needs to be in between 0 - 140");
                System.exit(0);
            }
        } else {
            System.out.println("Car speed needs to be in between 0 - 140");
            System.exit(0);
        }

        if (args[2].matches("\\b\\d+\\b")) {
            int carAheadSpeed = Integer.parseInt(args[2]);
            if (carAheadSpeed >= 0 && carAheadSpeed <= 140) {
                arguments[1] = carAheadSpeed;
            } else {
                System.out.println("Cars ahead speed needs to be in between 0 - 140");
                System.exit(0);
            }
        } else {
            System.out.println("Cars ahead speed needs to be in between 0 - 140");
            System.exit(0);
        }

        if (args[3].matches("\\b\\d+\\b")) {
            int distance = Integer.parseInt(args[3]);
            if (distance >= 0 && distance <= 100) {
                arguments[2] = distance;
            } else {
                System.out.println("Distance when starting breaking have to be in between 0 - 100");
                System.exit(0);
            }
        } else {
            System.out.println("Distance when starting breaking have to be in between 0 - 100");
            System.exit(0);
        }

        if(arguments[0] <= arguments[1]){
            System.out.println("No needs for breaking");
            System.exit(0);
        }
        return arguments;
    }
}
