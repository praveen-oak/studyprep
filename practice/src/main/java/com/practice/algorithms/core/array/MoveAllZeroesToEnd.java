package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MoveAllZeroesToEnd implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MoveAllZeroesToEnd.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MoveAllZeroesToEnd.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("MoveAllZeroesToEnd.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int fillIndex = 0;
        for (int i=0; i<inputData.size(); i++) {

            if (inputData.get(i) != 0) {

                inputData.set(fillIndex, inputData.get(i));
                fillIndex++;
            }
        }

        while (fillIndex < inputData.size()) {

            inputData.set(fillIndex, 0);
            fillIndex++;
        }

        return inputData.toString();
    }
}