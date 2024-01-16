package exceptions;

import animals.humans.Human;

public class InvalidHumanCreationException extends RuntimeException {
    public InvalidHumanCreationException(Human human) {
        super(generateMessage(human));
    }

    private static String generateMessage(Human human) {
        StringBuilder message = new StringBuilder("Ошибка при создании человека: ");

        // Проверка здоровья и добавление сообщения
        if (human.getHealth() == 0 && human.isAlive()) {
            message.append("Здоровье не может быть 0. ");
        }

        return message.toString().trim();
    }
}
