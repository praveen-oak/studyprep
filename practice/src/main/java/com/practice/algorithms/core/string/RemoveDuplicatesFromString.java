package com.practice.algorithms.core.string;

import com.practice.algorithms.constants.CommonKeys;
import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class RemoveDuplicatesFromString implements IAlgorithm
{

    private static Logger log = Logger.getLogger(RemoveDuplicatesFromString.class);

    private String inputString;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("RemoveDuplicatesFromString.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputString = input.getString(ResponseKeys.INPUT);

        } catch (Exception e) {

            log.error("RemoveDuplicatesFromString.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int ascTwoHash[] = new int[CommonKeys.ASC_TWO_CHARACTERS];
        String result = "";

        for (int i=0; i<inputString.length(); i++) {

            if (ascTwoHash[inputString.charAt(i)] == 0) {

                result += Character.toString(inputString.charAt(i));
                ascTwoHash[inputString.charAt(i)] = 1;
            }
        }

        return result;
    }

}