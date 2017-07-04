package task_03.battlefield;

import task_03.mod.Text;

public class WrongLengthException extends Exception {
    public WrongLengthException() {
        super(Text.WRONG_LENGTH);
    }
}
