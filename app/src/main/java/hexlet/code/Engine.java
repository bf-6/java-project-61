package hexlet.code;

import hexlet.code.games.*;

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
            case "6":
                Prime.prime();
                break;
            default:
                break;
        }

    }
}
