package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String nameForOurUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        String userNameForMethod = userName;

        return userNameForMethod;
    }
}
