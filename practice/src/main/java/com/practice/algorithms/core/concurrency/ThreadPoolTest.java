package com.practice.algorithms.core.concurrency;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IConcurrency;
import com.practice.algorithms.core.concurrency.threadpool.ThreadPool;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class ThreadPoolTest implements IConcurrency
{

    private static Logger log = Logger.getLogger(ThreadPoolTest.class);

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

        ThreadPool threadPool = new ThreadPool(3, 5);

        for (int i=0; i<50; i++) {

            try {

                threadPool.execute(new MyThreadRunnable(i));
            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        try {

            threadPool.stop();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "Thread testing done successfully !!";
    }

    private class MyThreadRunnable implements Runnable {

        private int i;

        MyThreadRunnable(int i) {

            this.i = i;
        }

        @Override
        public void run() {

            Thread thread = Thread.currentThread();
            log.info("MyThreadRunnable.run  -  Running thread: " + i + " " + thread.getName());
        }

    }

}
