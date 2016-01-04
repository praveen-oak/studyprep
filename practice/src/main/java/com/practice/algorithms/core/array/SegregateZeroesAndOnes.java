package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class SegregateZeroesAndOnes implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SegregateZeroesAndOnes.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SegregateZeroesAndOnes.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("SegregateZeroesAndOnes.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int start = 0;
        int end = inputData.size()-1;

        while (start < end) {

            if (inputData.get(start) == 1 && inputData.get(end) == 0) {

                swap(start, end);
                start++;
                end--;
            }

            if (inputData.get(start) == 0) {

                start++;
            }

            if (inputData.get(end) == 1) {

                end--;
            }

        }

        return inputData.toString();
    }

    private void swap(int xIndex, int yIndex) {

        int tmp = inputData.get(xIndex);

        inputData.set(xIndex, inputData.get(yIndex));
        inputData.set(yIndex, tmp);

    }

}
