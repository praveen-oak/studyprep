package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class TwoRepeatingElements implements IAlgorithm
{

    private static Logger log = Logger.getLogger(TwoRepeatingElements.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("TwoRepeatingElements.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("TwoRepeatingElements.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        String reps = "";
        Integer[] array = inputData.toArray(new Integer[inputData.size()]);

        for (int i=0; i<inputData.size(); i++) {

            if (array[Math.abs(inputData.get(i))] > 0 ) {

                array[Math.abs(inputData.get(i))] =  array[i]*-1;
            } else {

                reps += array[Math.abs(inputData.get(i))] + " -> ";
            }
        }

        return reps;
    }

}
