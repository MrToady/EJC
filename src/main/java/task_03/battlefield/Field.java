package task_03.battlefield;

import task_03.mod.Settings;
import task_03.mod.Text;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Contains condition of the battlefield
 */
public class Field {
    /**
     * Contains three-dimensional list of points
     */
    private FieldPoint[][][] field = new FieldPoint[Settings.FIELD_SIZE][Settings.FIELD_SIZE][Settings.FIELD_SIZE];
    /**
     * Contains set of "alive" ships on this battlefield
     */
    private HashSet<Ship> ships;

    /**
     * Creates new battlefield, locates ships on it
     */
    public Field() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field.length; k++) {
                    field[i][j][k] = new FieldPoint();
                }
            }
        }
        this.ships = new HashSet<>(20);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                ships.add(Ship.getNewInstance(this, 4 - i));
            }
        }
    }

    /**
     * Changes value of corresponding points of battlefield to "busy".
     * Add ship to ships set
     *
     * @param ship - ship that will be located on the field
     */
    public void placeShip(Ship ship) {
        for (Point point : ship.getOccupiedSpace()
                ) {
            field[point.getX()][point.getY()][point.getZ()].isBusyNow();
        }
        ships.add(ship);
    }

    /**
     * Checks if player hit some ship
     * Removes ship if it is "killed" from ships set
     * Prints messages about hitting
     *
     * @param shotPoint - point which player has chosen to shoot
     */
    public void addShot(Point shotPoint) {
        Iterator<Ship> iter = ships.iterator();
        while (iter.hasNext()) {
            Ship ship = iter.next();
            for (Point shipPoint : ship.getOccupiedSpace()
                    ) {
                if (shipPoint.equals(shotPoint)) {
                    ship.reduceHealth();
                    if (ship.isKilled()) {
                        ships.remove(ship);
                        System.out.println(Text.GAME_KILLED);
                    } else {
                        System.out.println(Text.GAME_INJURED);
                    }
                    return;
                }
            }
        }
        System.out.println(Text.FAIL);
    }

    /**
     * Checks if battlefield has "alive" ships
     *
     * @return true or false
     */
    public boolean allKilled() {
        return ships.isEmpty();
    }

    public FieldPoint[][][] getField() {
        return field;
    }
}
