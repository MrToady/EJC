package task_02;

public abstract class Duck {
    FlyBehavior flyBehavior;
    /**
     * Contains already passed distance
     */
    private int doneDistanсe;
    /**
     * flag signalising that duck finished
     */
    private boolean isFinished = false;

    public Duck() {
    }

    public int performFly() {
        return flyBehavior.fly();
    }

    public int getDoneDistanсe() {
        return doneDistanсe;
    }

    /**
     * Adds the distance which duck flew in second to doneDistance field
     * changing isFinished flag value
     *
     * @param add speed in this second
     */
    public void addToDoneDistanse(int add) {
        doneDistanсe += add;
        if (doneDistanсe >= Modifier.DISTANCE) isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public abstract void Display();
}
