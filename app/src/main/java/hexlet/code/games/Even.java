package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Even {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // DESCRIPTION для условия задачи
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final String DESCRIPTION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void even() {

        // Создаем двумерный массив для записи в него вопросов и ответов
        String[][] questionAndAnswer = new String[Engine.ROUNDS_COUNT][2];

        // Начинаем цикл для заполнения массива questionAndAnswer данными (вопросы и ответы)
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            // Генерируем случайное число
            var randomNumber = RandomUtils.nextInt(MIN, MAX); //(int) (Math.random() * 100);

            // Объявляем переменную evenNumber для записии в неё результат проверки на четность
            String evenNumber = "";
            // Проверяем сгенерированное число на четность, если четное, то переменной
            // "evenNumber" присваиваем значение "yes", если нечетное - "no"
            evenNumber = (randomNumber % 2) == 0 ? "yes" : "no";

            // Записываем в массив вопрос для пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            questionAndAnswer[i][Engine.QUESTION_INDEX] = "" + randomNumber;
            // Записываем в массив правильный ответ
            questionAndAnswer[i][Engine.ANSWER_INDEX] = evenNumber;

        }

        // Передаем данные для вопроса и правильный ответ
        Engine.engine(DESCRIPTION, questionAndAnswer);

    }
}
