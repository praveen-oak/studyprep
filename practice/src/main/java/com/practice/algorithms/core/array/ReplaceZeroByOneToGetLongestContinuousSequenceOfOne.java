package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class ReplaceZeroByOneToGetLongestContinuousSequenceOfOne implements IAlgorithm
{

    private static Logger log = Logger.getLogger(ReplaceZeroByOneToGetLongestContinuousSequenceOfOne.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ReplaceZeroByOneToGetLongestContinuousSequenceOfOne.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("ReplaceZeroByOneToGetLongestContinuousSequenceOfOne.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int prvZeroIndex = -1;
        int prvToPrvZeroIndex = -1;
        int maxLength = -1;

        for (int i=0; i<inputData.size(); i++) {

            if (inputData.get(i) == 0) {

                if (prvZeroIndex == -1) {

                    prvZeroIndex = i;

                } else if (prvToPrvZeroIndex == -1) {

                    prvToPrvZeroIndex = prvZeroIndex;
                    prvZeroIndex = i;

                } else {

                    if (maxLength < i-prvToPrvZeroIndex-1) {

                        maxLength = i - prvToPrvZeroIndex -1;
                    }

                    prvToPrvZeroIndex = prvZeroIndex;
                    prvZeroIndex = i;
                }

            }
        }

        return prvZeroIndex;
    }

}
