
import java.util.Scanner;

public class CheckOut {
    public static double getRangedDouble(Scanner pipe, String prompt, double min, double max) {
        double num = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt + " [" + min + "-" + max + "]: ");
            if (pipe.hasNextDouble()) {
                num = pipe.nextDouble();
                if (num >= min && num <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number in the range [" + min + "-" + max + "].");
                }
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next();
            }
        }
        return num;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.next();
            if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("N")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
        return response.equalsIgnoreCase("Y");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0.0;
        boolean moreItems = true;

        while (moreItems) {
            double price = getRangedDouble(scanner, "Enter the price of your item", 0.50, 10.00);
            totalCost += price;
            moreItems = getYNConfirm(scanner, "Do you have more items?");
        }

        System.out.printf("Total cost of your items: $%.2f%n", totalCost);
    }}