package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class NoTwoElementsAdjacentMaxSum implements IAlgorithm
{

    private static Logger log = Logger.getLogger(NoTwoElementsAdjacentMaxSum.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("NoTwoElementsAdjacentMaxSum.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("NoTwoElementsAdjacentMaxSum.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int maxInclSum = inputData.get(0);
        int maxExclSum = 0;
        int oldMaxInclSum = 0;

        for (int i=1; i<inputData.size(); i++) {

            oldMaxInclSum = maxInclSum;
            maxInclSum = inputData.get(i) + maxExclSum;
            maxExclSum = max(oldMaxInclSum, maxExclSum);
        }

        return max(maxInclSum, maxExclSum);
    }

    private int max(int x, int y) {

        return x > y ? x : y;
    }
}