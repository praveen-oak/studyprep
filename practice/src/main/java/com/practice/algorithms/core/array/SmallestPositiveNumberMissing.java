package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class SmallestPositiveNumberMissing implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SmallestPositiveNumberMissing.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SmallestPositiveNumberMissing.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("SmallestPositiveNumberMissing.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int i=0;
        int missingNumber = -1;
        segregatePositiveAndNegativeElements();

        while (inputData.get(i) < 0) {

            inputData.set(i, -inputData.get(i));
            i++;
        }

        while (i < inputData.size()) {

            if (Math.abs(inputData.get(i)) < inputData.size() && inputData.get(i) != 0 ) {

                inputData.set(Math.abs(inputData.get(i)), -inputData.get(Math.abs(inputData.get(i))));
            }

            i++;
        }

        for (i=1; i<inputData.size(); i++) {

            if (inputData.get(i) > 0) {

                missingNumber = i;
                break;
            }
        }

        return missingNumber;
    }

    private void segregatePositiveAndNegativeElements() {

        int negativeIndex = 0;
        int temp;

        for (int i=0; i<inputData.size(); i++) {

            if (inputData.get(i) < 0) {

                temp = inputData.get(i);
                inputData.set(i, inputData.get(negativeIndex));
                inputData.set(negativeIndex, temp);

                negativeIndex++;

            }
        }
    }

}
