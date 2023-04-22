package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class Prime {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // ITERATION для количества вопросов пользователю (по умолчанию 3)
    // DESCRIPTION для условия задачи
    private static final int MIN = 2;
    private static final int MAX = 100;
    private static final int ITERATION = 3;
    private static final String DESCRIPTION =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    // Метод для проверки является ли число простым
    public static boolean itPrimeNumber(Integer number) {

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        // Выводим на экран условие игры
        System.out.println(DESCRIPTION);

        //Объявляем переменную result2 для записи в неё верность ответа пользователя
        boolean result2 = false;

        // Начинаем цикл для демонстрации пользователю числа, приема ответа пользователя
        // и проверки ответа пользователя
        for (int i = 0; i < ITERATION; i++) {

            // Генерируем случайное число, начинаем от 2
            int randomNumber = RandomUtils.nextInt(MIN, MAX); //(int) (Math.random() * 100);

            // Объявляем переменную primeNumber для записии в неё результат проверки простое число или нет
            String primeNumber = "";
            // Проверяем является ли сгенерированное число простым, если оно простое, то переменной
            // "primeNumber" присваиваем значение "yes", если нет - "no"
            primeNumber = itPrimeNumber(randomNumber) ? "yes" : "no";

            // Передаем данные для вопроса пользователя, правильный ответ и имя пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            var result = Engine.engine("" + randomNumber, primeNumber, userName);

            // Переменной result2 присвамиваем верность ответа пользователя
            result2 = result;

            // Если пользователя ответил неправильно, то прекращаем выполнение цикла
            if (!result) {
                break;
            }

        }

        // Если пользователь ответил правильно на все вопросы, то выводим сообщение с поздравлением
        if (result2) {
            System.out.println("Congratulations, " + userName + "!");
        }

        scanner.close();

    }
}
