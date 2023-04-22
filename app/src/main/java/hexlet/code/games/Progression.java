package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class Progression {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // ITERATION для количества вопросов пользователю (по умолчанию 3)
    // PROGRESSION_LENGTH для длинны прогрессии
    // DESCRIPTION для условия задачи
    private static final int MIN = 2;
    private static final int MAX = 100;
    private static final int MAX_STEP = 20;
    private static final int ITERATION = 3;
    private static final int PROGRESSION_LENGTH = 10;
    private static final String DESCRIPTION =
            "What number is missing in the progression?";

    // Метод, который формирует прогрессию
    public static String[] makeProgression(int first, int step, int progressionLength) {

        // Объявляем массив для элементов прогрессии
        int[] elementsProgression = new int[progressionLength];

        // Объявляем новый массив строк
        String[] newArray = new String[progressionLength];

        // Присваиваем превому элементу массива значение переменной first
        elementsProgression[0] = first;
        newArray[0] = String.valueOf(first);

        // Заполняем массив "elementsProgression" элементами прогрессии
        for (int j = 1; j < progressionLength; j++) {
            elementsProgression[j] = elementsProgression[j - 1] + step;
            newArray[j] = String.valueOf(elementsProgression[j]);
        }

        // Возвращаем полученный массив
        return newArray;

    }

    public static void progression() {
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

        // Начинаем цикл для генерации арифметической прогрессии, приема ответа пользователя
        // и проверки ответа пользователя
        for (int i = 0; i < ITERATION; i++) {

            // Генерируем первый элемент прогрессии
            var first = RandomUtils.nextInt(MIN, MAX);
            // Генерируем шаг прогрессии
            var step = RandomUtils.nextInt(MIN, MAX_STEP);

            // Создаем массив с элементами прогрессии
            String[] elementsProgression = makeProgression(first, step, PROGRESSION_LENGTH);

            // Генерируем идекс элемента массива, который заменим на ".."
            var hiddenMemberIndex = RandomUtils.nextInt(0, elementsProgression.length - 1);



            // Объявляем переменную answer и присваиваем ей занчение элемента массива, который заменим на ".."
            String answer = elementsProgression[hiddenMemberIndex];

            // Заменяем элемент с индексом hiddenMemberIndex на ".."
            elementsProgression[hiddenMemberIndex] = "..";
            // Переводим массив elementsProgression в строку и присваиваем её значение переменной question
            String question = String.join(" ", elementsProgression);

            // Передаем данные для вопроса пользователя, правильный ответ и имя пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            var result = Engine.engine(question, answer, userName);

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
