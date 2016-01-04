package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MaximumSumPath implements IAlgorithm {


    private static Logger log = Logger.getLogger(MaximumSumPath.class);

    private List<Integer> inputDataOne;

    private List<Integer> inputDataTwo;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputDataOne.toString() + ", " + inputDataTwo.toString());
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaximumSumPath.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {
            JSONObject inputData = input.getJSONObject(ResponseKeys.INPUT);

            inputDataOne = CommonHelper.convertIntegerStringToList(inputData.getString("inputDataOne"));
            inputDataTwo = CommonHelper.convertIntegerStringToList(inputData.getString("inputDataTwo"));

        } catch (Exception e) {

            log.error("MaximumSumPath.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int inputOneIndex = 0;
        int inputTwoIndex = 0;
        int inputOneSum = 0;
        int inputTwoSum = 0;
        int maxSumPath = 0;


        while (inputOneIndex < inputDataOne.size() && inputTwoIndex < inputDataTwo.size()) {

            if (inputDataOne.get(inputOneIndex) < inputDataTwo.get(inputTwoIndex)) {

                inputOneSum += inputDataOne.get(inputOneIndex);
                inputOneIndex++;

            } else if (inputDataOne.get(inputOneIndex) > inputDataTwo.get(inputTwoIndex)) {

                inputTwoSum += inputDataTwo.get(inputTwoIndex);
                inputTwoIndex++;

            } else {

                while (inputDataOne.get(inputOneIndex) == inputDataTwo.get(inputTwoIndex)) {

                    inputOneSum += inputDataOne.get(inputOneIndex);
                    inputTwoSum += inputDataTwo.get(inputTwoIndex);

                    inputOneIndex++;
                    inputTwoIndex++;
                }

                maxSumPath += max(inputOneSum, inputTwoSum);

                inputOneSum = 0;
                inputTwoSum = 0;

            }

        }

        while (inputOneIndex < inputDataOne.size()) {

            inputOneSum += inputDataOne.get(inputOneIndex);
            inputOneIndex++;
        }

        while (inputTwoIndex < inputDataTwo.size()) {

            inputTwoSum += inputDataTwo.get(inputTwoIndex);
            inputTwoIndex++;
        }

        maxSumPath += max(inputOneSum, inputTwoSum);

        return maxSumPath == 0 ? "No maximum sum path found." : "Maximum sum path: " + maxSumPath;
    }

    private int max(int x, int y) {

        return x > y ? x : y;
    }

}
