package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class SortedSubSequenceOfSizeThree implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SortedSubSequenceOfSizeThree.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SortedSubSequenceOfSizeThree.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("SortedSubSequenceOfSizeThree.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        String triplets = "";
        int leftSmallerArray[] = getLeftSmallerArray();
        int rightLargerArray[] = getRightLargerArray();

        for (int i=0; i<inputData.size(); i++) {

            if (leftSmallerArray[i] != -1 && rightLargerArray[i] != -1) {

                triplets += "(" + inputData.get(leftSmallerArray[i]) + ", " + inputData.get(i) + ", " +
                        inputData.get(rightLargerArray[i]) + ") ";
            }
        }

        return triplets == "" ? "No triplets found" : triplets;
    }

    private int[] getLeftSmallerArray() {

        int minIndex = 0;
        int leftSmallerArray[] = new int[inputData.size()];
        leftSmallerArray[minIndex] = -1;

        for (int i=1; i<inputData.size(); i++) {

            if (inputData.get(minIndex) > inputData.get(i)) {

                minIndex = i;
                leftSmallerArray[i] = -1;
            } else {

                leftSmallerArray[i] = minIndex;
            }
        }

        return leftSmallerArray;
    }

    private int[] getRightLargerArray() {

        int maxIndex = inputData.size()-1;
        int rightLargerArray[] = new int[inputData.size()];
        rightLargerArray[maxIndex] = -1;

        for(int i=maxIndex-1; i>=0; i--) {

            if (inputData.get(maxIndex) < inputData.get(i)) {

                maxIndex = i;
                rightLargerArray[i] = -1;
            } else {

                rightLargerArray[i] = maxIndex;
            }
        }

        return rightLargerArray;
    }

}
