package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.*;

public class MergeOverLappingIntervals implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MergeOverLappingIntervals.class);

    private List<Interval> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputData.toString());
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MergeOverLappingIntervals.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            JSONObject inputJson = input.getJSONObject(ResponseKeys.INPUT);
            List<Integer> xCoordinates = CommonHelper.convertIntegerStringToList(inputJson.getString("xCoordinates"));
            List<Integer> yCoordinates = CommonHelper.convertIntegerStringToList(inputJson.getString("yCoordinates"));

            inputData = new LinkedList<Interval>();

            for (int i=0; i<xCoordinates.size(); i++) {

                inputData.add(new Interval(xCoordinates.get(i), yCoordinates.get(i)));
            }

        } catch (Exception e) {

            log.error("MergeOverLappingIntervals.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        String mergedIntervals = "";

        Collections.sort(inputData, new IntervalComparator());

        Stack<Interval> stack = new Stack<Interval>();

        for (Interval interval : inputData) {

            if (stack.empty()) {

                stack.push(interval);
            } else {

                Interval topInterval = stack.peek();

                if (topInterval.y > interval.x && topInterval.y < interval.y) {

                    stack.pop();
                    topInterval.y = interval.y;
                    stack.push(topInterval);

                } else if (topInterval.y < interval.x){

                    stack.push(interval);
                }
            }
        }

        return stack.toString();

    }

    private void printIntervals() {

        String intervals = "";

        for (Interval interval : inputData) {

            intervals += "(" + interval.x + ", " + interval.y + ")  ";
        }

        log.info(intervals);
    }

    private class IntervalComparator implements Comparator<Interval>
    {

        @Override
        public int compare(Interval intervalOne, Interval intervalTwo) {

            return intervalOne.x - intervalTwo.x;
        }
    }

    private class Interval
    {

        public int x;
        public int y;

        Interval(int x, int y) {

            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

}
