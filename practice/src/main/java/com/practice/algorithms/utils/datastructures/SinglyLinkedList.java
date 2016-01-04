package com.practice.algorithms.utils.datastructures;

import com.practice.algorithms.models.ILinkedListNode;
import com.practice.algorithms.models.LinkedListNode;
import org.apache.log4j.Logger;

public class SinglyLinkedList <DataType> implements ILinkedList <DataType>
{

    private static Logger log = Logger.getLogger(SinglyLinkedList.class);

    private static final String LIST = "List => ";
    private int size;

    private LinkedListNode<DataType> head;

    public SinglyLinkedList() {

        size = 0;
        head = null;
    }

    public int getSize() {

        return size;
    }

    public LinkedListNode<DataType> getHead() {

        return head;
    }

    @Override
    public boolean insert(DataType data) {

        boolean status = false;

        try {

            LinkedListNode<DataType> node = new LinkedListNode<DataType>(data);

            if (head == null) {

                head = node;
            } else {

                node.setNext(head);
                head = node;
            }

            size++;
            status = true;

        } catch (Exception e) {

            log.error("SinglyLinkedList.insert  -  Error in inserting data: " + data, e);
        }

        return status;
    }

    @Override
    public boolean delete(ILinkedListNode<DataType> node) {

        boolean status = false;

        try {

            LinkedListNode<DataType> deleteNode;

            if (head == node) {

                deleteNode = head;
                head = head.getNext();
                deleteNode = null;

            } else {

                LinkedListNode<DataType> prv = null;
                LinkedListNode<DataType> itr = head;

                while (itr != node) {

                    prv = itr;
                    itr = itr.getNext();
                }

                prv.setNext(itr.getNext());
                deleteNode = itr;
                deleteNode = null;

            }

            size--;
            status=true;

        } catch (Exception e) {

            log.error("SinglyLinkedList.delete  -  Exception in deleting node at index: " + node, e);
        }

        return status;
    }

    @Override
    public boolean delete(int index) {

        boolean status = false;

        if (index > size) {

            log.info("SinglyLinkedList.delete  -  Unable to delete. Provided index is out of bounds. Size: " + size +
                    " - Index : " + index);
            return status;
        }

        try {

            LinkedListNode<DataType> deleteNode;

            if (index == 0) {

                deleteNode = head;
                head = head.getNext();
                deleteNode = null;

            } else {

                LinkedListNode<DataType> prv = null;
                LinkedListNode<DataType> itr = head;

                int count = 1;
                while (count != index) {

                    prv = itr;
                    itr = itr.getNext();
                    count++;

                }

                prv.setNext(itr.getNext());
                deleteNode = itr;
                deleteNode = null;

            }

            size--;
            status = true;

        } catch (Exception e) {

            log.error("SinglyLinkedList.delete  -  Exception in deleting node at index: " + index, e);
        }

        return status;
    }

    @Override
    public void print() {

        log.info(LIST + listToString());
    }

    @Override
    public String toString() {
        return "SinglyLinkedList: " +
                "size = " + size +
                ", list = " + listToString() +
                " }";
    }

    private String listToString() {

        String list = "";
        LinkedListNode<DataType> itr = head;

        while (itr != null) {

            list += itr.getData().toString() + " -> ";
            itr = itr.getNext();
        }

        return list;
    }
}
