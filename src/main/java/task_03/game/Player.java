package task_03.game;

import task_03.battlefield.Field;
import task_03.battlefield.Point;
import task_03.mod.Settings;
import task_03.mod.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Describes interaction with player
 */
public class Player {
    /**
     * Contains the set of points that player has already chosen
     *
     * @see Point
     */
    private HashSet<Point> shootedPoints;
    /**
     * Contains this player's battlefield
     *
     * @see Field
     */
    private Field field;

    /**
     * Creates new object
     *
     * @param field - player's battlefield
     */
    public Player(Field field) {
        this.field = field;
        this.shootedPoints = new HashSet<>();
    }

    /**
     * Asks player about coordinate by one of the axes to shoot
     * Checks if the coordinate is suitable to this battlefield
     *
     * @return coordinate from console
     */
    private static int coordinateInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int coordinate;
        while (true) {
            try {
                String coordinateString;
                coordinateString = reader.readLine();
                if (!coordinateString.matches("[-+]?\\d+")) {
                    System.out.println(Text.GAME_NUMBER_FORMAT);
                } else {
                    coordinate = Integer.parseInt(coordinateString);
                    if (coordinate < 0 || coordinate >= Settings.FIELD_SIZE) {
                        System.out.println(String.format(Text.GAME_WRONG_NUMBER, Settings.FIELD_SIZE - 1));
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return coordinate;
    }

    /**
     * Collects points values. Checks if suggested point was chosen before
     *
     * @return new point to shoot
     * @see Point
     */
    public Point shot() {
        int x;
        int y;
        int z;
        Point shotPoint;
        while (true) {
            System.out.printf("%sX: ", Text.GAME_COORDINATE);
            x = coordinateInput();
            System.out.printf("%sY: ", Text.GAME_COORDINATE);
            y = coordinateInput();
            System.out.printf("%sZ: ", Text.GAME_COORDINATE);
            z = coordinateInput();
            shotPoint = new Point(x, y, z);
            if (shootedPoints.contains(shotPoint)) {
                System.out.println(Text.GAME_WRONG_POINT);
            } else {
                shootedPoints.add(shotPoint);
                return shotPoint;
            }
        }
    }

    public Field getField() {
        return field;
    }

    /**
     * Checks if user has "alive" ships
     *
     * @return true or false
     */
    public boolean allKilled() {
        return this.field.allKilled();
    }
}

