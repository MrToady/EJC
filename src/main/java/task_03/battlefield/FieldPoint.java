package task_03.battlefield;

/**
 * Contains and sets condition of battlefield's point
 *
 * @see Field
 */
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
