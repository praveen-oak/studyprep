package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MajorityElement implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MajorityElement.class);

    private static final String NO_RESULT = "No majority element found !!";

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MajorityElement.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("MajorityElement.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int majorityIndex = 0;
        int majorityCount = 1;
        Integer majorityElement = null;

        for (int i=1; i<inputData.size(); i++) {

            if (inputData.get(i) == inputData.get(majorityIndex)) {

                majorityCount++;
            } else {

                majorityCount--;
            }

            if (majorityCount == 0) {

                majorityIndex = i;
                majorityCount = 1;
            }
        }

        if (majorityCount > 0) {

            majorityElement = justifyMajority(majorityIndex);
        }

        return majorityElement == null ? NO_RESULT : "Majority Element: " + majorityElement.toString();
    }

    private Integer justifyMajority(int majorityIndex) {

        int majorityCount = 0;
        int majorityThreshold = inputData.size()/2;

        for (int element : inputData) {

            if (element == inputData.get(majorityIndex)) {
                majorityCount++;
            }
        }

        return majorityCount > majorityThreshold ? majorityIndex : null;

    }

}
