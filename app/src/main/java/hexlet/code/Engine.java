package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static boolean engine(String question, String number, String userName) {

        Scanner userResponseInput = new Scanner(System.in);

        System.out.println("Question: " + question);

        // Объявляем переменную "userResponse" для записи ответа пользователя
        // и принмимаем ответ пользователя с клавиатуры
        System.out.print("Your choice: ");
        String userResponse = userResponseInput.next();

        // Проверяем верен ли ответ пользователя
        if (userResponse.equalsIgnoreCase(number)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userResponse + "'"
                    + " is wrong answer ;(. Correct answer was "
                    + "'" + number + "'\n"
                    + "Let's try again, " + userName + "!");
            userResponseInput.close();
        }

        userResponseInput.close();

        return false;

    }
}
