package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MaximumCircularSubArraySum implements IAlgorithm
{


    private static Logger log = Logger.getLogger(MaximumCircularSubArraySum.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaximumCircularSubArraySum.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("MaximumCircularSubArraySum.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int[] array = ArrayUtils.toPrimitive(inputData.toArray(new Integer[inputData.size()]));
        int kadanesSum = getKadanesSum(array);
        int kadanesInvertedSum;
        int sum = getSum();

        array = getInvertedArray(array);
        kadanesInvertedSum = getKadanesSum(array);

        return kadanesSum > (sum+kadanesInvertedSum) ? kadanesSum : (sum+kadanesInvertedSum);
    }

    private int getKadanesSum(int array[]) {

        int sum = 0;
        int maxSum = -1;

        for (int i=0; i<array.length; i++) {

            sum += array[i];

            if (sum < 0) {

                sum = 0;
            }

            if (sum > maxSum) {

                maxSum = sum;
            }
        }

        return maxSum;
    }

    private int[] getInvertedArray(int array[]) {

        for (int i=0; i<array.length; i++) {

            array[i] = -array[i];
        }

        return array;
    }

    private int getSum() {

        int sum = 0;

        for (int i=0; i<inputData.size(); i++) {

            sum += inputData.get(i);
        }

        return sum;
    }

}
