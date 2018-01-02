package info.everybodylies.jobrunner.core;

import java.util.concurrent.Callable;

public interface Job extends Callable<JobResult> {
}
