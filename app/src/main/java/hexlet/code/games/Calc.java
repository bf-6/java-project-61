package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Calc {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // ITERATION для количества вопросов пользователю (по умолчанию 3)
    // DESCRIPTION для условия задачи и массив OPERATORS для хранения арифметических операций
    private static final int MIN = 1;
    private static final int MAX = 11;
    private static final int ITERATION = 3;
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final String DESCRIPTION =
            "What is the result of the expression?";

    public static void calculator() {
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

        // Начинаем цикл для демонстрации пользователю математического выражения, приема ответа пользователя
        // и проверки ответа пользователя
        for (int i = 0; i < ITERATION; i++) {

            // Генерируем два случайных числа
            var randomNumber1 = RandomUtils.nextInt(MIN, MAX);
            var randomNumber2 = RandomUtils.nextInt(MIN, MAX);

            // В переменную arithmetic записываем случайную оперцию
            // Использовал Math.random, что бы не добавлять новые константы и не было магических чисел в коде
            int numberOperations = (int) Math.floor(Math.random() * OPERATORS.length);
            char arithmetic = OPERATORS[numberOperations];

            // Записываем результат арефметической операции в переменную resultOperation
            int resultOperation = 0;
            if (arithmetic == '+') {
                resultOperation = randomNumber1 + randomNumber2;
            } else if (arithmetic == '-') {
                resultOperation = randomNumber1 - randomNumber2;
            } else {
                resultOperation = randomNumber1 * randomNumber2;
            }

            // Передаем данные для вопроса пользователя, правильный ответ и имя пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            var result = Engine.engine("" + randomNumber1 + " " + arithmetic + " " + randomNumber2,
                    "" + resultOperation, userName);

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
