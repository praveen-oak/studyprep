package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class SmallestPositiveIntegerCannotBeRepresentedAsSubsetSum implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SmallestPositiveIntegerCannotBeRepresentedAsSubsetSum.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SmallestPositiveIntegerCannotBeRepresentedAsSubsetSum.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("SmallestPositiveIntegerCannotBeRepresentedAsSubsetSum.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int res = 1;

        for (int i=0; i<inputData.size() && res >= inputData.get(i); i++) {

            res += inputData.get(i);
        }

        return res;
    }

}
