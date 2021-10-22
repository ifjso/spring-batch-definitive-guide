package io.spring.batch.chapter04.jobs;

import io.spring.batch.chapter04.batch.RandomDecider;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableBatchProcessing
@SpringBootApplication
public class ConditionalJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public ConditionalJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

//    @Bean
//    public Job job() {
//        return this.jobBuilderFactory.get("conditionalJob")
//                .start(firstStep())
//                .on("FAILED").stopAndRestart(successStep())
//                .from(firstStep()).on("*").to(successStep())
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step firstStep() {
//        return this.stepBuilderFactory.get("firstStep")
//                .tasklet(passTasklet())
//                .build();
//    }
//
//    @Bean
//    public Tasklet passTasklet() {
//        return (contribution, chunkContext) -> {
////            return RepeatStatus.FINISHED;
//            throw new RuntimeException("Causing a failure");
//        };
//    }
//
//    @Bean
//    public JobExecutionDecider decider() {
//        return new RandomDecider();
//    }
//
//    @Bean
//    public Step successStep() {
//        return this.stepBuilderFactory.get("successStep")
//                .tasklet(successTasklet())
//                .build();
//    }
//
//    @Bean
//    public Tasklet successTasklet() {
//        return (contribution, chunkContext) -> {
//            System.out.println("Success!");
//            return RepeatStatus.FINISHED;
//        };
//    }
//
//    @Bean
//    public Step failureStep() {
//        return this.stepBuilderFactory.get("failureStep")
//                .tasklet(failTasklet())
//                .build();
//    }
//
//    @Bean
//    public Tasklet failTasklet() {
//        return (contribution, chunkContext) -> {
//            System.out.println("Failure!");
//            return RepeatStatus.FINISHED;
//        };
//    }
}
