package task_03;

import task_03.battlefield.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Field field = new Field();
        ArrayList<Ship> ships = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                ships.add(Ship.getNewInstance(field, 4 - i));
            }
        }
        ships.forEach(ship -> System.out.println(ship.toString()));
    }
}
