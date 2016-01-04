package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class RearrangeArrayElementImportant implements IAlgorithm
{

    private static Logger log = Logger.getLogger(RearrangeArrayElementImportant.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("RearrangeArrayElementImportant.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("RearrangeArrayElementImportant.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

//        1) Increase every array element arr[i] by (arr[arr[i]] % n)*n.
//        2) Divide every element by n.

        for (int i=0; i<inputData.size(); i++) {

            inputData.set(i, inputData.get(i) + (inputData.get(inputData.get(i))%inputData.size())*inputData.size());
        }

        for (int i=0; i<inputData.size(); i++) {

            inputData.set(i, inputData.get(i)/inputData.size());
        }

        return inputData.toString();
    }

}
