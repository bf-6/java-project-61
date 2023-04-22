package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class GCD {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // ITERATION для количества вопросов пользователю (по умолчанию 3)
    // DESCRIPTION для условия задачи
    private static final int MIN = 1;
    private static final int MAX = 211;
    private static final int ITERATION = 3;
    private static final String DESCRIPTION =
            "Find the greatest common divisor of given numbers.";

    // В этом методе находим НОД посредством последовательного деления
    public static int nod(int number1, int number2) {

        while (number2 != 0) {

            int tmp = number1 % number2;
            number1 = number2;
            number2 = tmp;

        }

        return number1;

    }

    public static void gcd() {
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

        // Начинаем цикл для демонстрации пользователю двух чисел, приема ответа пользователя
        // и проверки ответа пользователя
        for (int i = 0; i < ITERATION; i++) {

            // Генерируем два случайных числа
            var randomNumber1 = RandomUtils.nextInt(MIN, MAX);
            var randomNumber2 = RandomUtils.nextInt(MIN, MAX);

            // Находим НОД посредством последовательного деления и записываем результат в переменную myGcd
            int myGcd = nod(randomNumber1, randomNumber2);

            // Передаем данные для вопроса пользователя, правильный ответ и имя пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            var result = Engine.engine("" + randomNumber1 + " " + randomNumber2, "" + myGcd, userName);

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
