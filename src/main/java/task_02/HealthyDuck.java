package task_02;

/**
 * Creates a Healthy Duck (Duck which can fly with random speed)
 */
public class HealthyDuck extends Duck {
    public HealthyDuck() {
        flyBehavior = new FlyWithRandomSpeed();
    }

    /**
     * Prints Healthy Duck's greeting
     */
    @Override
    public void Display() {
        System.out.println(Text.HEALTHY_DUCK_DISPLAY);
    }
}
