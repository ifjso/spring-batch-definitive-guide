package io.spring.batch.chapter04.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDecider implements JobExecutionDecider {

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            return new FlowExecutionStatus(FlowExecutionStatus.COMPLETED.getName());
        }

        return new FlowExecutionStatus(FlowExecutionStatus.FAILED.getName());
    }
}
