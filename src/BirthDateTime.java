import java.util.Scanner;

public class BirthDateTime {
    public static int getRangedInt(Scanner pipe, String prompt, int min, int max) {
        int num = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt + " [" + min + "-" + max + "]: ");
            if (pipe.hasNextInt()) {
                num = pipe.nextInt();
                if (num >= min && num <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number in the range [" + min + "-" + max + "].");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = getRangedInt(scanner, "Enter the year of birth", 1950, 2015);
        int month = getRangedInt(scanner, "Enter the month of birth", 1, 12);
        int day = 0;

        switch (month) {
            case 2:
                day = getRangedInt(scanner, "Enter the day of birth", 1, 29);
                break;
            case 4: case 6: case 9: case 11:
                day = getRangedInt(scanner, "Enter the day of birth", 1, 30);
                break;
            default:
                day = getRangedInt(scanner, "Enter the day of birth", 1, 31);
                break;
        }

        int hour = getRangedInt(scanner, "Enter the hour of birth", 1, 24);
        int minute = getRangedInt(scanner, "Enter the minute of birth", 1, 59);

        System.out.println("Date and Time of Birth: " + year + "-" + month + "-" + day + " " + hour + ":" + minute );
}
    }