package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class CommonElementsInThreeSortedArrays implements IAlgorithm
{

    private static Logger log = Logger.getLogger(CommonElementsInThreeSortedArrays.class);

    private List<Integer> inputDataOne;

    private List<Integer> inputDataTwo;

    private List<Integer> inputDataThree;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputDataOne.toString() + " " + inputDataTwo.toString() + " " + inputDataThree.toString());
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("CommonElementsInThreeSortedArrays.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            JSONObject inputData = input.getJSONObject(ResponseKeys.INPUT);

            inputDataOne = CommonHelper.convertIntegerStringToList(inputData.getString("inputDataOne"));
            inputDataTwo = CommonHelper.convertIntegerStringToList(inputData.getString("inputDataTwo"));
            inputDataThree = CommonHelper.convertIntegerStringToList(inputData.getString("inputDataThree"));

        } catch (Exception e) {

            log.error("CommonElementsInThreeSortedArrays.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int inputDataOneIndex = 0;
        int inputDataTwoIndex = 0;
        int inputDataThreeIndex = 0;

        String result = "";

        while (inputDataOneIndex < inputDataOne.size() && inputDataTwoIndex < inputDataTwo.size() &&
                inputDataThreeIndex < inputDataThree.size()) {

            if (inputDataOne.get(inputDataOneIndex) == inputDataTwo.get(inputDataTwoIndex) &&
                    inputDataOne.get(inputDataOneIndex) == inputDataThree.get(inputDataThreeIndex)) {

                result += inputDataOne.get(inputDataOneIndex) + " -> ";
                inputDataOneIndex++;
                inputDataTwoIndex++;
                inputDataThreeIndex++;

            } else if (inputDataOne.get(inputDataOneIndex) < inputDataTwo.get(inputDataTwoIndex)) {

                inputDataOneIndex++;

            } else if (inputDataTwo.get(inputDataTwoIndex) < inputDataThree.get(inputDataThreeIndex)) {

                inputDataTwoIndex++;

            } else {

                inputDataThreeIndex++;
            }

        }

        return result;
    }
}
