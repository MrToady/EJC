package task_03.battlefield;

import task_03.mod.Directions;
import task_03.mod.Text;

import java.util.Random;

public class Ship {
    private Coordinate[] occupiedSpace;
    private int health;

    private Ship(Coordinate[] occupiedSpace) {
        this.occupiedSpace = occupiedSpace;
        this.health = occupiedSpace.length;
    }

    public static Ship getNewInstance(Field field, int length) {
        boolean correct = false;
        Coordinate[] occupiedSpace = new Coordinate[length];
        Random random = new Random();
        while (!correct) {
            int x = random.nextInt(field.getField().length);
            int y = random.nextInt(field.getField().length);
            int z = random.nextInt(field.getField().length);
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

    private static boolean isAvailableToPlace(Coordinate[] occupiedSpase, Field field) {
        for (Coordinate coor : occupiedSpase
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

    private static boolean isInBorders(Coordinate[] occupiedSpase, Field field) {
        for (Coordinate coor : occupiedSpase
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
