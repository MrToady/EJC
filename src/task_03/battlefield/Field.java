package task_03.battlefield;

import task_03.mod.Settings;
import task_03.mod.Text;
import java.util.HashSet;
import java.util.Iterator;

public class Field {
    private FieldPoint[][][] field = new FieldPoint[Settings.FIELD_SIZE][Settings.FIELD_SIZE][Settings.FIELD_SIZE];
    private HashSet<Ship> ships;

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
        //ships.forEach(ship -> System.out.println(ship.toString()));
    }

    public FieldPoint[][][] getField() {
        return field;
    }

    public void placeShip(Ship ship) {
        for (Coordinate coor : ship.getOccupiedSpace()
                ) {
            field[coor.getX()][coor.getY()][coor.getZ()].isBusyNow();
        }
        ships.add(ship);
    }

    public void addShot(Coordinate shootCoor) {
        Iterator<Ship> iter = ships.iterator();
        while (iter.hasNext()) {
            Ship ship = iter.next();
            for (Coordinate shipCoor : ship.getOccupiedSpace()
                    ) {
                if (shipCoor.equals(shootCoor)) {
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

    public boolean allKilled() {
        return ships.isEmpty();
    }
}
