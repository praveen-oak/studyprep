package com.practice.algorithms.core.concurrency.threadpool;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread
{

    private BlockingQueue queue;

    private boolean isStopped = false;

    public PoolThread(BlockingQueue queue) {

        this.queue = queue;
    }

    public void run() {

        while (true) {

            try {

                Runnable task = (Runnable)queue.take();
                task.run();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void doStop(){

        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped(){

        return isStopped;
    }

}
