package info.everybodylies.jobrunner.core;

public interface JobProvider {
    Job getJob();

    JobData getJobData();
}
