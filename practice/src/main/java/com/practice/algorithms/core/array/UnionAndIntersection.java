package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public class UnionAndIntersection implements IAlgorithm{

    private static Logger log = Logger.getLogger(UnionAndIntersection.class);

    private List<Integer> inputDataOne;

    private List<Integer> inputDataTwo;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputDataOne.toString() + " - " + inputDataTwo.toString());
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("UnionAndIntersection.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            JSONObject inputData = input.getJSONObject(ResponseKeys.INPUT);
            inputDataOne = CommonHelper.convertIntegerStringToList(inputData.getString("inputDataOne"));
            inputDataTwo = CommonHelper.convertIntegerStringToList(inputData.getString("inputDataTwo"));

        } catch (Exception e) {

            log.error("UnionAndIntersection.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int indexI = 0;
        int indexJ = 0;

        String union = "Union: ";
        String intersection = "Intersection: ";

        while (indexI < inputDataOne.size() && indexJ < inputDataTwo.size()) {

            if (inputDataOne.get(indexI) < inputDataTwo.get(indexJ)) {

                union += inputDataOne.get(indexI) + " -> ";
                indexI++;
            } else if (inputDataOne.get(indexI) > inputDataTwo.get(indexJ)) {

                union += inputDataTwo.get(indexJ) + " -> ";
                indexJ++;
            } else {

                union += inputDataOne.get(indexI) + " -> ";
                intersection += inputDataOne.get(indexI) + " -> ";
                indexI++;
                indexJ++;
            }
        }

        if (indexI < inputDataOne.size()) {

            union += inputDataOne.get(indexI) + " -> ";
            indexI++;
        } else if (indexJ < inputDataTwo.size()) {

            union += inputDataTwo.get(indexJ) + " -> ";
            indexJ++;
        }

        return union + " - " + intersection;
    }

}
