package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void parityCheckNumber() {
        // Приветствуем пользователя
        String userName = Cli.nameForOurUser();

        // Выводим на экран условие игры
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Scanner userResponseInput = new Scanner(System.in);

        // Начинаем цикл для демонстрации пользователю числа, приема ответа пользователя
        // и проверки ответа пользователя
        int i;
        for (i = 0; i < 3; i++) {

            // Генерируем случайное число
            int randomNumber = (int) (Math.random() * 100);

            String evenNumber = "";
            // Проверяем сгенерированное число на четность, если четное, то переменной
            // "evenNumber" присваиваем значение "yes", если нечетное - "no"
            if (randomNumber % 2 == 0) {
                evenNumber = "yes";
            } else {
                evenNumber = "no";
            }

            System.out.println("Question: " + randomNumber);

            // Объявляем переменную "userResponse" для записи ответа пользователя
            // и принмимаем ответ пользователя с клавиатуры
            System.out.print("Your choice: ");
            String userResponse = userResponseInput.next();

            // Проверяем верен ли ответ пользователя
            if (userResponse.equalsIgnoreCase(evenNumber)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userResponse + "'" +
                        " is wrong answer ;(. Correct answer was " +
                        "'" + evenNumber + "'\n" +
                        "Let's try again, " + userName + "!");
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
