package io.spring.batch.chapter04.jobs;

import io.spring.batch.chapter04.service.CustomService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableBatchProcessing
@SpringBootApplication
public class MethodInvokingTaskletConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public MethodInvokingTaskletConfiguration(JobBuilderFactory jobBuilderFactory,
                                              StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

//    @Bean
//    public Job methodInvokingJob() {
//        return this.jobBuilderFactory.get("methodInvokingJob")
//                .start(methodInvokingStep())
//                .build();
//    }
//
//    @Bean
//    public Step methodInvokingStep() {
//        return this.stepBuilderFactory.get("methodInvokingStep")
//                .tasklet(methodInvokingTasklet(null))
//                .build();
//    }
//
//    @StepScope
//    @Bean
//    public MethodInvokingTaskletAdapter methodInvokingTasklet(@Value("#{jobParameters['message']}") String message) {
//        MethodInvokingTaskletAdapter methodInvokingTaskletAdapter = new MethodInvokingTaskletAdapter();
//        methodInvokingTaskletAdapter.setTargetObject(service());
//        methodInvokingTaskletAdapter.setTargetMethod("serviceMethod");
//        methodInvokingTaskletAdapter.setArguments(new Object[] {message});
//        return methodInvokingTaskletAdapter;
//    }
//
//    @Bean
//    public CustomService service() {
//        return new CustomService();
//    }
}
