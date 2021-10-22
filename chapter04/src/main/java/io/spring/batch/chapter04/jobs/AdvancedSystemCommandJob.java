package io.spring.batch.chapter04.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.SimpleSystemProcessExitCodeMapper;
import org.springframework.batch.core.step.tasklet.SystemCommandTasklet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@EnableBatchProcessing
@SpringBootApplication
public class AdvancedSystemCommandJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public AdvancedSystemCommandJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("systemCommandJob")
                .start(systemCommandStep())
                .build();
    }

    @Bean
    public Step systemCommandStep() {
        return this.stepBuilderFactory.get("systemCommandStep")
                .tasklet(systemCommandTasklet())
                .build();
    }

    @Bean
    public SystemCommandTasklet systemCommandTasklet() {
        SystemCommandTasklet tasklet = new SystemCommandTasklet();
        tasklet.setCommand("touch tmp.txt");
        tasklet.setTimeout(5000L);
        tasklet.setInterruptOnCancel(true);

        tasklet.setWorkingDirectory("/Users/ifjso");
        tasklet.setSystemProcessExitCodeMapper(touchCodeMapper());
        tasklet.setTerminationCheckInterval(5000L);
        tasklet.setTaskExecutor(new SimpleAsyncTaskExecutor());
        tasklet.setEnvironmentParams(new String[] {"JAVA_HOME=/java", "BATCH_HOME=/Users/batch"});
        return tasklet;
    }

    @Bean
    public SimpleSystemProcessExitCodeMapper touchCodeMapper() {
        return new SimpleSystemProcessExitCodeMapper();
    }
}
