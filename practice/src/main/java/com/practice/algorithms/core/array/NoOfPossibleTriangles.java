package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.Collections;
import java.util.List;

public class NoOfPossibleTriangles implements IAlgorithm
{

    private static Logger log = Logger.getLogger(NoOfPossibleTriangles.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("NoOfPossibleTriangles.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("NoOfPossibleTriangles.setInput  -  Exception in setting input", e);
        }

    }

    private int runAlgorithm() {

        Collections.sort(inputData);
        int noOfTriangles = 0;

        for (int i=0; i<inputData.size()-2; i++) {

            for (int j=i+1; j<inputData.size()-1; j++) {

                int k = j+1;

                while (inputData.get(i) + inputData.get(j) > inputData.get(k)) {

                    k++;
                    if (k >= inputData.size()){
                        break;
                    }
                }

                noOfTriangles += k-j-1;
            }
        }

        return noOfTriangles;
    }

}
