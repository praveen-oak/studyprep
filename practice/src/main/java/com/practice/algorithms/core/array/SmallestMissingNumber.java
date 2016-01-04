package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class SmallestMissingNumber implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SmallestMissingNumber.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SmallestMissingNumber.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("SmallestMissingNumber.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        return forDuplicates();
//        return forNonDuplicates();
    }

    private int forDuplicates() {

        if (inputData.get(0) != 0) {

            return 0;
        }

        for (int i=1; i<inputData.size(); i++) {

            if (inputData.get(i) - inputData.get(i-1) > 1) {

                return i;
            }
        }

        return -1;
    }

    private int forNonDuplicates() {

        if (inputData.get(0) != 0) {

            return 0;
        }

        return binarySearch(0, inputData.size()-1);
    }

    private int binarySearch(int start, int end) {

        if (inputData.get(start) != start) {

            return start;
        }

        if (start > end) {

            return end + 1;
        }

        int mid = (start+end)/2;

        if (mid < inputData.get(mid)) {

            return binarySearch(start, mid);
        } else {

            return binarySearch(mid+1, end);
        }
    }

}
