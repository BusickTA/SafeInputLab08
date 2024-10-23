public class PrettyHeader {
    public static void prettyHeader(String msg) {
        final int WIDTH = 60;
        int msgLength = msg.length();
        int padding = (WIDTH - 6 - msgLength) / 2;

        // Print top border
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();


        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }

        if ((msgLength + 6) % 2 != 0) {
            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();


        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        prettyHeader("Message Centered Here");
    }
}