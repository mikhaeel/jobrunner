package info.everybodylies.job.arraysort;

import info.everybodylies.jobrunner.core.JobData;

import java.util.Arrays;
import java.util.Random;

public class ArraySortJobData implements JobData {
    private static final int SIZE = 10000;
    private Integer[] integers;

    public ArraySortJobData() {
        this.integers = new Integer[SIZE];
        for(int i = 0; i < SIZE; i++) {
            integers[i] = new Random().nextInt(SIZE);
        }
    }

    public Integer[] getIntegers() {
        return integers;
    }

    @Override
    public String toString() {
        return "ArraySortJobData{" +
                "integers=" + Arrays.toString(integers) +
                '}';
    }
}
