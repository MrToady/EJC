package task_10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Creates new directory handler according to the settings
 * Creates buffer map for storing information from the input files
 * Writes information from the map to output file
 *
 * @see Settings
 */
public class Parser {
    public void parse() {
        DirectoryHandler directoryHandler = new DirectoryHandler(Settings.inputDirectory, Settings.outputDirectory, Settings.outputFileName);
        Map<String, Long> timeMap = new ConcurrentHashMap<>();
        TimeMapFiller mapFiller = new TimeMapFiller(timeMap);
        directoryHandler.writeToOutputTable(mapFiller.fill(directoryHandler));
    }
}
