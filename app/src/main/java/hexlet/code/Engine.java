package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

public class Engine {
    public static void ourGames(String userChoice) {

        switch (userChoice) {
            case "1":
                Cli.nameForOurUser();
                break;
            case "2":
                Even.parityCheckNumber();
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
            default:
                break;
        }

    }
}
