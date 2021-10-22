package io.spring.batch.chapter04.jobs;

import io.spring.batch.chapter04.batch.LoggingStepStartStopListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableBatchProcessing
@SpringBootApplication
public class ChunkJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public ChunkJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

//    @Bean
//    public Job chunkBasedJob() {
//        return this.jobBuilderFactory.get("chunkBasedJob")
//                .start(chunkStep())
//                .build();
//    }
//
//    @Bean
//    public Step chunkStep() {
//        return this.stepBuilderFactory.get("chunkStep")
//                .<String, String>chunk(1000)
//                .reader(itemReader())
//                .writer(itemWriter())
//                .listener(new LoggingStepStartStopListener())
//                .build();
//    }

//    @Bean
//    public RandomChunkSizePolicy randomChunkSizePolicy() {
//        return new RandomChunkSizePolicy();
//    }

//    @Bean
//    public ListItemReader<String> itemReader() {
//        List<String> items = new ArrayList<>(100000);
//
//        for (int i = 0; i < 100000; i++) {
//            items.add(UUID.randomUUID().toString());
//        }
//
//        return new ListItemReader<>(items);
//    }
//
//    @Bean
//    public ItemWriter<String> itemWriter() {
//        return items -> {
//            for (String item : items) {
//                System.out.println(">> current item = " + item);
//            }
//        };
//    }
}
