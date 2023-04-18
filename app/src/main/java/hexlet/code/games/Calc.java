package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

public class Calc {
    public static void calculator() {
        // Приветствуем пользователя
        String userName = Cli.nameForOurUser();

        // Выводим на экран условие игры
        System.out.println("What is the result of the expression?");

        Scanner userResponseInput = new Scanner(System.in);

        // Начинаем цикл для демонстрации пользователю математического выражения, приема ответа пользователя
        // и проверки ответа пользователя
        int i;
        for (i = 0; i < 3; i++) {

            // Генерируем два случайных числа
            var randomNumber1 = RandomUtils.nextInt(1, 11);
            var randomNumber2 = RandomUtils.nextInt(1, 11);

            // Присваиваем переменной operations арифметические операции, которые должен будет вычислить пользователь
            String operations = "+-*";

            // В переменную arithmetic записываем случайную оперцию
            int numberOperations = RandomUtils.nextInt(0, 3);
            char arithmetic = operations.charAt(numberOperations);

            System.out.println("Question: " + randomNumber1 + " " + arithmetic + " " + randomNumber2);

            // Записываем результат арефметической операции в переменную resultOperation
            int resultOperation = 0;
            if (arithmetic == '+') {
                resultOperation = randomNumber1 + randomNumber2;
            } else if (arithmetic == '-') {
                resultOperation = randomNumber1 - randomNumber2;
            } else {
                resultOperation = randomNumber1 * randomNumber2;
            }

            // Объявляем переменную "userResponse" для записи ответа пользователя
            // и принмимаем ответ пользователя с клавиатуры
            System.out.print("Your choice: ");
            int userResponse = Integer.parseInt(userResponseInput.next());

            // Проверяем верен ли ответ пользователя
            if (userResponse == resultOperation) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userResponse + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + resultOperation + "'\n"
                        + "Let's try again, " + userName + "!");
                userResponseInput.close();
                break;
            }
        }
        if (i == 3) {
            System.out.println("Congratulations, " + userName + "!");
        }
        userResponseInput.close();

    }
}
