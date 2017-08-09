package task_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class ReadingThread extends Thread {
    private File fileForParsing;
    private ConcurrentHashMap<String, Long> timeMap;

    public ReadingThread(File fileForParsing, ConcurrentHashMap<String, Long> timeMap) {
        this.fileForParsing = fileForParsing;
        this.timeMap = timeMap;
    }

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
