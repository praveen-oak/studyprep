package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SumOfPairAsX implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SumOfPairAsX.class);

    private static final String SUM_KEY = "sum";

    private static final String NO_RESULT = "No pair found !!";

    private List<Integer> inputData;

    private int sum;

    public SumOfPairAsX() {

        inputData = new ArrayList<Integer>();
    }

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SumOfPairAsX.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject inputJson) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(inputJson.getString(ResponseKeys.INPUT));
            sum = inputJson.getInt(SUM_KEY);

        } catch (Exception e) {

            log.error("SumOfPairAsX.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        Collections.sort(inputData);
        List <String> pairs = new LinkedList<String>();
        int start = 0;
        int end = inputData.size() - 1;

        while (start < end) {

            if (inputData.get(start) + inputData.get(end) == sum) {

                String pair = "(" + inputData.get(start).toString() + "," + inputData.get(end) + ")";
                pairs.add(pair);

                start++;
                end--;

            } else if (inputData.get(start) + inputData.get(end) > sum) {

                end--;
            } else {

                start ++;
            }
        }

        return pairs.size() == 0 ? NO_RESULT : pairs.toString();
    }

}
