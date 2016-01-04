package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MaximumJMinusI implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MaximumJMinusI.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaximumJMinusI.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("MaximumJMinusI.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int minArray[] = getMinArray();
        int maxArray[] = getMaxArray();

        log.info(inputData.toString());
        String ar = "";
        for (int i=0; i<minArray.length; i++) {
            ar += minArray[i]+ ", ";
        }
        log.info(ar);
        ar = "";
        for (int i=0; i<maxArray.length; i++) {
            ar += maxArray[i]+ ", ";
        }
        log.info(ar);

        int maxDiff = -1;
        int i=0;
        int j=0;

        while (i<inputData.size() && j<inputData.size()) {
            log.info("--------------");
            log.info(j-i);
            log.info(maxDiff);
            log.info(i + " <-> " + j);
            if (minArray[i] < maxArray[j]) {

                log.info("1111");
                if (maxDiff < (j-i)) {
                    log.info("Hola");
                    maxDiff = j-i;
                }
                j++;
            } else {
                log.info("2222");
                i++;
            }
        }

        return maxDiff;
    }

    private int[] getMinArray() {

        int minArray[] = new int[inputData.size()];
        int min = inputData.get(0);

        minArray[0] = inputData.get(0);

        for (int i=1; i<inputData.size(); i++) {

            if (min > inputData.get(i)) {

                min = inputData.get(i);
            }

            minArray[i] = min;

        }

        return minArray;
    }

    private int[] getMaxArray() {

        int maxArray[] = new int[inputData.size()];
        int max = inputData.get(inputData.size()-1);

        maxArray[inputData.size()-1] = max;

        for (int i=inputData.size()-2; i>=0; i--) {

            if (max < inputData.get(i)) {

                max = inputData.get(i);
            }

            maxArray[i] = max;
        }

        return maxArray;
    }

}
