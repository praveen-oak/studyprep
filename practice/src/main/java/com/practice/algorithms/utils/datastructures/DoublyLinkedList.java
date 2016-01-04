package com.practice.algorithms.utils.datastructures;

import com.practice.algorithms.models.DoublyLinkedListNode;
import com.practice.algorithms.models.ILinkedListNode;
import org.apache.log4j.Logger;

public class DoublyLinkedList <DataType> implements ILinkedList <DataType>
{

    private static Logger log = Logger.getLogger(DoublyLinkedList.class);

    private static final String LIST = "List => ";

    private int size;

    private DoublyLinkedListNode <DataType> head;

    private DoublyLinkedListNode <DataType> tail;

    public DoublyLinkedList() {

        size = 0;
        head = null;
        tail = null;
    }

    public int getSize() {

        return size;
    }

    public DoublyLinkedListNode<DataType> getHead() {

        return head;
    }

    public DoublyLinkedListNode<DataType> getTail() {

        return tail;
    }

    @Override
    public boolean insert(DataType data) {

        boolean status = false;

        try {

            DoublyLinkedListNode<DataType> node = new DoublyLinkedListNode<DataType>(data);

            if (head == null) {

                head = node;
                tail = node;

            } else {

                node.setNext(head);
                head.setPrev(node);
                head = node;
            }

            size++;
            status = true;

        } catch (Exception e) {

            log.error("DoublyLinkedList.insert  -  Error in inserting data: " + data, e);
        }

        return status;
    }

    @Override
    public boolean delete(ILinkedListNode<DataType> node) {

        boolean status = false;

        try {

            DoublyLinkedListNode<DataType> deleteNode;

            if (node == head) {

                deleteNode = head;
                head = head.getNext();
                head.setPrev(null);
                deleteNode = null;

            } else {

                DoublyLinkedListNode<DataType> prv = null;
                DoublyLinkedListNode<DataType> itr = head;

                while (itr != node) {

                    prv = itr;
                    itr = itr.getNext();
                }

                deleteNode = itr;
                prv.setNext(itr.getNext());
                itr.getNext().setPrev(prv);
                deleteNode = null;

            }

            size--;
            status = true;

        } catch (Exception e) {

            log.error("DoublyLinkedList.delete  -  Exception in deleting node at index: " + node, e);
        }

        return status;
    }

    @Override
    public boolean delete(int index) {

        boolean status = false;

        if (index > size) {

            log.info("DoublyLinkedList.delete  -  Unable to delete. Provided index is out of bounds. Size: " + size +
                    " - Index : " + index);
            return status;
        }

        try {

            DoublyLinkedListNode<DataType> deleteNode;

            if (index == 0) {

                deleteNode = head;
                head = head.getNext();
                head.setPrev(null);
                deleteNode = null;

            } else {

                int count = 1;
                DoublyLinkedListNode<DataType> prv = null;
                DoublyLinkedListNode<DataType> itr = head;

                while (count != index) {

                    prv = itr;
                    itr = itr.getNext();
                    count++;

                }

                deleteNode = itr;

                if (itr == tail) {

                    tail = prv;
                    prv.setNext(itr.getNext());

                } else {

                    prv.setNext(itr.getNext());
                    itr.getNext().setPrev(prv);
                }

                deleteNode = null;

            }

            size--;
            status = true;

        } catch (Exception e) {

            log.error("DoublyLinkedList.delete  -  Exception in deleting node at index: " + index, e);
        }

        return status;
    }

    @Override
    public void print() {

        log.info(LIST + listToString());
    }

    public void printReverse() {

        String list = "";
        DoublyLinkedListNode<DataType> itr = tail;

        while (itr != null) {

            list += itr.getData().toString() + " -> ";
            itr = itr.getPrev();
        }

        log.info(LIST + list);

    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "size =" + size +
                ", head =" + head.getData() +
                ", tail =" + tail.getData() +
                ", list =" + listToString() +
                '}';
    }

    private String listToString() {

        String list = "";
        DoublyLinkedListNode<DataType> itr = head;

        while (itr != null) {

            list += itr.getData().toString() + " -> ";
            itr = itr.getNext();
        }

        return list;
    }

}
