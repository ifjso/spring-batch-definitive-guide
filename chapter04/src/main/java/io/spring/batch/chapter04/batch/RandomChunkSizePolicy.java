package io.spring.batch.chapter04.batch;

import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.concurrent.ThreadLocalRandom;

public class RandomChunkSizePolicy implements CompletionPolicy {

    private int chunkSize;
    private int totalProcessed;

    @Override
    public boolean isComplete(RepeatContext context, RepeatStatus result) {
        if (RepeatStatus.FINISHED == result) {
            return true;
        }

        return isComplete(context);
    }

    @Override
    public boolean isComplete(RepeatContext context) {
        return this.totalProcessed >= chunkSize;
    }

    @Override
    public RepeatContext start(RepeatContext parent) {
        this.chunkSize = ThreadLocalRandom.current().nextInt(20);
        this.totalProcessed = 0;

        System.out.println("The chunk size has been set to " + this.chunkSize);

        return parent;
    }

    @Override
    public void update(RepeatContext context) {
        this.totalProcessed++;
    }
}
