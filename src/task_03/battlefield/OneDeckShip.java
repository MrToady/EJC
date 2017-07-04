package task_03.battlefield;


import task_03.mod.Settings;

public class OneDeckShip extends AbstractShip {

    private static int length = Settings.ONE;

    public OneDeckShip(Coordinate bowCoor, Coordinate sternCoor) throws WrongLengthException {
        super(bowCoor, sternCoor, length);
    }
}
