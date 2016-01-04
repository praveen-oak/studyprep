package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class LargestSumContiguousSubArray implements IAlgorithm
{

    private static Logger log = Logger.getLogger(LargestSumContiguousSubArray.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("LargestSumContiguousSubArray.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("LargestSumContiguousSubArray.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int maxSum = 0;
        int sum = 0;

        for (int data : inputData) {

            sum += data;
            if (sum < 0) {

                sum = 0;
            }

            if (sum > maxSum) {

                maxSum = sum;
            }
        }

        return maxSum;
    }

}