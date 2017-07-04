package task_03.battlefield;

import task_03.mod.Settings;

public class FourDeckShip extends AbstractShip {

    private static int length = Settings.FOUR;

    public FourDeckShip(Coordinate bowCoor, Coordinate sternCoor) throws WrongLengthException {
        super(bowCoor, sternCoor, length);
    }

    @Override
    public String toString() {
        return "FourDeckShip.\nbow: " + this.getBowCoor().toString() + "\n + stern: " + this.getSternCoor().toString();
    }
}
