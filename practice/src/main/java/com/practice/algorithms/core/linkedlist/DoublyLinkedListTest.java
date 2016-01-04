package com.practice.algorithms.core.linkedlist;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.DoublyLinkedList;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class DoublyLinkedListTest implements IAlgorithm
{

    private static Logger log = Logger.getLogger(SinglyLinkedListTest.class);

    private DoublyLinkedList<String> doublyLinkedList;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("DoublyLinkedListTest.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            doublyLinkedList = CommonHelper.convertStringToDoublyLinkedList(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("DoublyLinkedListTest.setInput  -  Exception in setting input", e);
        }

    }

    private String runAlgorithm() {

        doublyLinkedList.print();
        doublyLinkedList.printReverse();

        doublyLinkedList.delete(7);
        doublyLinkedList.print();

        doublyLinkedList.delete(11);
        doublyLinkedList.print();

        doublyLinkedList.delete(doublyLinkedList.getHead().getNext().getNext());
        doublyLinkedList.print();

        return doublyLinkedList.toString();
    }

}
