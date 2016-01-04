package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class RearrangePositiveAndNegativeNumbers implements IAlgorithm
{

    private static Logger log = Logger.getLogger(RearrangePositiveAndNegativeNumbers.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("RearrangePositiveAndNegativeNumbers.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("RearrangePositiveAndNegativeNumbers.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        log.info(inputData.toString());
        segregatePositiveFromNegativeNumbers();
        log.info(inputData.toString());
        rearrangeAlternatively();

        return inputData.toString();
    }

    private void segregatePositiveFromNegativeNumbers() {

        int startIndex = 0;
        int endIndex = inputData.size()-1;

        while (startIndex < endIndex) {

            if (inputData.get(startIndex) > 0) startIndex++;
            if (inputData.get(endIndex) < 0) endIndex--;

            swap(startIndex, endIndex);
            startIndex++;
            endIndex--;
        }

    }

    private void swap(int indexOne, int indexTwo) {

        int tmp = inputData.get(indexOne);
        inputData.set(indexOne, inputData.get(indexTwo));
        inputData.set(indexTwo, tmp);

    }

    private void rearrangeAlternatively() {

        if (inputData.get(0) < 0) {

            return;
        }
        int positiveIndex = 1;
        int negativeIndex = getFirstNegativeIndex();

        if (negativeIndex == -1) {

            return;
        }

        while (negativeIndex < inputData.size() && inputData.get(positiveIndex) > 0 && positiveIndex < inputData.size()) {

            swap(positiveIndex, negativeIndex);
            positiveIndex += 2;
            negativeIndex++;
        }

    }

    private int getFirstNegativeIndex() {

        for (int i=0; i<inputData.size(); i++) {

            if (inputData.get(i) < 0) {

                return i;
            }
        }

        return -1;
    }
}
