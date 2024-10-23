import java.util.Scanner;

public class DevTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Declare and initialize Scanner
        int value = getRangedInt(in, "Enter an integer value", 1, 10);
        System.out.println("You entered: " + value);
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
}