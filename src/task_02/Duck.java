package task_02;

public abstract class Duck {
    FlyBehavior flyBehavior;
    private int doneDistanсe;
    private boolean isFinished = false;

    public Duck() {
    }

    public int performFly() {
        return flyBehavior.fly();
    }

    public int getDoneDistanсe() {
        return doneDistanсe;
    }

    public void addToDoneDistanse(int add) {
        doneDistanсe += add;
        if (doneDistanсe >= Modifier.DISTANCE) isFinished = true;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public abstract void Display();
}
