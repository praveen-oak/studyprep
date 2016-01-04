package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MaxLengthBitonicSubArray implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MaxLengthBitonicSubArray.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaxLengthBitonicSubArray.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("MaxLengthBitonicSubArray.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int minLengthArray[] = getMinLengthArray();
        int maxLengthArray[] = getMaxLengthArray();
        int maxLength = -1;

        for (int i=0; i<inputData.size(); i++) {

            if (minLengthArray[i] + maxLengthArray[i] - 1 > maxLength) {

                maxLength = minLengthArray[i] + maxLengthArray[i] - 1;
            }
        }

        return maxLength;
    }

    private int[] getMinLengthArray() {

        int minLengthArray[] = new int[inputData.size()];
        minLengthArray[0] = 1;

        for (int i=1; i<inputData.size(); i++) {

            if (inputData.get(i-1) < inputData.get(i)) {

                minLengthArray[i] = minLengthArray[i-1] + 1;
            } else {

                minLengthArray[i] = 1;
            }
        }

        return minLengthArray;
    }

    private int[] getMaxLengthArray() {

        int maxLengthArray[] = new int[inputData.size()];
        maxLengthArray[inputData.size()-1] = 1;

        for (int i=inputData.size()-2; i>=0; i--) {

            if (inputData.get(i+1) < inputData.get(i)) {

                maxLengthArray[i] = maxLengthArray[i+1] + 1;
            } else {

                maxLengthArray[i] = 1;
            }
        }

        return maxLengthArray;
    }

}
