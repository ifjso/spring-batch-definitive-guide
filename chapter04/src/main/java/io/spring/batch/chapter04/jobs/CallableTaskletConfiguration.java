package io.spring.batch.chapter04.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.CallableTaskletAdapter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Callable;

@EnableBatchProcessing
@SpringBootApplication
public class CallableTaskletConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public CallableTaskletConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

//    @Bean
//    public Job callableJob() {
//        return this.jobBuilderFactory.get("callableJob")
//                .start(callableStep())
//                .build();
//    }
//
//    @Bean
//    public Step callableStep() {
//        return this.stepBuilderFactory.get("callableStep")
//                .tasklet(tasklet())
//                .build();
//    }
//
//    @Bean
//    public CallableTaskletAdapter tasklet() {
//        CallableTaskletAdapter callableTaskletAdapter = new CallableTaskletAdapter();
//        callableTaskletAdapter.setCallable(callableObject());
//        return callableTaskletAdapter;
//    }
//
//    @Bean
//    public Callable<RepeatStatus> callableObject() {
//        return () -> {
//            System.out.println("This was executed in another thread");
//            return RepeatStatus.FINISHED;
//        };
//    }
}
