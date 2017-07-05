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
    private Coordinate[] occupiedSpace;
    /**
     * Contains number of "health points" of this ship
     */
    private int health;

    /**
     * Creates a new ship
     *
     * @param occupiedSpace - list of points occupied by this ship
     */
    private Ship(Coordinate[] occupiedSpace) {
        this.occupiedSpace = occupiedSpace;
        this.health = occupiedSpace.length;
    }

    /**
     * Generates random list of points by length according to battlefield size and already occupied points
     *
     * @param field  - field on which ship will be located
     * @param length - required length
     * @return new ship
     */
    public static Ship getNewInstance(Field field, int length) {
        boolean correct = false;
        Coordinate[] occupiedSpace = new Coordinate[length];
        Random random = new Random();
        int x;
        int y;
        int z;
        while (!correct) {
            x = random.nextInt(field.getField().length);
            y = random.nextInt(field.getField().length);
            z = random.nextInt(field.getField().length);
            Coordinate bow = new Coordinate(x, y, z);
            String direction = Directions.values()[random.nextInt(Directions.values().length)].toString();
            occupiedSpace = new Coordinate[length];

            switch (direction) {
                case "RIGHT":
                    for (int i = 0; i < length; i++) {
                        occupiedSpace[i] = new Coordinate(bow.getX() + i, bow.getY(), bow.getZ());
                    }
                    break;
                case "LEFT":
                    for (int i = 0; i < length; i++) {
                        occupiedSpace[i] = new Coordinate(bow.getX() - i, bow.getY(), bow.getZ());
                    }
                    break;
                case "UP":
                    for (int i = 0; i < length; i++) {
                        occupiedSpace[i] = new Coordinate(bow.getX(), bow.getY() + i, bow.getZ());
                    }
                    break;
                case "DOWN":
                    for (int i = 0; i < length; i++) {
                        occupiedSpace[i] = new Coordinate(bow.getX(), bow.getY() - i, bow.getZ());
                    }
                    break;
                case "FORWARD":
                    for (int i = 0; i < length; i++) {
                        occupiedSpace[i] = new Coordinate(bow.getX(), bow.getY(), bow.getZ() + i);
                    }
                    break;
                case "BACKWARD":
                    for (int i = 0; i < length; i++) {
                        occupiedSpace[i] = new Coordinate(bow.getX(), bow.getY(), bow.getZ() - i);
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
    private static boolean isAvailableToPlace(Coordinate[] occupiedSpace, Field field) {
        for (Coordinate coor : occupiedSpace
                ) {
            for (int i = Math.max(0, coor.getX() - 1); i < Math.min(field.getField().length, coor.getX() + 2); i++) {
                for (int j = Math.max(0, coor.getY() - 1); j < Math.min(field.getField().length, coor.getY() + 2); j++) {
                    for (int k = Math.max(0, coor.getZ() - 1); k < Math.min(field.getField().length, coor.getZ() + 2); k++) {
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
    private static boolean isInBorders(Coordinate[] occupiedSpace, Field field) {
        for (Coordinate coor : occupiedSpace
                ) {
            if (coor.getX() >= field.getField().length) return false;
            if (coor.getX() < 0) return false;
            if (coor.getY() >= field.getField().length) return false;
            if (coor.getY() < 0) return false;
            if (coor.getZ() >= field.getField().length) return false;
            if (coor.getZ() < 0) return false;
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

    public Coordinate[] getOccupiedSpace() {
        return occupiedSpace;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(Text.DECKS.get(this.occupiedSpace.length));
        for (Coordinate coor : this.occupiedSpace
                ) {
            builder.append(coor.toString()).append("\n");
        }
        return builder.toString();
    }
}
