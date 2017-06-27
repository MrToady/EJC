package task_02;

public class ShotDuck extends Duck{
    public ShotDuck() {
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void Display() {
        System.out.println("Я подстрелянная утка((");
    }
}
