package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MajorityElementInSortedArray implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MajorityElementInSortedArray.class);

    private List<Integer> inputData;

    private int majorityElement;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputData.toString() + " - MajorityElement: " + majorityElement);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MajorityElementInSortedArray.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));
            majorityElement = input.getInt("majorityElement");

        } catch (Exception e) {

            log.error("MajorityElementInSortedArray.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int firstIndex = firstOccurringIndex(0, inputData.size()-1);
        int lastIndex = lastOccurringIndex(0, inputData.size()-1);

        return lastIndex - firstIndex + 1 > inputData.size()/2 ? "True" : "False";
    }

    private int firstOccurringIndex(int start, int end) {

        int mid = (start + end)/2;

        if (inputData.get(mid) > majorityElement) {

            return firstOccurringIndex(start, mid-1);

        } else if (inputData.get(mid) < majorityElement) {

            return firstOccurringIndex(mid+1, end);

        } else {

            if (mid == 0) {

                return mid;

            } else if (inputData.get(mid-1) != majorityElement) {

                return mid;

            } else {

                return firstOccurringIndex(start, mid-1);
            }
        }
    }

    private int lastOccurringIndex(int start, int end) {

        int mid = (start + end)/2;

        if (inputData.get(mid) > majorityElement) {

            return lastOccurringIndex(start, mid-1);

        } else if (inputData.get(mid) < majorityElement) {

            return lastOccurringIndex(mid+1, end);

        } else {

            if (mid == inputData.size()-1) {

                return mid;

            } else if (inputData.get(mid+1) != majorityElement) {

                return mid;

            } else {

                return lastOccurringIndex(mid+1, end);
            }
        }
    }

}
