package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import org.apache.commons.lang3.RandomUtils;

public class Even {

    // Объявляем константы. MIN и MAX для генерации случайного числа.
    // ITERATION для количества вопросов пользователю (по умолчанию 3)
    // DESCRIPTION для условия задачи
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int ITERATION = 3;
    private static final String DESCRIPTION =
            "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void even() {
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

            // Генерируем случайное число
            var randomNumber = RandomUtils.nextInt(MIN, MAX); //(int) (Math.random() * 100);

            // Объявляем переменную evenNumber для записии в неё результат проверки на четность
            String evenNumber = "";
            // Проверяем сгенерированное число на четность, если четное, то переменной
            // "evenNumber" присваиваем значение "yes", если нечетное - "no"
            evenNumber = (randomNumber % 2) == 0 ? "yes" : "no";

            // Передаем данные для вопроса пользователя, правильный ответ и имя пользователя
            // C помощью конкатенации приводим переменные типа int к типу String
            var result = Engine.engine("" + randomNumber, evenNumber, userName);

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
