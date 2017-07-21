package task_03.battlefield;

import task_03.mod.Directions;
import task_03.mod.Text;

import java.util.Random;

/**
 * Contains ship logic
 */
public class Ship {
    /**
     * Contains list of points occupied by this ship
     */
    private Point[] occupiedSpace;
    /**
     * Contains number of "health points" of this ship
     */
    private int health;

    /**
     * Creates a new ship
     *
     * @param occupiedSpace - list of points occupied by this ship
     */
    private Ship(Point[] occupiedSpace) {
        this.occupiedSpace = occupiedSpace;
        this.health = occupiedSpace.length;
    }

    /**
     * Generates random list of points by length according to battlefield size and already occupied points
     *
     * @param field          - field on which ship will be located
     * @param requiredLength - required length
     * @return new ship
     */
    public static Ship getNewInstance(Field field, int requiredLength) {
        boolean correct = false;
        Point[] occupiedSpace = new Point[requiredLength];
        Random random = new Random();
        int x;
        int y;
        int z;
        while (!correct) {
            x = random.nextInt(field.getField().length);
            y = random.nextInt(field.getField().length);
            z = random.nextInt(field.getField().length);
            Point shipBow = new Point(x, y, z);
            Directions direction = Directions.values()[random.nextInt(Directions.values().length)];
            occupiedSpace = new Point[requiredLength];

            switch (direction) {
                case RIGHT:
                    for (int i = 0; i < requiredLength; i++) {
                        occupiedSpace[i] = new Point(shipBow.getX() + i, shipBow.getY(), shipBow.getZ());
                    }
                    break;
                case LEFT:
                    for (int i = 0; i < requiredLength; i++) {
                        occupiedSpace[i] = new Point(shipBow.getX() - i, shipBow.getY(), shipBow.getZ());
                    }
                    break;
                case UP:
                    for (int i = 0; i < requiredLength; i++) {
                        occupiedSpace[i] = new Point(shipBow.getX(), shipBow.getY() + i, shipBow.getZ());
                    }
                    break;
                case DOWN:
                    for (int i = 0; i < requiredLength; i++) {
                        occupiedSpace[i] = new Point(shipBow.getX(), shipBow.getY() - i, shipBow.getZ());
                    }
                    break;
                case FORWARD:
                    for (int i = 0; i < requiredLength; i++) {
                        occupiedSpace[i] = new Point(shipBow.getX(), shipBow.getY(), shipBow.getZ() + i);
                    }
                    break;
                case BACKWARD:
                    for (int i = 0; i < requiredLength; i++) {
                        occupiedSpace[i] = new Point(shipBow.getX(), shipBow.getY(), shipBow.getZ() - i);
                    }
                    break;
            }
            correct = isInBorders(occupiedSpace, field) && isAvailableToPlace(occupiedSpace, field);
        }
        Ship newShip = new Ship(occupiedSpace);
        field.placeShip(newShip);
        return newShip;
    }

    /**
     * Checks if points for ship location are already occupied
     *
     * @return true or false
     */
    private static boolean isAvailableToPlace(Point[] occupiedSpace, Field field) {
        for (Point point : occupiedSpace
                ) {
            for (int i = Math.max(0, point.getX() - 1); i < Math.min(field.getField().length, point.getX() + 2); i++) {
                for (int j = Math.max(0, point.getY() - 1); j < Math.min(field.getField().length, point.getY() + 2); j++) {
                    for (int k = Math.max(0, point.getZ() - 1); k < Math.min(field.getField().length, point.getZ() + 2); k++) {
                        if (field.getField()[i][j][k].isBusy()) return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks if points for ship location are in borders of the battlefield
     *
     * @return true or false
     */
    private static boolean isInBorders(Point[] occupiedSpace, Field field) {
        for (Point point : occupiedSpace
                ) {
            if (point.getX() >= field.getField().length) return false;
            if (point.getX() < 0) return false;
            if (point.getY() >= field.getField().length) return false;
            if (point.getY() < 0) return false;
            if (point.getZ() >= field.getField().length) return false;
            if (point.getZ() < 0) return false;
        }
        return true;
    }

    public void reduceHealth() {
        this.health--;
    }

    /**
     * Checks if ship has "health points"
     *
     * @return true or false
     */
    public boolean isKilled() {
        return this.health == 0;
    }

    public Point[] getOccupiedSpace() {
        return occupiedSpace;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(Text.DECKS.get(this.occupiedSpace.length));
        for (Point point : this.occupiedSpace
                ) {
            builder.append(point.toString()).append("\n");
        }
        return builder.toString();
    }
}
