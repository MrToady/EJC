package task_03.battlefield;

public class FieldPoint {
    private boolean busy;

    public FieldPoint() {
        this.busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public void isBusyNow() {
        this.busy = true;
    }
}
