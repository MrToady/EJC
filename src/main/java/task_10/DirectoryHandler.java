package task_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class DirectoryHandler {
    private File inputDirectory;
    private File outputFile;

    public DirectoryHandler(File inputDirectory, File outputDirectory, String outputFileName) {
        this.inputDirectory = inputDirectory;
        this.outputFile = new File(outputDirectory.getPath() + String.format("\\%s.csv", outputFileName));
    }

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

    private boolean isCSV(File file) {
        String fileName = file.getName();
        int indexOfExtension = fileName.lastIndexOf('.');
        return indexOfExtension != -1 && fileName.substring(indexOfExtension).equalsIgnoreCase(".csv");
    }

    public void writeToOutputTable(ConcurrentHashMap<String, Long> timeMap) {
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
