package task_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Thread that reads information from the only input file and writes it to the buffer map
 */
public class ReadingThread extends Thread {
    private File fileForParsing;
    private Map<String, Long> timeMap;

    public ReadingThread(File fileForParsing, Map<String, Long> timeMap) {
        this.fileForParsing = fileForParsing;
        this.timeMap = timeMap;
    }

    /**
     * Reads the file line by line, then parses it
     * and adds information from the file to the buffer map.
     * The key is a string that consists of a user name and url.
     * If the map already contains the key, values are summed up.
     */
    @Override
    public void run() {
        String tableRow;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileForParsing))) {
            bufferedReader.readLine();
            while ((tableRow = bufferedReader.readLine()) != null) {
                String[] stringValue = tableRow.split(";");
                String login = stringValue[3];
                String url = stringValue[1];
                Long time = Long.parseLong(stringValue[2]);
                timeMap.merge(login + ";" + url, time, (oldTime, newTime) -> oldTime + newTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
