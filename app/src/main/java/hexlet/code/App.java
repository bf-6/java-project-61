package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner selectionMenu = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit");

        String userChoice = selectionMenu.next();
        System.out.println("Your choice: " + userChoice + "\n");

        switch (userChoice) {
            case "1":
                //Greetings.greetingsUser();
                Cli.nameForOurUser();
                break;
            case "2":
                // String userName = Cli.nameForOurUser();
                Even.parityCheckNumber(/*userName*/);
                break;
            default:
                break;
        }

        selectionMenu.close();

    }
}
