package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Progression {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // PROGRESSION_LENGTH для длинны прогрессии
    // DESCRIPTION для условия задачи
    private static final int MIN = 2;
    private static final int MAX = 100;
    private static final int MAX_STEP = 20;
    private static final int PROGRESSION_LENGTH = 10;
    private static final String DESCRIPTION =
            "What number is missing in the progression?";

    // Метод, который формирует прогрессию
    public static String[] makeProgression(int first, int step, int progressionLength) {

        // Объявляем массив для элементов прогрессии
        String[] progression = new String[progressionLength];

        // Заполняем массив progression элементами прогрессии
        for (int i = 0; i < progressionLength; i += 1) {
            progression[i] = Integer.toString(first + i * step);
        }

        // Возвращаем полученный массив
        return progression;

    }

    public static void progression() {

        // Создаем двумерный массив для записи в него вопросов и ответов
        String[][] questionAndAnswer = new String[Engine.ROUNDS_COUNT][2];

        // Начинаем цикл для генерации арифметической прогрессии, приема ответа пользователя
        // и проверки ответа пользователя
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {

            // Генерируем первый элемент прогрессии
            var first = RandomUtils.nextInt(MIN, MAX);
            // Генерируем шаг прогрессии
            var step = RandomUtils.nextInt(MIN, MAX_STEP);

            // Создаем массив с элементами прогрессии
            String[] elementsProgression = makeProgression(first, step, PROGRESSION_LENGTH);

            // Генерируем идекс элемента массива, который заменим на ".."
            var hiddenMemberIndex = RandomUtils.nextInt(0, elementsProgression.length - 1);

            //Записываем в двумерный массив элемент массива, который заменим на ".." (правильный ответ)
            questionAndAnswer[i][Engine.ANSWER_INDEX] = elementsProgression[hiddenMemberIndex];

            // Заменяем элемент с индексом hiddenMemberIndex на ".."
            elementsProgression[hiddenMemberIndex] = "..";

            // Записываем в массив вопрос для пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            questionAndAnswer[i][Engine.QUESTION_INDEX] = String.join(" ", elementsProgression);

        }

        // Передаем данные для вопроса и правильный ответ
        Engine.engine(DESCRIPTION, questionAndAnswer);

    }

}

