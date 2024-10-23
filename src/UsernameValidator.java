import java.util.Scanner;

public class UsernameValidator {
    public static String getValidUsername(Scanner pipe, String prompt) {
        String username = "";
        while (username.isEmpty()) {
            System.out.print(prompt + ": ");
            username = pipe.nextLine();
        }
        return username;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = getValidUsername(scanner, "Enter your username");
        System.out.println("Your username is: " + username);
    }
}
