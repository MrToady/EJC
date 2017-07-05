package task_03.game;

import task_03.battlefield.Coordinate;
import task_03.battlefield.Field;
import task_03.mod.Settings;
import task_03.mod.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Player {
    private HashSet<Coordinate> shootedPoints;
    private Field field;

    public Player(Field field) {
        this.field = field;
        this.shootedPoints = new HashSet<>();
    }

    private static int coordinateInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int coordinate;
        while (true) {
            try {
                coordinate = Integer.parseInt(reader.readLine());
                if (coordinate < 0 || coordinate >= Settings.FIELD_SIZE)
                    System.out.println(String.format(Text.GAME_WRONG_NUMBER, Settings.FIELD_SIZE - 1));
                else break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println(Text.GAME_NUMBER_FORMAT_EXCEPTION);
            }
        }
        return coordinate;
    }

    public Field getField() {
        return field;
    }

    public Coordinate shot() {
        int x;
        int y;
        int z;
        Coordinate coordinate;
        while (true) {
            System.out.print(Text.GAME_COORDINATE + "X: ");
            x = coordinateInput();
            System.out.print(Text.GAME_COORDINATE + "Y: ");
            y = coordinateInput();
            System.out.print(Text.GAME_COORDINATE + "Z: ");
            z = coordinateInput();
            coordinate = new Coordinate(x, y, z);
            if (shootedPoints.contains(coordinate)) System.out.println(Text.GAME_WRONG_POINT);
            else {
                shootedPoints.add(coordinate);
                return coordinate;
            }
        }
    }

    public boolean allKilled() {
        return this.field.allKilled();
    }
}

