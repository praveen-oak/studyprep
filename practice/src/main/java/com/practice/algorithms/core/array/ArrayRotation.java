package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class ArrayRotation implements IAlgorithm
{

    private static Logger log = Logger.getLogger(ArrayRotation.class);

    private static final String ROTATION_DELTA = "rotationDelta";

    private List<Integer> inputData;

    private int rotationDelta;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ArrayRotation.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));
            rotationDelta = input.getInt(ROTATION_DELTA)-1;

        } catch (Exception e) {

            log.error("ArrayRotation.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        if (rotationDelta < inputData.size()-1) {

            reverse(0, rotationDelta);
            reverse(rotationDelta+1, inputData.size()-1);
            reverse(0, inputData.size()-1);

        }

        return inputData.toString();
    }

    private void reverse(int start, int end) {

        while (start < end) {

            int tmp = inputData.get(start);
            inputData.set(start, inputData.get(end));
            inputData.set(end, tmp);

            start++;
            end--;
        }
    }

}
