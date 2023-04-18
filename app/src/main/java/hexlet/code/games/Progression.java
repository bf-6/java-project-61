package hexlet.code.games;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class Progression {

    public static void progression() {
        // Приветствуем пользователя
        String userName = Cli.nameForOurUser();

        // Выводим на экран условие игры
        System.out.println("What number is missing in the progression?");

        Scanner userResponseInput = new Scanner(System.in);

        // Начинаем цикл для генерации арифметической прогрессии, приема ответа пользователя
        // и проверки ответа пользователя
        int i;
        for (i = 0; i < 3; i++) {

            // Генерируем длину прогрессии
            var numberProgressionElements = RandomUtils.nextInt(5, 11);
            // Генерируем первый элемент прогрессии
            var firstElementProgression = RandomUtils.nextInt(1, 99);
            // Генерируем шаг прогрессии
            var progressionStep = RandomUtils.nextInt(2, 20);

            // Объявляем массив для элементов прогрессии
            int[] elementsProgression = new int[numberProgressionElements];
            // Присваиваем превому элементу массива значение переменно firstElementProgression
            elementsProgression[0] = firstElementProgression;


            // Заполняем массив "elementsProgression" элементами прогрессии
            for (int j = 1; j < numberProgressionElements; j++) {
                elementsProgression[j] = elementsProgression[j - 1] + progressionStep;
            }

            // Генерируем идекс элемента массива, который заменим на ".."
            var resultOperation = RandomUtils.nextInt(0, numberProgressionElements);

            System.out.print("Question: ");
            for (int n = 0; n < numberProgressionElements; n++) {
                if (elementsProgression[n] == elementsProgression[resultOperation]) {
                    System.out.print(".. ");
                } else {
                    System.out.print(elementsProgression[n] + " ");
                }
            }

            System.out.println("");

            // Объявляем переменную "userResponse" для записи ответа пользователя
            // и принмимаем ответ пользователя с клавиатуры
            System.out.print("Your choice: ");
            int userResponse = Integer.parseInt(userResponseInput.next());

            // Проверяем верен ли ответ пользователя
            if (userResponse == elementsProgression[resultOperation]) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userResponse + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + elementsProgression[resultOperation] + "'\n"
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
