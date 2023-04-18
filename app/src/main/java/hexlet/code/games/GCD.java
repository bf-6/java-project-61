package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

public class GCD {
    public static void gcd() {
        // Приветствуем пользователя
        String userName = Cli.nameForOurUser();

        // Выводим на экран условие игры
        System.out.println("Find the greatest common divisor of given numbers.");

        Scanner userResponseInput = new Scanner(System.in);

        // Начинаем цикл для демонстрации пользователю двух чисел, приема ответа пользователя
        // и проверки ответа пользователя
        int i;
        for (i = 0; i < 3; i++) {

            // Генерируем два случайных числа
            var randomNumber1 = RandomUtils.nextInt(1, 211);
            var randomNumber2 = RandomUtils.nextInt(1, 211);

            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);

            // Находим НОД посредством последовательного деления и записываем результат в переменную NOD
            while (randomNumber2 !=0) {

                int tmp = randomNumber1 % randomNumber2;
                randomNumber1 = randomNumber2;
                randomNumber2 = tmp;

            }

            int NOD = randomNumber1;

            // Объявляем переменную "userResponse" для записи ответа пользователя
            // и принмимаем ответ пользователя с клавиатуры
            System.out.print("Your choice: ");
            int userResponse = Integer.parseInt(userResponseInput.next());

            // Проверяем верен ли ответ пользователя
            if (userResponse == NOD) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userResponse + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + NOD + "'\n"
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
