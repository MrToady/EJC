package task_02;

public class FlyWithRandomSpeed implements FlyBehavior {
    @Override
    public int fly() {
        int minSpeed = 10;
        int maxSpeed = 100;
        maxSpeed -= minSpeed;
        int randomSpeed = (int) (Math.random() * ++maxSpeed) + minSpeed;
        return Math.random() > 0.5 ? randomSpeed >> 1 : randomSpeed << 1;
    }
}
