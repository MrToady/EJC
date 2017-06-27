package task_02;

public class HealthyDuck extends Duck{
    public HealthyDuck() {
        flyBehavior = new FlyWithRandomSpeed();
    }

    @Override
    public void Display() {
        System.out.println("Я здоровая утка!");
    }
}
