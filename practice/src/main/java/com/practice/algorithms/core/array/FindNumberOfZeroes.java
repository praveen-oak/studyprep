package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class FindNumberOfZeroes implements IAlgorithm
{

    private static Logger log = Logger.getLogger(FindNumberOfZeroes.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("FindNumberOfZeroes.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("FindNumberOfZeroes.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int firstOccurringIndexOfZero = findFirstOccurringIndexOfZero(0, inputData.size()-1);

        return firstOccurringIndexOfZero == -1 ? 0 : inputData.size()-firstOccurringIndexOfZero;
    }

    private int findFirstOccurringIndexOfZero(int startIndex, int endIndex) {

        if (startIndex > endIndex) {

            return -1;
        }
        int midIndex = (startIndex + endIndex)/2;

        if (midIndex == 0 && inputData.get(midIndex) == 0) {

            return midIndex;
        }

        if (inputData.get(midIndex) == 0 && inputData.get(midIndex-1) != 0) {

            return midIndex;
        } else if (inputData.get(midIndex) == 1) {

            return findFirstOccurringIndexOfZero(midIndex+1, endIndex);
        } else {

            return findFirstOccurringIndexOfZero(startIndex, midIndex-1);
        }

    }

}
