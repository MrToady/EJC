package task_03.battlefield;

import task_03.mod.Settings;

public class Field {

    private FieldPoint[][][] field = new FieldPoint[Settings.FIELD_SIZE][Settings.FIELD_SIZE][Settings.FIELD_SIZE];

    public Field() {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field.length; k++) {
                    field[i][j][k] = new FieldPoint();
                }
            }
        }
    }

    public FieldPoint[][][] getField() {
        return field;
    }

    public void placeShip(Ship ship) {
        for (Coordinate coor : ship.getOccupiedSpace()
                ) {
            field[coor.getX()][coor.getY()][coor.getZ()].isBusyNow();
        }
    }
}
