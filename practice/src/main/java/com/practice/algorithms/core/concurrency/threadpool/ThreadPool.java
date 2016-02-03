package com.practice.algorithms.core.concurrency.threadpool;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.util.List;

public class ThreadPool
{

    private static Logger log = Logger.getLogger(ThreadPool.class);

    private BlockingQueue taskQueue = null;

    private List<PoolThread> threads;

    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks) {

        threads = new LinkedList<PoolThread>();
        taskQueue = new LinkedBlockingQueue(maxNoOfTasks);

        for (int i=0; i<noOfThreads; i++) {

            threads.add(new PoolThread(taskQueue));
        }

        for (PoolThread thread : threads) {

            thread.start();
        }

    }

    public synchronized void  execute(Runnable task) throws Exception{

        if (isStopped) {

            log.info("ThreadPool.execute  -  Illegal state exception !!");
            throw new IllegalStateException("ThreadPool is stopped");
        }

        taskQueue.add(task);
    }

    public synchronized void stop() throws Exception {

        if (isStopped) {

            log.info("ThreadPool.execute  -  Illegal state exception !!");
            throw new IllegalStateException("ThreadPool is stopped");
        }

        for (PoolThread thread : threads) {

            thread.doStop();
        }

        isStopped = true;
    }

}
