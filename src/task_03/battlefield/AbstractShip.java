package task_03.battlefield;

public abstract class AbstractShip {

    private Coordinate bowCoor;
    private Coordinate sternCoor;

    public AbstractShip(Coordinate bowCoor, Coordinate sternCoor, int length) throws WrongLengthException {
        if (lengthIsRight(bowCoor, sternCoor, length)) {
            this.bowCoor = bowCoor;
            this.sternCoor = sternCoor;
        } else throw new WrongLengthException();
    }

    public static boolean lengthIsRight(Coordinate bowCoor, Coordinate sternCoor, int lenght) {
        int deltaX = Math.abs(bowCoor.getX() - sternCoor.getX());
        int deltaY = Math.abs(bowCoor.getY() - sternCoor.getY());
        int deltaZ = Math.abs(bowCoor.getZ() - sternCoor.getZ());
        return ((deltaX == lenght - 1) && deltaY == 0 && deltaZ == 0) ||
                ((deltaY == lenght - 1) && deltaX == 0 && deltaZ == 0) ||
                ((deltaZ == lenght - 1) && deltaX == 0 && deltaY == 0);
    }

    public Coordinate getBowCoor() {
        return bowCoor;
    }

    public Coordinate getSternCoor() {
        return sternCoor;
    }

}
