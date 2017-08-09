package task_10;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeMapFiller {
    private ConcurrentHashMap<String, Long> timeMap;

    public TimeMapFiller(ConcurrentHashMap<String, Long> timeMap) {
        this.timeMap = timeMap;
    }

    public ConcurrentHashMap fill(DirectoryHandler directoryHandler) {
        ExecutorService executorService = Executors.newFixedThreadPool(Settings.threadAmount);
        for (File fileForParsing : directoryHandler.getAllCSVFiles()) {
            executorService.execute(new ReadingThread(fileForParsing, timeMap));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) ;
        return timeMap;
    }
}
