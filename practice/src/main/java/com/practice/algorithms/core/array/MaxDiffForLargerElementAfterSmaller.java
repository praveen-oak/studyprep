package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MaxDiffForLargerElementAfterSmaller implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SegregateZeroesAndOnes.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaxDiffForLargerElementAfterSmaller.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("MaxDiffForLargerElementAfterSmaller.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int maxDiff = inputData.get(1) - inputData.get(0);
        int minElementIndex = 0;

        for (int i=1; i<inputData.size(); i++) {

            if (inputData.get(i) - inputData.get(minElementIndex) > maxDiff) {

                maxDiff = inputData.get(i) - inputData.get(minElementIndex);
            }

            if (inputData.get(i) < inputData.get(minElementIndex)) {

                minElementIndex = i;
            }

        }

        return maxDiff;
    }

}
