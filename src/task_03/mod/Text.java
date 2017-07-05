package task_03.mod;

import java.util.HashMap;

public class Text {
    public static final String GAME_WELCOME = "Здравствуйте! Перед вами трехмерная игра \"Морской бой\". \n" +
            "На трехмерном поле размером 6х6х6 клеток размещены 10 кораблей - \n" +
            "один четырехпалубный корабль\n" +
            "два трехпалубных корабля\n" +
            "три двухпалубных корабля\n" +
            "и четыре однопалубных корабля.\n\n" +
            "Корабли размещаются в случайном порядке. " +
            "Участвуют два игрока. Каждый игрок вводит координаты своего выстрела из консоли.\n" +
            "Победителем становится тот, кто первым поразит все корабли противника. Удачи!";
    public static final String GAME_PLAY_AGAIN = "Хотели бы вы сыграть? (д/н): ";
    public static final String GAME_START = "Начинаем новую партию!";
    public static final String GAME_NO_START = "Игра завершена.";
    public static final String GAME_WRONG_ANSWER = "Введите 'д' для положительного ответа или 'н' - для отрицательного";
    public static final String GAME_COORDINATE = "Введите координату выстрела по оси ";
    public static final String GAME_NUMBER_FORMAT_EXCEPTION = "Введите координату корректно.";
    public static final String GAME_WRONG_NUMBER = "Введите число от 0 до %d";
    public static final String GAME_WRONG_POINT = "Вы уже обстреливали эту точку.";
    public static final String GAME_INJURED = "Попадание! Корабль ранен.";
    public static final String GAME_KILLED = "Попадание! Корабль убит.";
    public static final String FAIL = "Промах.";
    public static final String WIN = "Все корабли противника уничтожены. Вы победили!";
    public static final String FIRST_PLAYER_MOVE = "\nХодит первый игрок";
    public static final String SECOND_PLAYER_MOVE = "\nХодит второй игрок";
    public static final HashMap<Integer, String> DECKS = new HashMap<>();

    static {
        DECKS.put(4, "четырехпалубный корабль. \n");
        DECKS.put(3, "трехпалубный корабль. \n");
        DECKS.put(2, "двухпалубный корабль. \n");
        DECKS.put(1, "однопалубный корабль. \n");
    }
}
