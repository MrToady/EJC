package task_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Responsible for creating input files list,
 * output table and storing information about input and output directories
 */
public class DirectoryHandler {
    /**
     * contains files for parsing
     *
     * @see Settings
     */
    private File inputDirectory;
    /**
     * Path for the output file
     *
     * @see Settings
     */
    private File outputFile;

    public DirectoryHandler(File inputDirectory, File outputDirectory, String outputFileName) {
        this.inputDirectory = inputDirectory;
        this.outputFile = new File(outputDirectory.getPath() + String.format("\\%s.csv", outputFileName));
    }

    /**
     * @return the full list of csv files in the directory
     */
    public List<File> getAllCSVFiles() {
        List<File> csvFileList = new ArrayList<>();
        for (File file : inputDirectory.listFiles()
                ) {
            if (isCSV(file)) {
                csvFileList.add(file);
            }
        }
        return csvFileList;

    }

    /**
     * Checks if the file is CSV
     *
     * @param file to check
     * @return true or false
     */
    private boolean isCSV(File file) {
        return file.getName()
                .toLowerCase()
                .endsWith(".csv");
    }
    /**
     * Sorts the buffer map
     * Writes information from the buffer map to the output table
     *
     * @param timeMap - map compiled from input files
     */
    public void writeToOutputTable(Map<String, Long> timeMap) {
        TreeMap<String, Long> sortedTimeMap = new TreeMap<>(timeMap);
        try (FileWriter writer = new FileWriter(outputFile, false)) {
            writer.write("User;URL;Time\n");
            for (Map.Entry<String, Long> entry : sortedTimeMap.entrySet()
                    ) {
                String[] userAndUrl = entry.getKey().split(";");
                String user = userAndUrl[0];
                String url = userAndUrl[1];
                writer.write(String.format("%s;%s;%d\n", user, url, entry.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
