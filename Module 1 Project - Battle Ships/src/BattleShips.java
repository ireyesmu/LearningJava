import java.util.*;

public class BattleShips {
    static Scanner input = new Scanner(System.in);
    static int userShips = 5;
    static int cpuShips = 5;

    public static void printMap(String[][] map) {
        System.out.println("    0 1 2 3 4 5 6 7 8 9    ");
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null){ //case null
                    System.out.print("  ");
                } else {
                    switch (map[i][j]) {
                        case "1": //User's ships
                            System.out.print("@ ");
                            break;
                        case "2": //CPU's ships
                            System.out.print("  ");
                            break;
                        case "3": //User's sunked
                            System.out.print("x ");
                            break;
                        case "4": //CPU's sunked
                            System.out.print("! ");
                            break;
                        case "user": //User missed
                            System.out.print("- ");
                            break;
                        case "cpu": //CPU missed
                            System.out.print("  ");
                            break;
                        case "both": //Both missed
                            System.out.print("- ");
                            break;
                        default:
                            System.out.print("  ");
                    }
                }
            }
            System.out.print("| " + i);
            System.out.println();
        }
        System.out.println("    0 1 2 3 4 5 6 7 8 9    ");
        System.out.println();
    }

    public static void deployShips(String[][] map, String user) {
        int totalShips = 5;
        String key = "";
        switch (user) {
            case "user":
                System.out.println("Deploy your ships:");
                totalShips = userShips;
                key = "1";
                break;
            case "cpu":
                System.out.println("Computer is deploying ships");
                totalShips = cpuShips;
                key = "2";
                break;
        }
        for (int i = 1; i <= totalShips; i++) {
            boolean succ = false;
            int x = -1;
            int y = -1;
            while (!succ) {
                while ((x > 9) || (x < 0)) {
                    if (user.equals("user")) {
                        System.out.print("Enter X coordinate for your ship #" + i + ": ");
                        x = input.nextInt();
                    } else if (user.equals("cpu")) {
                        x = (int)(9*Math.random());
                    }
                }
                while ((y > 9) || (y < 0)) {
                    if (user.equals("user")) {
                        System.out.print("Enter Y coordinate for your ship #" + i + ": ");
                        y = input.nextInt();
                    } else if (user.equals("cpu")) {
                        y = (int)(9*Math.random());
                    }
                }
                if (map[x][y] == null) {
                    map[x][y] = key;
                    succ = true;
                    if (user.equals("cpu")) {
                        System.out.println("Ship #" + i + " deployed.");
                    }
                } else {
                    if (user.equals("user")) {
                        System.out.println("That position already has a ship. Please select another.");
                    }
                    x = -1;
                    y = -1;
                }
            }
            if (user.equals("user")) {
                System.out.println();
                printMap(map);
            }
        }
    }

    public static void battle(String[][] map) {
        int turn = 1;
        boolean endGame = false;

        while (!endGame) {
            boolean succ = false;
            int x = -1;
            int y = -1;
            if (turn % 2 == 1) {
                //User's turn
                System.out.println("YOUR TURN");
                while (!succ) {
                    while ((x > 9) || (x < 0)) {
                        System.out.print("Enter X coordinate: ");
                        x = input.nextInt();
                    }
                    while ((y > 9) || (y < 0)) {
                        System.out.print("Enter Y coordinate: ");
                        y = input.nextInt();
                    }
                    //Check results
                    if (map[x][y] == null) { //case null
                        System.out.println("You missed");
                        map[x][y] = "user";
                        succ = true;
                    } else {
                        switch (map[x][y]) {
                            case "1":
                                System.out.println("Oh no, you sunk your own ship :(");
                                map[x][y] = "3";
                                userShips--;
                                succ = true;
                                break;
                            case "2":
                                System.out.println("Boom! You sunk a ship!");
                                map[x][y] = "4";
                                cpuShips--;
                                succ = true;
                                break;
                            case "cpu":
                                System.out.println("You missed");
                                map[x][y] = "both";
                                succ = true;
                                break;
                            default: //case 3, 4, user, both
                                System.out.println("Invalid option. Guess again.");
                                x = -1;
                                y = -1;
                        }
                    }
                }
            } else {
                //CPU's turn
                System.out.println("COMPUTER'S TURN");
                while (!succ) {
                    x = (int)(9*Math.random());
                    y = (int)(9*Math.random());
                    if (map[x][y] == null) { //case null
                        System.out.println("Computer missed");
                        map[x][y] = "cpu";
                        succ = true;
                    } else {
                        switch (map[x][y]) {
                            case "1":
                                System.out.println("The Computer sunk one of your ships!");
                                map[x][y] = "3";
                                userShips--;
                                succ = true;
                                break;
                            case "2":
                                System.out.println("The Computer sunk one of its own ships");
                                map[x][y] = "4";
                                cpuShips--;
                                succ = true;
                                break;
                            case "user":
                                System.out.println("Computer missed");
                                map[x][y] = "both";
                                succ = true;
                                break;
                            default: //case 3, 4, cpu, both
                                x = -1;
                                y = -1;
                        }
                    }
                }
            }
            //Check if there is a winner
            if ((cpuShips == 0) || (userShips == 0)) {
                System.out.println();
                printMap(map);
                System.out.println("------------------------------------");
                System.out.println("Your ships: " + userShips + " | Computer ships: " + cpuShips);
                if (cpuShips == 0) {
                    System.out.println("Hooray! You win the battle");
                } else {
                    System.out.println("You lose. Game over");
                }
                endGame = true;
            } else if (turn % 2 == 0) { //If there is no winner and after cpu played
                System.out.println();
                printMap(map);
                System.out.println("Your ships: " + userShips + " | Computer ships: " + cpuShips);
                System.out.println("------------------------------------");
            }
            turn++;
        }
    }

    public static void main(String args[]) {
        String[][] oceanMap = new String[10][10];

        System.out.println("****  Welcome to Battle Ships game  ****");
        System.out.println();
        System.out.println("Righ now the sea is empty.");
        System.out.println();
        printMap(oceanMap);
        deployShips(oceanMap,"user");
        deployShips(oceanMap,"cpu");
        System.out.println();
        System.out.println();
        System.out.println("***  LET'S PLAY!  ***");
        System.out.println();
        battle(oceanMap);
    }
}
