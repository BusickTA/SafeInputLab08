import java.util.Scanner;


public class Reggie {
    public static String getRegExString(Scanner pipe, String prompt, String pattern) {
        String response = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(pattern)) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please match the pattern: " + pattern);
            }
        }
        return response;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ssn = getRegExString(scanner, "Enter your SSN (format: xxx-xx-xxxx)", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("SSN: " + ssn);

        String mNumber = getRegExString(scanner, "Enter your UC Student M number (format: Mxxxxx)", "^(M|m)\\d{5}$");
        System.out.println("UC Student M number: " + mNumber);

        String menuChoice = getRegExString(scanner, "Enter your menu choice (O/S/V/Q)", "^[OoSsVvQq]$");
        System.out.println("Menu choice: " + menuChoice);
    }
}

