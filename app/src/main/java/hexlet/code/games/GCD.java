package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class GCD {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // DESCRIPTION для условия задачи
    private static final int MIN = 1;
    private static final int MAX = 211;
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

        // Создаем двумерный массив для записи в него вопросов и ответов
        String[][] questionAndAnswer = new String[Engine.ROUNDS_COUNT][2];

        // Начинаем цикл для демонстрации пользователю двух чисел, приема ответа пользователя
        // и проверки ответа пользователя
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            // Генерируем два случайных числа
            var randomNumber1 = RandomUtils.nextInt(MIN, MAX);
            var randomNumber2 = RandomUtils.nextInt(MIN, MAX);

            // Записываем в массив вопрос для пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            questionAndAnswer[i][Engine.QUESTION_INDEX] = "" + randomNumber1 + " " + randomNumber2;
            // Записываем в массив правильный ответ (НОД)
            questionAndAnswer[i][Engine.ANSWER_INDEX] = "" + nod(randomNumber1, randomNumber2);

        }

        // Передаем данные для вопроса и правильный ответ
        Engine.engine(DESCRIPTION, questionAndAnswer);

    }
}
