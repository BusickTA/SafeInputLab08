import java.util.Scanner;

public class FavNumbers {
    public static int getInt(Scanner pipe, String prompt) {
        int number = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();
            }
        }
        return number;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double number = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                number = pipe.nextDouble();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next();
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int favoriteInt = getInt(scanner, "Enter your favorite integer");
        double favoriteDouble = getDouble(scanner, "Enter your favorite double");

        System.out.println("Your favorite integer is: " + favoriteInt);
        System.out.println("Your favorite double is: " + favoriteDouble);
    }
}