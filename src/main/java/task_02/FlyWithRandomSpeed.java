package task_02;

public class FlyWithRandomSpeed implements FlyBehavior {

    /**
     * Generates random speed according {@link Modifier} class*
     * @return int speed
     */
    @Override
    public int fly() {
        int minSpeed = Modifier.MIN_SPEED;
        int maxSpeed = Modifier.MAX_SPEED;
        maxSpeed -= minSpeed;
        int randomSpeed = (int) (Math.random() * ++maxSpeed) + minSpeed;
        return Math.random() > 0.5 ? randomSpeed >> 1 : randomSpeed << 1;
    }
}
