package task_10;

import java.io.File;

public class Settings {
    public static final File inputDirectory = new File(System.getProperty("user.dir") + "\\src\\main\\java\\task_10\\data");
    public static final File outputDirectory = new File(System.getProperty("user.dir") + "\\src\\main\\java\\task_10\\data");
    public static final String outputFileName = "Output table";
    public static final int threadAmount = 10;
}
