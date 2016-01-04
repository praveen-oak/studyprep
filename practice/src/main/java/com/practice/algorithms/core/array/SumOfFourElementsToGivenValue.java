package com.practice.algorithms.core.array;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SumOfFourElementsToGivenValue implements IAlgorithm
{

    private static Logger log = Logger.getLogger(ReplaceByGreatestElementOnRight.class);

    private List<Integer> inputData;

    private int sum;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.INPUT, inputData.toString() + ",  Sum: " + sum);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ReplaceByGreatestElementOnRight.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {
            JSONObject inputJSon = input.getJSONObject(ResponseKeys.INPUT);

            inputData = CommonHelper.convertIntegerStringToList(inputJSon.getString("inputData"));
            sum = inputJSon.getInt("sum");

        } catch (Exception e) {

            log.error("ReplaceByGreatestElementOnRight.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        List<Pair> pairs = generatePairs();
        Collections.sort(pairs, new PairComparator());

        int leftIndex = 0;
        int rightIndex = pairs.size()-1;

        String quadPairs = "Pairs: ";

        while (leftIndex < rightIndex) {

            if (pairs.get(leftIndex).sum + pairs.get(rightIndex).sum == sum) {

                quadPairs += "(" + pairs.get(leftIndex).x + ", " + pairs.get(leftIndex).y + ", " +
                        pairs.get(rightIndex).x + ", " + pairs.get(rightIndex).y + ")  ";

                break;

            } else if (pairs.get(leftIndex).sum + pairs.get(rightIndex).sum < sum) {

                 leftIndex++;
            } else {

                rightIndex--;
            }
        }

        return quadPairs;
    }

    private List<Pair> generatePairs() {

        List<Pair> pairs = new LinkedList<Pair>();
        int size = inputData.size();

        for (int i=0; i<size-1; i++) {

            for (int j=i+1; j<size; j++) {

                pairs.add(new Pair(inputData.get(i), inputData.get(j)));
            }

        }

        return pairs;
    }

    private class PairComparator implements Comparator<Pair>
    {

        @Override
        public int compare(Pair pairOne, Pair pairTwo) {

            return (pairOne.sum - pairTwo.sum);
        }
    }

    private class Pair
    {

        public int x;
        public int y;
        public int sum;

        Pair(int x, int y) {

            this.x = x;
            this.y = y;
            this.sum = x+y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", sum=" + sum +
                    '}';
        }
    }
}
