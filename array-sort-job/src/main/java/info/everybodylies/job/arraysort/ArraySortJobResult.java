package info.everybodylies.job.arraysort;

import info.everybodylies.jobrunner.core.JobResult;

public class ArraySortJobResult implements JobResult {
    private Integer[] integers;

    public ArraySortJobResult(Integer[] integers) {
        this.integers = integers;
    }

    public Integer[] getIntegers() {
        return integers;
    }
}
