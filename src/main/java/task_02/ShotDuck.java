package task_02;

/**
 * Creates a Shot Duck (Duck which cannot fly)
 */
public class ShotDuck extends Duck {
    public ShotDuck() {
        flyBehavior = new FlyNoWay();
    }

    /**
     * Prints Shot Duck's greeting
     */
    @Override
    public void Display() {
        System.out.println(Text.SHOT_DUCK_DISPLAY);
    }
}
