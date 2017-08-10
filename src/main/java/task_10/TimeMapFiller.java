package task_10;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimeMapFiller {
    private Map<String, Long> timeMap;

    public TimeMapFiller(Map<String, Long> timeMap) {
        this.timeMap = timeMap;
    }

    /**
     * Creates a thread pool with specified number of reading threads
     * This pool always has a specified number of threads running;
     * if a thread is somehow terminated while it is still in use,
     * it is automatically replaced with a new thread. Tasks are submitted to the pool
     * via an internal queue, which holds extra tasks whenever there are more active tasks than threads.
     *
     * @see ReadingThread
     */
    public Map fill(DirectoryHandler directoryHandler) {
        ExecutorService executorService = Executors.newFixedThreadPool(Settings.threadAmount);
        for (File fileForParsing : directoryHandler.getAllCSVFiles()) {
            executorService.execute(new ReadingThread(fileForParsing, timeMap));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return timeMap;
    }
}
