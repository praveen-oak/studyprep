package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class IncreasingSubSequenceOfLengthTreeWithMaxProduct implements IAlgorithm
{

    private static Logger log = Logger.getLogger(IncreasingSubSequenceOfLengthTreeWithMaxProduct.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("IncreasingSubSequenceOfLengthTreeWithMaxProduct.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("IncreasingSubSequenceOfLengthTreeWithMaxProduct.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

//        int minIndexArray[] = getMinIndexArray();
//        int maxIndexArray[] = getMaxIndexArray();
//
//        int maxProductIndex = -1;
//        int maxProduct = -111;
//        int product;
//        int maxLeftIndex;
//        int leftItr = -111;
//
//        log.info(inputData.toString());
//        String data = "";
//        for (int i=0; i<inputData.size(); i++) {
//
//            data += minIndexArray[i] + ", ";
//        }
//        log.info(data);
//        data = "";
//        for (int i=0; i<inputData.size(); i++) {
//
//            data += maxIndexArray[i] + ", ";
//        }
//        log.info(data);
//
//
//
//        for (int i=0; i<inputData.size(); i++) {
//
//            if (minIndexArray[i] != -1 && maxIndexArray[i] != -1) {
//                log.info("-----------------");
//                leftItr = minIndexArray[i];
//                while (leftItr < inputData.size() && leftItr < i) {
//
//
//                    if (inputData.get(leftItr) > inputData.get(minIndexArray[i])) {
//
//                        minIndexArray[i] = leftItr;
//                    }
//                    log.info("i: " + i + "  -  leftItr -->> " + leftItr  + "  -  leftMaxIndex: " + minIndexArray[i]);
//                    leftItr++;
//                }
//
//                product = inputData.get(minIndexArray[i])*inputData.get(i)*inputData.get(maxIndexArray[i]);
//                if (product > maxProduct) {
//
//                    maxProduct = product;
//                    maxProductIndex = i;
//                }
//
//            }
//
//        }
//
//        return maxProductIndex == -1 ? "No sub sequence found" : "Sub sequence: (" +
//                inputData.get(minIndexArray[maxProductIndex]) + ", " + inputData.get(maxProductIndex) + ", " +
//                inputData.get(maxIndexArray[maxProductIndex]) + ")";

        return "Solve it later";
    }

//    private int[] getMinIndexArray() {
//
//        int array[] = new int[inputData.size()];
//        int minIndex = 0;
//        array[0] = -1;
//
//        for (int i=1; i<inputData.size(); i++) {
//
//            if (inputData.get(i) < inputData.get(minIndex)) {
//
//                minIndex = i;
//                array[i] = -1;
//            } else {
//
//                array[i] = minIndex;
//            }
//        }
//
//        return array;
//    }
//
//    private int[] getMaxIndexArray() {
//
//        int array[] = new int[inputData.size()];
//        int maxIndex = inputData.size()-1;
//        array[inputData.size()-1] = -1;
//
//        for (int i=inputData.size()-2; i>=0; i--) {
//
//            if (inputData.get(i) > inputData.get(maxIndex)) {
//
//                maxIndex = i;
//                array[i] = -1;
//            } else {
//
//                array[i] = maxIndex;
//            }
//        }
//
//        return array;
//    }
}
