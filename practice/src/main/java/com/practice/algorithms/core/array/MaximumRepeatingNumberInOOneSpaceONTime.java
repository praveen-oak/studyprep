package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MaximumRepeatingNumberInOOneSpaceONTime implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MaximumRepeatingNumberInOOneSpaceONTime.class);

    private List<Integer> inputData;

    private int k;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputData.toString() + " - K:" + k);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaximumRepeatingNumberInOOneSpaceONTime.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));
            k = input.getInt("k");

        } catch (Exception e) {

            log.error("MaximumRepeatingNumberInOOneSpaceONTime.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        log.info(inputData.toString());
        for (int i=0; i<inputData.size(); i++) {

            inputData.set(inputData.get(i)%k, inputData.get(inputData.get(i)%k) + k);
        }

        log.info(inputData.toString());
        int maxIndex = 0;
        for (int i=1; i<k; i++) {

            if (inputData.get(i) > inputData.get(maxIndex)) {

                maxIndex = i;
            }
        }

        for (int i=0; i<inputData.size(); i++) {

            inputData.set(inputData.get(i)%k, inputData.get(inputData.get(i)%k)%k);
        }
        log.info(inputData.toString());

        return "Maximum repeating element: " + maxIndex;
    }
}
