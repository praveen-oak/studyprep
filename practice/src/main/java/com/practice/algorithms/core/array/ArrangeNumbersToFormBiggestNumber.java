package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangeNumbersToFormBiggestNumber implements IAlgorithm
{

    private static Logger log = Logger.getLogger(ArrangeNumbersToFormBiggestNumber.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ArrangeNumbersToFormBiggestNumber.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("ArrangeNumbersToFormBiggestNumber.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        Collections.sort(inputData, new BiggestComparator());
        String biggestNumber =  "";

        for (Integer data : inputData) {

            biggestNumber += data.toString();
        }

        return biggestNumber;
    }

    private class BiggestComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer integerOne, Integer integerTwo) {

            String integerOneString = integerOne.toString();
            String integerTwoString = integerTwo.toString();

            if (integerOneString.concat(integerTwoString)
                    .compareTo(
                            integerTwoString.concat(integerOneString)
                    ) == 0) {

                return 0;

            } else if (integerOneString.concat(integerTwoString)
                    .compareTo(
                            integerTwoString.concat(integerOneString)
                    ) > 0) {

                return -1;

            } else {

                return 1;
            }
        }
    }

}
