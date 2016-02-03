package com.practice.algorithms.core.concurrency;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IConcurrency;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class ThreadTest implements IConcurrency
{

    private static Logger log = Logger.getLogger(ThreadTest.class);

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

    private class MyThread extends Thread {

        private Counter counter;

        public MyThread(String threadName, Counter counter) {

            super(threadName);
            this.counter = counter;

        }

        @Override
        public void run() {

            Thread thread = Thread.currentThread();
            log.info("MyThread.run  -  Running thread: " + thread.getName());
        }

        public void check() {

            Thread thread = Thread.currentThread();
            log.info("MyThreadRunnable.check  -  Running thread: " + thread.getName());
        }
    }

    private class MyThreadRunnable implements Runnable {


        private Counter counter;

        public MyThreadRunnable(Counter counter) {

            this.counter = counter;
        }

        @Override
        public void run() {

//            Thread thread = Thread.currentThread();
//            log.info("MyThreadRunnable.run  -  Running thread: " + thread.getName());

            for (int i=0; i<40; i++) {

                counter.increment(1);
            }
        }

    }

    private class Counter {

        private int counter;

        public Counter() {
            counter = 0;
        }

        public void increment(int value) {

            Thread thread = Thread.currentThread();
            int oldCounter = counter;

            counter += value;
            log.info("Counter.increment  -  Running thread: " + thread.getName() + "  -  oldCounter: "  +
                    oldCounter + "  -  incrementedValue: " + value + "  -  newCounter: " + counter);

        }

        public int getCounter() {

            return counter;
        }

    }

    private String runThreading() {

        Thread mainThread = Thread.currentThread();
        log.info("ThreadTest.runThreading  -  Running thread: " + mainThread.getName());

        Counter counter = new Counter();

//        MyThread thread = new MyThread("< MyThread >", counter);
//        thread.start();
//        thread.check();

        Thread runnableThreadOne = new Thread(new MyThreadRunnable(counter), "< MyThreadRunnable----One >");
        Thread runnableThreadTwo = new Thread(new MyThreadRunnable(counter), "< MyThreadRunnable-Two >");

        runnableThreadOne.start();
        runnableThreadTwo.start();

        return "Thread testing done successfully !!";
    }

}
