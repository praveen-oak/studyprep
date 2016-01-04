package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class ProductArrayPuzzle implements IAlgorithm
{

    private static Logger log = Logger.getLogger(ProductArrayPuzzle.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ProductArrayPuzzle.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("ProductArrayPuzzle.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int[] leftProduct = getLeftProduct();
        int[] rightProduct = getRightProduct();
        int size = inputData.size();

        List<Integer> result = new LinkedList<Integer>();

        for (int i=0; i<size; i++) {

            result.add(i, leftProduct[i]*rightProduct[i]);
        }

        return result.toString();
    }

    private int[] getLeftProduct(){

        int leftProduct[] = new int[inputData.size()];
        leftProduct[0] = 1;

        for (int i=1; i<inputData.size(); i++) {

            leftProduct[i] = inputData.get(i-1)*leftProduct[i-1];
        }

        return leftProduct;
    }

    private int[] getRightProduct(){

        int rightProduct[] = new int[inputData.size()];
        rightProduct[inputData.size()-1] = 1;

        for (int i=inputData.size()-2; i>=0; i--) {

            rightProduct[i] = inputData.get(i+1)*rightProduct[i+1];
        }

        return rightProduct;
    }

}
