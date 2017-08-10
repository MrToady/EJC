package task_10;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryHandlerTest {
    @Test
    void getAllCSVFiles() {
        File inputDirectory = new File(System.getProperty("user.dir") + "\\src\\test\\java\\task_10\\testData");
        File outputDirectory = new File(System.getProperty("user.dir") + "\\src\\test\\java\\task_10\\testData");
        String outputFileName = "Output table";
        File file6 = new File(System.getProperty("user.dir") + "\\src\\test\\java\\task_10\\testData\\file6.csv");
        File file12 = new File(System.getProperty("user.dir") + "\\src\\test\\java\\task_10\\testData\\file12.csv");
        File file14 = new File(System.getProperty("user.dir") + "\\src\\test\\java\\task_10\\testData\\file14.csv");

        Set<File> expectedFileSet = new HashSet<>();
        expectedFileSet.add(file6);
        expectedFileSet.add(file12);
        expectedFileSet.add(file14);

        DirectoryHandler directoryHandler = new DirectoryHandler(inputDirectory, outputDirectory, outputFileName);
        Set<File> actualFileSet = new HashSet<>(Arrays.asList(directoryHandler.getAllCSVFiles()));
        assertEquals(expectedFileSet, actualFileSet);
    }
}