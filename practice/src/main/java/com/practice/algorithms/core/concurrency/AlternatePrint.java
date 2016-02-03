package com.practice.algorithms.core.concurrency;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IConcurrency;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class AlternatePrint implements IConcurrency
{

    private static Logger log = Logger.getLogger(AlternatePrint.class);

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

    private class MyThreadRunnable implements Runnable {

        private int limit;
        private int counter;
        private Sequence sequence;

        public MyThreadRunnable(Sequence sequence, int limit, int start) {

            this.limit = limit;
            this.counter = start;
            this.sequence = sequence;
        }

        @Override
        public void run() {

            while (counter <= limit) {

                if (counter%2 == 0) sequence.printEven(counter);
                else sequence.printOdd(counter);

                counter += 2;
            }
        }

    }

    private class Sequence
    {

        private boolean isOdd;

        public Sequence() {

            isOdd = false;

        }

        public synchronized  void printEven(int data) {

            while (!isOdd) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            Thread thread = Thread.currentThread();
            log.info("Sequence.printEven  -  Running thread: " + thread.getName() + "  -  counter: " + data);
            isOdd = !isOdd;
            notifyAll();
        }

        public synchronized void printOdd(int data) {

            while (isOdd) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }

            Thread thread = Thread.currentThread();
            log.info("Sequence.printOdd  -  Running thread: " + thread.getName() + "  -  counter: " + data);
            isOdd = !isOdd;
            notifyAll();
        }

    }

    private String runThreading() {

        Thread mainThread = Thread.currentThread();
        log.info("ThreadTest.runThreading  -  Running thread: " + mainThread.getName());

        int limit = 20;
        Sequence sequence = new Sequence();
        Thread runnableThreadOne = new Thread(new MyThreadRunnable(sequence, limit, 1), "< MyThreadRunnable----One >");
        Thread runnableThreadTwo = new Thread(new MyThreadRunnable(sequence, limit, 2), "< MyThreadRunnable-Two >");
        runnableThreadOne.setPriority(6);
        runnableThreadOne.start();
        runnableThreadTwo.start();
        log.info("MainThreadPriority ------->> " + mainThread.getPriority());
        log.info("ThreadOnePriority ------->> " + runnableThreadOne.getPriority());
        log.info("ThreadTwoPriority ------->> " + runnableThreadTwo.getPriority());

        try {
            log.info("-------------->> Hulahoo !!");
            runnableThreadOne.join();
            log.info("-------------->> Hulahooooo< !!");
            runnableThreadTwo.join();
            log.info("-------------->> Hulahooooooooo> !!");
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return "Thread testing done successfully !!";
    }

}
