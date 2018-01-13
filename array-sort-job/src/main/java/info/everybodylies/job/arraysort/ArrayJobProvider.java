package info.everybodylies.job.arraysort;

import info.everybodylies.jobrunner.core.Job;
import info.everybodylies.jobrunner.core.JobProvider;

public class ArrayJobProvider implements JobProvider {

    @Override
    public Job getJob() {
        return new ArraySortJob(new ArraySortJobData());
    }
}
