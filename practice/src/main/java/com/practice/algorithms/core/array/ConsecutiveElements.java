package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class ConsecutiveElements implements IAlgorithm
{

    private static Logger log = Logger.getLogger(ConsecutiveElements.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ConsecutiveElements.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("ConsecutiveElements.setInput  -  Exception in setting input", e);
        }

    }

    private boolean runAlgorithm() {

        int max = getMax();
        int min = getMin();
        int index = -1;

        if (max-min+1 > inputData.size()) {

            return false;
        }

        Integer[] array = inputData.toArray(new Integer[inputData.size()]);

        for (int i=0; i<inputData.size(); i++) {

            index = max - Math.abs(array[i]);

            if (array[index] > -1) {

                array[index] = array[index] * -1;
            } else {

                return false;
            }

        }

        return true;
    }

    private int getMax() {

        int max = -111111;

        for (int data: inputData) {

            if (max < data)  max = data;
        }
        return max;
    }

    private int getMin() {

        int min = 999999;

        for (int data: inputData) {

            if (min > data)  min = data;
        }
        return min;
    }

}
