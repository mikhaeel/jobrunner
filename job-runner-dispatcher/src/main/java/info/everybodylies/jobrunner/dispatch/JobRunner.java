package info.everybodylies.jobrunner.dispatch;

import info.everybodylies.jobrunner.core.JobResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * Класс предназначен для запуска и возврата результата выполнения задачи
 */
public class JobRunner {

    private static final Logger logger = LogManager.getLogger(JobRunner.class);

    private static final int THREAD_POOL_SIZE = 1;
    private Future<JobResult> jobResult;
    private ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE, new DaemonThreadFactory());

    public JobRunner(Callable<JobResult> job) {
        logger.debug("Getting new job for execution");
        jobResult = executorService.submit(job);
        logger.debug("Job {} has been submitted", job);
    }

    /**
     * Возвращает результат работы программы
     *
     * @return Имплементация класса {@link JobResult} с результатами выполнения работы
     */
    public JobResult getJobResult() {
        if (jobResult.isDone()) {
            try {
                logger.debug("Job is done. Sutting down executor...");
                executorService.shutdown();
                logger.debug("executorService is shutted down");
                return jobResult.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Exceptions in jobResult.get(), {}", e);
            }
        }
        return null;
    }

    /**
     * Вызывает неемедленное завершение выпполнения задачи и прекращает работу
     */
    public void stopExecution() {
        if (!executorService.isTerminated()) {
            executorService.shutdown();
        }
    }

    /**
     * Класс предназначен для запуска всех потоков в режиме демона
     */
    private static class DaemonThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    }
}