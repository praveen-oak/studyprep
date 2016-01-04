package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class TwoNumbersWithOddOccurrencesUnsortedArray implements IAlgorithm
{

    private static Logger log = Logger.getLogger(TwoNumbersWithOddOccurrencesUnsortedArray.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("TwoNumbersWithOddOccurrencesUnsortedArray.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("TwoNumbersWithOddOccurrencesUnsortedArray.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int x = 0;
        int y = 0;

        int xXorY = getXXorY();
        int rightMostSetBit = xXorY & ~(xXorY-1);

        for (int data : inputData) {

            if ((data & rightMostSetBit) != 0) {

                x ^= data;
            } else {

                y ^= data;
            }
        }

        return "(" + x + ", " + y + ")";
    }

    private int getXXorY() {

        int xXorY = 0;
        for (int data : inputData) {

            xXorY ^= data;
        }

        return xXorY;
    }

}
