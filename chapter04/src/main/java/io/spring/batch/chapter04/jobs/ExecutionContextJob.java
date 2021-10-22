package io.spring.batch.chapter04.jobs;

import io.spring.batch.chapter04.batch.HelloWorldTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableBatchProcessing
@SpringBootApplication
public class ExecutionContextJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public ExecutionContextJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

//    @Bean
//    public Job job() {
//        return this.jobBuilderFactory.get("job")
//                .start(step1())
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return this.stepBuilderFactory.get("step1")
//                .tasklet(helloWorldTasklet())
//                .build();
//    }
//
//    @Bean
//    public HelloWorldTasklet helloWorldTasklet() {
//        return new HelloWorldTasklet();
//    }
}
