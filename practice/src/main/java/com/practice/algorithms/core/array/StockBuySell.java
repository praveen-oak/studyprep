package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class StockBuySell implements IAlgorithm
{

    private static Logger log = Logger.getLogger(StockBuySell.class);

    private List<Integer> inputData;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("StockBuySell.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            inputData = CommonHelper.convertIntegerStringToList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("StockBuySell.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        int buyingIndex;
        int sellingIndex;
        List <String> result = new LinkedList<String>();
        int i = 1;

        while (i<inputData.size()) {

            while (inputData.get(i) < inputData.get(i-1) && i < inputData.size()) i++;
            buyingIndex = i-1;

            if (i >= inputData.size()) break;

            while (i < inputData.size() && inputData.get(i) > inputData.get(i-1)) i++;
            sellingIndex = i-1;

            log.info("Buying Day: " + buyingIndex + "  -  Selling Day: " + sellingIndex);
            result.add("Buying Day: " + buyingIndex + "  -  Selling Day: " + sellingIndex);

        }

        return result.toString();
    }
}
