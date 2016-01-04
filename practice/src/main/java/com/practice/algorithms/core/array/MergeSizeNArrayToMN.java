package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MergeSizeNArrayToMN implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MergeSizeNArrayToMN.class);

    private static final String EMPTY_ELEMENT = "emptyElement";

    private List<Integer> inputDataN;

    private List<Integer> inputDataMN;

    private int emptyElement;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MajorityElement.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject inputJson) {

        try {

            JSONObject input = inputJson.getJSONObject(ResponseKeys.INPUT);

            inputDataN = CommonHelper.convertIntegerStringToList(input.getString("ArrayN"));
            inputDataMN = CommonHelper.convertIntegerStringToList(input.getString("ArrayMN"));
            emptyElement = inputJson.getInt(EMPTY_ELEMENT);
            inputJson.put(ResponseKeys.INPUT, inputDataN.toString() + " - " + inputDataMN.toString());

        } catch (Exception e) {

            log.error("MajorityElement.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        segregateEmptySpaces();

        int mIndex = inputDataN.size();
        int nIndex = 0;
        int mnIndex = 0;

        while (mIndex < inputDataMN.size() && nIndex < inputDataN.size()) {

            if (inputDataMN.get(mIndex) <= inputDataN.get(nIndex)) {

                inputDataMN.set(mnIndex, inputDataMN.get(mIndex));
                mIndex++;

            } else {

                inputDataMN.set(mnIndex, inputDataN.get(nIndex));
                nIndex++;
            }

            mnIndex++;
        }

        if (mIndex < inputDataMN.size()) {

            while (mIndex < inputDataMN.size()) {

                inputDataMN.set(mnIndex, inputDataMN.get(mIndex));
                mIndex++;
                mnIndex++;
            }

        } else if (nIndex < inputDataN.size()) {

            while (nIndex < inputDataN.size()) {

                inputDataMN.set(mnIndex, inputDataN.get(nIndex));
                nIndex++;
                mnIndex++;
            }

        }

        return inputDataMN.toString();
    }

    private void segregateEmptySpaces() {

        int reverseItr = inputDataMN.size()-1;
        int swapIndex = reverseItr;

        while (reverseItr >= 0) {

            if (inputDataMN.get(reverseItr) != emptyElement) {

                swap(reverseItr, swapIndex);
                swapIndex--;
            }

            reverseItr--;
        }

    }

    private void swap(int indexX, int indexY) {

        int temp = inputDataMN.get(indexX);

        inputDataMN.set(indexX, inputDataMN.get(indexY));
        inputDataMN.set(indexY, temp);

    }

}
