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

    /**
     * Creates a thread pool with specified number of reading threads
     * This pool always has a specified number of threads running;
     * if a thread is somehow terminated while it is still in use,
     * it is automatically replaced with a new thread. Tasks are submitted to the pool
     * via an internal queue, which holds extra tasks whenever there are more active tasks than threads.
     *
     * @see ReadingThread
     */
    public ConcurrentHashMap fill(DirectoryHandler directoryHandler) {
        ExecutorService executorService = Executors.newFixedThreadPool(Settings.threadAmount);
        for (File fileForParsing : directoryHandler.getAllCSVFiles()) {
            executorService.execute(new ReadingThread(fileForParsing, timeMap));
        }
        executorService.shutdown();
        while (!executorService.isTerminated());
        return timeMap;
    }
}
