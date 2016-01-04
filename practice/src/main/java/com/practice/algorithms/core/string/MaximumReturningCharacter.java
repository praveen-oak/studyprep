package com.practice.algorithms.core.string;

import com.practice.algorithms.constants.CommonKeys;
import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class MaximumReturningCharacter implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MaximumReturningCharacter.class);

    private String inputString;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaximumReturningCharacter.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputString = input.getString(ResponseKeys.INPUT);

        } catch (Exception e) {

            log.error("MaximumReturningCharacter.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int ascTwoHash[] = new int[CommonKeys.ASC_TWO_CHARACTERS];
        int maxCountIndex = 0;

        for (int i=0; i<inputString.length(); i++) {

            ascTwoHash[inputString.charAt(i)] += 1;
        }

        for (int i=1; i<ascTwoHash.length; i++) {

            if (ascTwoHash[i] > ascTwoHash[maxCountIndex]) maxCountIndex = i;
        }

        log.info(ascTwoHash[maxCountIndex] + "  ->  " + maxCountIndex);
        log.info((char)65);
        log.info((char)maxCountIndex);

        char maxOccurringChar = (char)maxCountIndex;

        return "Max Occurring Char: " + Character.toString(maxOccurringChar);

    }
}
