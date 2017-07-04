package task_03.battlefield;

import task_03.mod.Settings;


public class   TwoDeckShip extends AbstractShip{

    private static int length = Settings.TWO;

    public TwoDeckShip(Coordinate bowCoor, Coordinate sternCoor) throws WrongLengthException {
        super(bowCoor, sternCoor, length);
    }
}
