package io.spring.batch.chapter04.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class GoodByeTasklet implements Tasklet {

    private static final String HELLO_WORLD = "GoodBye, %s";

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        String name = (String) chunkContext.getStepContext()
                .getJobParameters()
                .get("name");

        System.out.println(String.format(HELLO_WORLD, name));

        return RepeatStatus.FINISHED;
    }
}
