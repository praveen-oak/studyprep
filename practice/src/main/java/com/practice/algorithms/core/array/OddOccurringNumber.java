package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class OddOccurringNumber implements IAlgorithm
{

    private static Logger log = Logger.getLogger(OddOccurringNumber.class);

    private static final String NO_RESULT = "No odd occurring number found !!";

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("OddOccurringNumber.run  -  Exception in running algorithm", e);
        }

        return input.toString();

    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("OddOccurringNumber.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        Integer oddOccurringNumber = 0;

        for (int number : inputData) {

            oddOccurringNumber ^= number;
        }

        return oddOccurringNumber == 0 ? NO_RESULT : oddOccurringNumber.toString();
    }
}
