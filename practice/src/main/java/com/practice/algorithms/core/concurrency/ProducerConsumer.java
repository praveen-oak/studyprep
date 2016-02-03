package com.practice.algorithms.core.concurrency;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IConcurrency;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer implements IConcurrency
{

    private static Logger log = Logger.getLogger(ProducerConsumer.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runThreading());

        } catch (Exception e) {

            log.error("ThreadTest.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runThreading() {

        Thread mainThread = Thread.currentThread();
        log.info("ThreadTest.runThreading  -  Running thread: " + mainThread.getName());

        BlockQueue queue = new BlockQueue(5);

        Thread producer = new Thread(new Producer(queue), "<<< Producer >>>");
        Thread consumer = new Thread(new Consumer(queue), "< Consumer >");

        producer.start();
        consumer.start();

        return "Thread testing done successfully !!";
    }

    private class Producer implements Runnable
    {

        private BlockQueue queue;

        public Producer(BlockQueue queue) {

            this.queue = queue;
        }
        @Override
        public void run() {

            for (int i=0; i<50; i++) {

                queue.enQueue(i);
            }
        }
    }

    private class Consumer implements Runnable
    {

        private BlockQueue queue;

        public Consumer(BlockQueue queue) {

            this.queue = queue;
        }
        @Override
        public void run() {

            for (int i=0; i<50; i++) {

                queue.deQueue();
            }
        }
    }

    private class BlockQueue
    {

        private List<Integer> blockQueue;
        private int limit;

        public BlockQueue(int size) {

            blockQueue = new ArrayList<Integer>(size);
            limit = size;
        }

        public synchronized void enQueue(int data) {

            while (blockQueue.size() == limit) {
                try {
                    log.info("BlockQueue.enQueue  -  Queue is full, waiting for consumer to consume data !!");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (blockQueue.size() == 0) notifyAll();

            Thread mainThread = Thread.currentThread();

            log.info("BlockQueue.enQueue  -  Enqueue Data: " + data + "  -  " + mainThread.getName());

            blockQueue.add(data);
        }

        public synchronized int deQueue() {

            while (blockQueue.size() == 0) {
                try {
                    log.info("BlockQueue.deQueue  -  Queue is empty, waiting for producer to produce more data !!");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (blockQueue.size() == limit) notifyAll();

            Thread mainThread = Thread.currentThread();
            int data = blockQueue.remove(blockQueue.size() - 1);

            log.info("BlockQueue.enQueue  -  Dequeue Data: " + data + "  -  " + mainThread.getName());

            return data;
        }

    }

}