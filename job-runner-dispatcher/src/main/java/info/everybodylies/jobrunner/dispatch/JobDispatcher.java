package info.everybodylies.jobrunner.dispatch;

import info.everybodylies.job.arraysort.ArrayJobProvider;
import info.everybodylies.jobrunner.core.Job;
import info.everybodylies.jobrunner.core.JobResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс в котором реализуется логика управления исполнителями задач
 */
public class JobDispatcher {

    private static final Logger logger = LogManager.getLogger(JobDispatcher.class);

    private static final List<JobRunner> jobRunnerList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // get job from somewhere
            JarClassloader jarClassloader = new JarClassloader("array-sort-job-1.0.jar");
            logger.debug("Start JobDispatcher..");
            // create job runner
            logger.debug("try to get new job from JobProvider...");
            ArrayJobProvider arrayJobProvider = new ArrayJobProvider();
            logger.debug("new JobProvider successfully created!");
            Job job = arrayJobProvider.getJob();
            JobRunner runner = new JobRunner(job);
            runner.stopExecution();
            jobRunnerList.add(runner);
            JobResult jobResult = null;
            while (jobResult == null) {
                jobResult = runner.getJobResult();
            }
            // get job result
            logger.debug("Result from job: " + jobResult);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
