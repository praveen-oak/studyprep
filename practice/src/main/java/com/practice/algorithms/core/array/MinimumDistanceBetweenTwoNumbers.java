package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MinimumDistanceBetweenTwoNumbers implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MinimumDistanceBetweenTwoNumbers.class);

    private static int NULL = -111111;

    private List<Integer> inputData;

    private int x;

    private int y;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MinimumDistanceBetweenTwoNumbers.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));
            x = input.getInt("x");
            y = input.getInt("y");

        } catch (Exception e) {

            log.error("MinimumDistanceBetweenTwoNumbers.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int minDistance = 111111;
        int tmpMin = -1;
        int lastIndex = NULL;

        for (int i=0; i<inputData.size(); i++) {

            if (inputData.get(i) == x || inputData.get(i) == y) {

                if (lastIndex != NULL) {

                    if (inputData.get(i) != inputData.get(lastIndex)) {

                        tmpMin = i-lastIndex;
                        if (tmpMin < minDistance) {
                            minDistance = tmpMin;
                        }

                    }
                }
                lastIndex = i;
            }

        }

        return minDistance;
    }

}
