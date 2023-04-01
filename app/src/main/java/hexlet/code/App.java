package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit");

        String userChoice = scanner.next();
        System.out.println("Your choice: " + userChoice);

        switch (userChoice) {
            case "1":
                Greetings.greetingsUser();
                break;
            case "2":
                break;
            default:
                break;
        }

        //scanner.close();

    }
}
