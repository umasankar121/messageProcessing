package org.umasankar.jpmsample.client;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

/**
 * Created by Umasankar on 7/23/17.
 */
public class MessageProducer<T> {

    private BlockingQueue<T> queue;

    private int sleepTime;

    public MessageProducer(BlockingQueue<T> queue) {
        this(queue, 1000);
    }

    public MessageProducer(BlockingQueue<T> queue, int sleepTime) {
        this.queue = queue;
        this.sleepTime = sleepTime;
    }

    public void produce(Supplier<T> supplier) {
        final T message = supplier.get();
        try {
            queue.put(message);
            MILLISECONDS.sleep(this.sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
