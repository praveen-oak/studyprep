package com.practice.algorithms.core.linkedlist;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.CircularLinkedList;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class CircularLinkedListTest implements IAlgorithm
{

    private static Logger log = Logger.getLogger(CircularLinkedListTest.class);

    private CircularLinkedList<String> circularLinkedList;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("CircularLinkedListTest.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            circularLinkedList = CommonHelper.convertStringToCircularLinkedList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("CircularLinkedListTest.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        circularLinkedList.print();

        circularLinkedList.delete(7);
        circularLinkedList.print();

        circularLinkedList.delete(11);
        circularLinkedList.print();

        circularLinkedList.delete(circularLinkedList.getHead().getNext().getNext());
        circularLinkedList.print();

        return circularLinkedList.toString();
    }

}
