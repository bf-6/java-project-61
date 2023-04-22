package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner selectionMenu = new Scanner(System.in);

        // Выводим для пользователя меню выбора игр
        System.out.println("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit");

        // Принимаем выбор пользователя и записываем его в переменную userChoice
        String userChoice = selectionMenu.next();
        System.out.println("Your choice: " + userChoice + "\n");

        // Запускаем игру в зависимости от выбора пользователя
        switch (userChoice) {
            case "1":
                Cli.nameForOurUser();
                break;
            case "2":
                Even.even();
                break;
            case "3":
                Calc.calculator();
                break;
            case "4":
                GCD.gcd();
                break;
            case "5":
                Progression.progression();
                break;
            case "6":
                Prime.prime();
                break;
            default:
                break;
        }

        selectionMenu.close();

    }
}
