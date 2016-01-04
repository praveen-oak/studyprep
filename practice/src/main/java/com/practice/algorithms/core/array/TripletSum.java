package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.Collections;
import java.util.List;

public class TripletSum implements IAlgorithm {

    private static Logger log = Logger.getLogger(TripletSum.class);

    private List<Integer> inputData;

    private int sum;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, "Input Array: " + inputData.toString() + "  -  Sum: " + sum);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("TripletSum.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            JSONObject inputJSon = input.getJSONObject(ResponseKeys.INPUT);

            inputData = CommonHelper.convertIntegerStringToList(inputJSon.getString("inputData"));
            sum = inputJSon.getInt("sum");

        } catch (Exception e) {

            log.error("TripletSum.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int y, z, tmpSum;
        String triplet = "No triplet found";

        Collections.sort(inputData);

        for (int x=0; x<inputData.size()-3; x++) {

            y = x+1;
            z = inputData.size()-1;

            while (y < z) {

                tmpSum = inputData.get(x) + inputData.get(y) + inputData.get(z);
                if (tmpSum == sum) {

                    triplet = "(" + inputData.get(x) + ", " + inputData.get(y) + ", " + inputData.get(z) + ")";
                    break;
                } else if (tmpSum < sum) {

                    y++;
                } else {

                    z--;
                }
            }
        }

        return triplet;
    }

}
