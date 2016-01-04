package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class SubArrayWithGivenSumWithMinLength implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SubArrayWithGivenSumWithMinLength.class);

    private List<Integer> inputData;

    private int sum;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputData.toString() + "  -  Sum: " + sum);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SubArrayWithGivenSumWithMinLength.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));
            sum = input.getInt("sum");

        } catch (Exception e) {

            log.error("SubArrayWithGivenSumWithMinLength.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int start = 0;
        int end = 1;
        int currSum = inputData.get(0);
        int minLength = 10000000;

        while (end < inputData.size()) {

            if (currSum == sum) {

                if (end-start-1 < minLength) {

                    log.info("Start: " + inputData.get(start) + ", End: " + inputData.get(end-1));
                    minLength = end-start;
                }
                currSum -= inputData.get(start);
                start++;
                end++;

            } else if (currSum < sum) {

                currSum += inputData.get(end);
                end++;

            } else {

                while (currSum > sum && start < end-1) {

                    currSum -= inputData.get(start);
                    start++;
                }

            }

        }

        return minLength;
    }

}
