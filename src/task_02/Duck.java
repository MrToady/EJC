package task_02;

public abstract class Duck {
    FlyBehavior flyBehavior;

    public Duck() {
    }

    public int performFly() {
        return flyBehavior.fly();
    }

    public abstract void Display();
}
