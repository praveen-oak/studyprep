package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class MaximumProductSubArray implements IAlgorithm {

    private static Logger log = Logger.getLogger(MaximumProductSubArray.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaximumProductSubArray.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("MaximumProductSubArray.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        int maxProduct = 1;
        int currentMaxProduct = 1;
        int currentMinProduct = 1;

        for (int data : inputData) {

            if (data > 0) {

                currentMaxProduct *= data;
                currentMinProduct = min(currentMinProduct*data, 1);
            } else if (data == 0) {

                currentMaxProduct = 1;
                currentMinProduct = 1;
            } else {

                int tmp = currentMaxProduct;
                currentMaxProduct = max(currentMinProduct*data, currentMaxProduct);
                currentMinProduct = min(currentMinProduct, tmp*data);
            }

            if (maxProduct < currentMaxProduct) {

                maxProduct = currentMaxProduct;
            }
        }

        return maxProduct;
    }

    private int max(int x, int y) {

        return x > y ? x : y;
    }

    private int min(int x, int y) {

        return x > y ? y : x;
    }
}
