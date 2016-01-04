package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class EquilibriumIndex implements IAlgorithm
{

    private static Logger log = Logger.getLogger(EquilibriumIndex.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("EquilibriumIndex.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("EquilibriumIndex.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int sum = getSum();
        int leftSum = 0;

        String equilibriumIndexes = "Equilibrium Indexes: ";

        for (int i=0; i<inputData.size(); i++) {

            if (sum - leftSum - inputData.get(i) == leftSum) {

                equilibriumIndexes += i + " -> ";
            }

            leftSum += inputData.get(i);
        }

        return equilibriumIndexes;
    }

    private int getSum() {

        int sum = 0;

        for (int data : inputData) {

            sum += data;
        }

        return sum;

    }

}
