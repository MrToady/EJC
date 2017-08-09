package task_10;

import java.util.concurrent.ConcurrentHashMap;

public class Parser {
    public void parse() {
        DirectoryHandler directoryHandler = new DirectoryHandler(Settings.inputDirectory, Settings.outputDirectory, Settings.outputFileName);
        ConcurrentHashMap<String, Long> timeMap = new ConcurrentHashMap<>();
        TimeMapFiller mapFiller = new TimeMapFiller(timeMap);
        directoryHandler.writeToOutputTable(mapFiller.fill(directoryHandler));
    }
}
