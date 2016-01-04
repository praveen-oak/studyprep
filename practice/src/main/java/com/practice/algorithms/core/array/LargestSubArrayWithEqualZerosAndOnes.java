package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LargestSubArrayWithEqualZerosAndOnes implements IAlgorithm
{

    private static Logger log = Logger.getLogger(LargestSubArrayWithEqualZerosAndOnes.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("LargestSubArrayWithEqualZerosAndOnes.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("LargestSubArrayWithEqualZerosAndOnes.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int leftSum[] = getLeftSum();
        int maxZeroSumIndex = getMaxZeroSumIndex(leftSum);

        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
        int maxLengthIndex = -1;
        int maxLength = -1;
        int startIndex, endIndex;

        for (int i=1; i<leftSum.length; i++) {

            if (hash.containsKey(leftSum[i])) {

                List<Integer> list = hash.get(leftSum[i]);
                hash.get(leftSum[i]).add(i);

                if (maxLength < i - list.get(0)) {

                    maxLength = i - list.get(0);
                    maxLengthIndex = leftSum[i];
                }

            } else {

                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                hash.put(leftSum[i], list);

            }
        }

        if (inputData.get(hash.get(maxLengthIndex).get(0)) == 1) {

            startIndex = hash.get(maxLengthIndex).get(0) - 1;
            endIndex = hash.get(maxLengthIndex).get(hash.get(maxLengthIndex).size()-1);
        } else {

            startIndex = hash.get(maxLengthIndex).get(0);
            endIndex = hash.get(maxLengthIndex).get(hash.get(maxLengthIndex).size()-1) + 1;
        }

        if (maxLength+1 > maxZeroSumIndex) {

            return "Index: (" + startIndex + ", " + endIndex + ")";
        } else {

            return "Index: (" + 0 + ", " + maxZeroSumIndex + ")";
        }

    }

    private int[] getLeftSum() {

        int leftSum[] = new int[inputData.size()];
        leftSum[0] = inputData.get(0) == 0 ? -1 : 1;

        for (int i=1; i<inputData.size(); i++) {

            int value = inputData.get(i) == 0 ? -1 : 1;
            leftSum[i] = leftSum[i-1] + value;
        }

        return leftSum;
    }

    private int getMaxZeroSumIndex(int leftSum[]) {

        int maxZeroSumIndex = 0;

        for (int i=0; i<leftSum.length; i++) {

            if (leftSum[i] == 0) {

                maxZeroSumIndex = i;
            }
        }

        return maxZeroSumIndex;
    }

}
