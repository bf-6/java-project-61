package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Calc {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // DESCRIPTION для условия задачи и массив OPERATORS для хранения арифметических операций
    private static final int MIN = 1;
    private static final int MAX = 11;
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final String DESCRIPTION =
            "What is the result of the expression?";

    public static void calculator() {

        // Создаем двумерный массив для записи в него вопросов и ответов
        String[][] questionAndAnswer = new String[Engine.ROUNDS_COUNT][2];

        // Начинаем цикл для заполнения массива questionAndAnswer данными (вопросы и ответы)
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            // Генерируем два случайных числа
            var randomNumber1 = RandomUtils.nextInt(MIN, MAX);
            var randomNumber2 = RandomUtils.nextInt(MIN, MAX);

            // В переменную arithmetic записываем случайную оперцию
            // Использовал Math.random, что бы не добавлять новые константы и не было магических чисел в коде
            int numberOperations = (int) Math.floor(Math.random() * OPERATORS.length);
            char arithmetic = OPERATORS[numberOperations];

            // Записываем результат арефметической операции в переменную resultOperation
            int resultOperation = 0;
            switch (arithmetic) {
                case '+':
                    resultOperation = randomNumber1 + randomNumber2;
                    break;
                case '-':
                    resultOperation = randomNumber1 - randomNumber2;
                    break;
                case '*':
                    resultOperation = randomNumber1 * randomNumber2;
                    break;
                default:
                    throw new RuntimeException("Unknown operation: " + arithmetic);
            }

            // Записываем в массив вопрос для пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            questionAndAnswer[i][Engine.QUESTION_INDEX] = "" + randomNumber1 + " " + arithmetic + " " + randomNumber2;
            // Записываем в массив правильный ответ
            questionAndAnswer[i][Engine.ANSWER_INDEX] = "" + resultOperation;

        }

        // Передаем данные для вопроса и правильный ответ
        Engine.engine(DESCRIPTION, questionAndAnswer);

    }
}
