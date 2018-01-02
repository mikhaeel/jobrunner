package info.everybodylies.job.arraysort;

import info.everybodylies.jobrunner.core.Job;
import info.everybodylies.jobrunner.core.JobResult;

import java.util.Arrays;

/**
 * Класс в котором реализована логика решения задачи
 */
public class ArraySortJob implements Job {

    private ArraySortJobData jobData;

    public ArraySortJob(ArraySortJobData data) {
        this.jobData = data;
    }

    public JobResult call() throws Exception {
        Arrays.sort(jobData.getIntegers());
        return new ArraySortJobResult(jobData.getIntegers());
    }
}
