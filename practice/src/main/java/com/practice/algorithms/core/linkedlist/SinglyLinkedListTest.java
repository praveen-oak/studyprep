package com.practice.algorithms.core.linkedlist;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.SinglyLinkedList;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class SinglyLinkedListTest implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SinglyLinkedListTest.class);

    private SinglyLinkedList<String> singlyLinkedList;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("SinglyLinkedListTest.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            singlyLinkedList = CommonHelper.convertStringToSinglyLinkedList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("SinglyLinkedListTest.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

//        singlyLinkedList.print();

//        singlyLinkedList.delete(7);
//        singlyLinkedList.print();

//        singlyLinkedList.delete(11);
//        singlyLinkedList.print();

//        singlyLinkedList.delete(singlyLinkedList.getHead().getNext().getNext());
//        singlyLinkedList.print();

        return singlyLinkedList.toString();
    }

}
