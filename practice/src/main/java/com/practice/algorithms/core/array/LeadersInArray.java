package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class LeadersInArray implements IAlgorithm{

    private static Logger log = Logger.getLogger(LeadersInArray.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("LeadersInArray.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("LeadersInArray.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        String leaders = "Leaders: " + inputData.get(inputData.size()-1).toString();
        int leader = inputData.get(inputData.size()-1);
        if (inputData.size() > 1) {

            for (int i=inputData.size()-2; i>=0; i--) {

                if (inputData.get(i) > leader) {

                    leader = inputData.get(i);
                    leaders += ", " + leader;

                }
            }
        }

        return leaders;
    }
}
