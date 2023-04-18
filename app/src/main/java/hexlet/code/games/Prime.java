package hexlet.code.games;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class Prime {
    // Метод для проверки является ли число простым
    public static boolean itPrimeNumber(Integer number) { // Тут я не понял почему должно быть Integer, а не int
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void prime() {
        // Приветствуем пользователя
        String userName = Cli.nameForOurUser();

        // Выводим на экран условие игры
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Scanner userResponseInput = new Scanner(System.in);

        // Начинаем цикл для демонстрации пользователю числа, приема ответа пользователя
        // и проверки ответа пользователя
        int i;
        for (i = 0; i < 3; i++) {

            // Генерируем случайное число, начинаем от 2
            int randomNumber = RandomUtils.nextInt(2, 100); //(int) (Math.random() * 100);

            String primeNumber = "";
            // Проверяем является ли сгенерированное число простым, если оно простое, то переменной
            // "primeNumber" присваиваем значение "yes", если нет - "no"
            if (itPrimeNumber(randomNumber)) {
                primeNumber = "yes";
            } else {
                primeNumber = "no";
            }

            System.out.println("Question: " + randomNumber);

            // Объявляем переменную "userResponse" для записи ответа пользователя
            // и принмимаем ответ пользователя с клавиатуры
            System.out.print("Your choice: ");
            String userResponse = userResponseInput.next();

            // Проверяем верен ли ответ пользователя
            if (userResponse.equalsIgnoreCase(primeNumber)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userResponse + "'"
                    + " is wrong answer ;(. Correct answer was "
                    + "'" + primeNumber + "'\n"
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
