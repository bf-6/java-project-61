package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Prime {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // DESCRIPTION для условия задачи
    private static final int MIN = 2;
    private static final int MAX = 100;
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

        // Создаем двумерный массив для записи в него вопросов и ответов
        String[][] questionAndAnswer = new String[Engine.ROUNDS_COUNT][2];

        // Начинаем цикл для заполнения массива questionAndAnswer данными (вопросы и ответы)
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            // Генерируем случайное число, начинаем от 2
            int randomNumber = RandomUtils.nextInt(MIN, MAX); //(int) (Math.random() * 100);

            // Записываем в массив вопрос для пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            questionAndAnswer[i][Engine.QUESTION_INDEX] = "" + randomNumber;
            // Записываем в массив правильный ответ (Проверяем является ли сгенерированное число простым)
            questionAndAnswer[i][Engine.ANSWER_INDEX] = itPrimeNumber(randomNumber) ? "yes" : "no";

        }

        // Передаем данные для вопроса и правильный ответ
        Engine.engine(DESCRIPTION, questionAndAnswer);

    }
}
