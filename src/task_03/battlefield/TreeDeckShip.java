package task_03.battlefield;

import task_03.mod.Settings;

public class TreeDeckShip extends AbstractShip {

    private static int length = Settings.THREE;

    public TreeDeckShip(Coordinate bowCoor, Coordinate sternCoor) throws WrongLengthException {
        super(bowCoor, sternCoor, length);
    }
}
