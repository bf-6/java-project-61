package hexlet.code;

import java.util.Scanner;

public class Engine {

    // ROUNDS_COUNT для количества вопросов пользователю (по умолчанию 3)
    public static final int ROUNDS_COUNT = 3;
    // QUESTION_INDEX индекс вопросов всегда будет 0 (первый элемент строки в двуменом массиве)
    public static final int QUESTION_INDEX = 0;
    // ANSWER_INDEX индекс ответов всегда будет 1 (второй элемент в двумерном массиве)
    public static final int ANSWER_INDEX = 1;

    public static void engine(String description, String[][] even) {

        // Приветствуем пользователя
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        // Выводим на экран условие игры
        System.out.println(description);


        for (int i = 0; i < ROUNDS_COUNT; i++) {

            // Выводим вопрос для пользователя на экран
            System.out.println("Question: " + even[i][QUESTION_INDEX]);

            // Объявляем переменную "userResponse" для записи ответа пользователя
            // и принмимаем ответ пользователя с клавиатуры
            System.out.print("Your choice: ");
            String userResponse = scanner.next();

            // Проверяем верен ли ответ пользователя
            if (userResponse.equalsIgnoreCase(even[i][ANSWER_INDEX])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userResponse + "'"
                        + " is wrong answer ;(. Correct answer was "
                        + "'" + even[i][ANSWER_INDEX] + "'\n"
                        + "Let's try again, " + userName + "!");
                scanner.close();
                return;
            }
        }

        // Если пользователь ответил правильно на все вопросы, то выводим сообщение с поздравлением
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();

    }
}
