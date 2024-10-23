import java.util.Scanner;
import java.util.regex.*;

public class SafeInput {

    /**
     * @param pipe   a Scanner opened to read System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        String trash = "";
        boolean badInput = true;
        while (badInput) {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                int input = pipe.nextInt();
                pipe.nextLine(); // Clear buffer
                badInput = false;
                return input;
            } else {
                trash = pipe.nextLine();
                System.out.println("Input needs to be an integer, you entered " + trash);
                System.out.println("Reenter with correct input.");
            }
        }
        return 0;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        String trash = "";
        boolean badInput = true;
        while (badInput) {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) {
                double input = pipe.nextDouble();
                pipe.nextLine(); // Clear buffer
                badInput = false;
                return input;
            } else {
                trash = pipe.nextLine();
                System.out.println("Input needs to be a double, you entered " + trash);
                System.out.println("Reenter with correct input.");
            }
        }
        return 0;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        String trash = "";
        int userInput;
        boolean badInput = true;
        while (badInput) {
            System.out.print(prompt + " [" + low + " - " + high + "] ");
            if (pipe.hasNextInt()) {
                userInput = pipe.nextInt();
                pipe.nextLine(); // Clear buffer
                if (userInput >= low && userInput <= high) {
                    badInput = false;
                    return userInput;
                } else {
                    System.out.println("Input out of range, please enter an integer between " + low + " and " + high + ".");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Expected an integer in the range [" + low + " - " + high + "], but you entered " + trash);
                System.out.println("Reenter with correct input.");
            }
        }
        return 0;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        String trash = "";
        double userInput;
        boolean badInput = true;
        while (badInput) {
            System.out.print(prompt + " [" + low + " - " + high + "] ");
            if (pipe.hasNextDouble()) {
                userInput = pipe.nextDouble();
                pipe.nextLine(); // Clear buffer
                if (userInput >= low && userInput <= high) {
                    badInput = false;
                    return userInput;
                } else {
                    System.out.println("Input out of range, please enter a double between " + low + " and " + high + ".");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Expected a double in the range [" + low + " - " + high + "], but you entered " + trash);
                System.out.println("Reenter with correct input.");
            }
        }
        return 0;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String userInput;
        boolean badInput = true;
        while (badInput) {
            System.out.print(prompt + " [Y/N]: ");
            userInput = pipe.next();
            pipe.nextLine(); // Clear buffer
            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
                badInput = false;
                return true;
            } else if (userInput.equalsIgnoreCase("n") || userInput.equalsIgnoreCase("no")) {
                badInput = false;
                return false;
            } else {
                System.out.println("Input needs to be 'Yes' or 'No', but you entered '" + userInput + "'.");
            }
        }
        return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String userInput;
        boolean badInput = true;
        while (badInput) {
            System.out.print(prompt + ": ");
            userInput = pipe.nextLine();
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(userInput);
            boolean matchFound = matcher.find();
            if (matchFound) {
                badInput = false;
                return userInput;
            } else {
                System.out.println("Invalid input. Please match the pattern: " + regEx);
            }
        }
        return "error";
    }
    }






