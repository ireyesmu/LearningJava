import java.util.*;

public class FractionCalculator {
    static Scanner input = new Scanner(System.in);
    static boolean quit = false;

    public static String getOperation(Scanner input){
        String op = null;
        System.out.println("------------------------------------------------------------------------------");
        System.out.print("Please enter an operation (+, -, *, /, = or Q to quit): ");
        boolean succOp = false;
        while (!succOp) {
            op = input.nextLine().toLowerCase();
            succOp = true;
            switch (op) {
                case "+":
                    break;
                case "-":
                    break;
                case "*":
                    break;
                case "/":
                    break;
                case "=":
                    break;
                case "q":
                    quit = true;
                    break;
                default:
                    succOp = false;
                    System.out.print("Invalid input (+, -, *, /, = or Q to quit): ");
            }
        }
        return op;
    }

    public static Fraction getFraction(Scanner input){ //return Fraction, void para prueba
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String fraction = input.nextLine();
        while (!validFraction(fraction)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            fraction = input.nextLine();
        }
        if (fraction.indexOf('/') != -1) {
            int indexSlash = fraction.indexOf('/');
            int numerator = Integer.parseInt(fraction.substring(0,indexSlash));
            int denominator = Integer.parseInt(fraction.substring(indexSlash+1));
            //Fraction result = new Fraction(numerator, denominator);
            //return result;
            return new Fraction(numerator, denominator);
        } else {
            int numerator = Integer.parseInt(fraction);
            //Fraction result = new Fraction(numerator);
            //return result;
            return new Fraction(numerator);
        }
    }

    public static boolean validFraction(String input){
        //Check if it is an empty string
        if (input.isEmpty()) return false;

        //Check if there is a - or none in the beginning of the fraction
        //Also check if there is a combination of (digits) + optional / + (digits)
        //int indexSlash = input.indexOf('/');
        return input.matches("^-?\\d+(/[-]?[1-9]+\\d*)?$");
    }

    public static void main(String[] args){
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        while (!quit){
            String operation = getOperation(input);
            if (!quit){
                Fraction fraction1 = getFraction(input);
                Fraction fraction2 = getFraction(input);
                Fraction result = new Fraction();
                boolean answer = false;
                switch (operation) {
                    case "+":
                        result = fraction1.add(fraction2);
                        break;
                    case "-":
                        result = fraction1.subtract(fraction2);
                        break;
                    case "*":
                        result = fraction1.multiply(fraction2);
                        break;
                    case "/":
                        result = fraction1.divide(fraction2);
                        break;
                    case "=":
                        answer = fraction1.equals(fraction2);
                        break;
                }
                if (operation.equals("=")) {
                    System.out.println(fraction1.toString() + " " + operation + " " + fraction2.toString() + " is " + answer);
                } else {
                    System.out.println(fraction1.toString() + " " + operation + " " + fraction2.toString() + " = " + result.toString());
                }
            }
        }
    }
}
