package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class LengthOfLargestSubArrayWithContiguousElements implements IAlgorithm
{

    private static Logger log = Logger.getLogger(LengthOfLargestSubArrayWithContiguousElements.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("LengthOfLargestSubArrayWithContiguousElements.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("LengthOfLargestSubArrayWithContiguousElements.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int maxLength = 0;

        for (int i=0; i<inputData.size()-1; i++) {

            int maxElement = inputData.get(i);
            int minElement = inputData.get(i);

            for (int j=i+1; j<inputData.size(); j++) {

                minElement = min(minElement, inputData.get(j));
                maxElement = max(maxElement, inputData.get(j));

                if (maxElement-minElement == j-i && maxElement-minElement+1 > maxLength) {

                    maxLength = maxElement-minElement+1;
                }
            }
        }

        return maxLength;
    }

    private int min(int x, int y) {

        return x<y ? x:y;
    }

    private int max(int x, int y) {

        return x>y ? x:y;
    }

}
