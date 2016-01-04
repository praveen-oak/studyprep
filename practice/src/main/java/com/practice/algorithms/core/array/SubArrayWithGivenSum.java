package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class SubArrayWithGivenSum implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SubArrayWithGivenSum.class);

    private List<Integer> inputData;

    private int sum;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, "Input Array: " + inputData.toString() + "  -  Sum: " + sum);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SubArrayWithGivenSum.run  -  Exception in running algorithm", e);
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

            log.error("SubArrayWithGivenSum.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int curSum = inputData.get(0);
        int start = 0;
        int end = 0;

        String sumIndexPair = null;

        for (int i=1; i<inputData.size(); i++) {

            if (curSum > sum) {

                while (curSum > sum && start < i-1) {

                    curSum -= inputData.get(start);
                    start++;
                }
            }

            if (curSum == sum) {

                end = i-1;
                sumIndexPair = "Sum Index Pair: (" + start + ", " + end + ")";
                break;
            }

            curSum += inputData.get(i);

        }

        return sumIndexPair == null ? "No indexes found" : sumIndexPair;
    }

}
