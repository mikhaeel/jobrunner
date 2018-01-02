package info.everybodylies.jobrunner.dispatch;

import info.everybodylies.job.arraysort.ArraySortJob;
import info.everybodylies.job.arraysort.ArraySortJobData;
import info.everybodylies.jobrunner.core.Job;
import info.everybodylies.jobrunner.core.JobResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс в котором реализуется логика управления исполнителями задач
 */
public class JobDispatcher {

    private static final Logger logger = LogManager.getLogger(JobDispatcher.class);

    private static final List<JobRunner> jobRunnerList = new ArrayList<>();

    public static void main(String[] args) {
        // get job from somewhere
        // create job runner
        // get job result
        logger.debug("Start JobDispatcher..");
        logger.debug("try to create new JobData...");
        ArraySortJobData data = new ArraySortJobData();
        logger.debug("new jobData created!");
        logger.debug("try to create new job...");
        Job job = new ArraySortJob(data);
        logger.debug("new job successfully created!");
        JobRunner runner = new JobRunner(job);
        jobRunnerList.add(runner);
        JobResult jobResult = null;
        while (jobResult == null) {
            jobResult = runner.getJobResult();
        }
        logger.debug("Result from job: " + jobResult);
    }
}
