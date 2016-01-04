package com.practice.algorithms.utils.datastructures;

import com.practice.algorithms.models.ILinkedListNode;
import com.practice.algorithms.models.LinkedListNode;
import org.apache.log4j.Logger;

public class CircularLinkedList <DataType> implements ILinkedList<DataType>
{

    private static Logger log = Logger.getLogger(CircularLinkedList.class);

    private static final String LIST = "List => ";
    private int size;

    private LinkedListNode<DataType> head;

    private LinkedListNode<DataType> last;

    public CircularLinkedList() {

        size = 0;
        head = null;
        last = null;
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

            node.setNext(head);

            if (head == null) {

                last = node;
            } else {

                last.setNext(node);
            }

            head = node;
            size++;
            status = true;

        } catch (Exception e) {

            log.error("CircularLinkedList.insert  -  Exception in inserting data: " + data, e);
        }

        return status;
    }

    @Override
    public boolean delete(ILinkedListNode<DataType> node) {
        boolean status = false;

        try {

            LinkedListNode<DataType> deleteNode = null;

            if (node == head) {

                deleteNode = head;
                head = head.getNext();
                last.setNext(head);
                deleteNode = null;

            } else {

                LinkedListNode<DataType> itr = head;
                LinkedListNode<DataType> prv = null;

                while (node != itr) {

                    prv = itr;
                    itr = itr.getNext();
                }

                if (node == last) {

                    last = prv;
                }

                deleteNode = itr;
                prv.setNext(itr.getNext());
                deleteNode = null;

            }

            size--;
            status = true;

        } catch (Exception e) {

            log.error("CircularLinkedList.delete  -  Exception in deleting node: " + node, e);
        }

        return status;
    }

    @Override
    public boolean delete(int index) {

        boolean status = false;

        if (index > size) {

            log.info("CircularLinkedList.delete  -  Unable to delete. Provided index is out of bounds. Size: " + size +
                    " - Index : " + index);
            return status;
        }

        try {

            LinkedListNode<DataType> deleteNode = null;

            if (index == 0) {

                deleteNode = head;
                head = head.getNext();
                last.setNext(head);
                deleteNode = null;

            } else {

                int count = 1;
                LinkedListNode<DataType> itr = head;
                LinkedListNode<DataType> prv = null;

                while (count != index) {

                    prv = itr;
                    itr = itr.getNext();
                    count++;
                }

                if (index == size) {

                    last = prv;
                }

                deleteNode = itr;
                prv.setNext(itr.getNext());
                deleteNode = null;

            }

            size--;
            status = true;

        } catch (Exception e) {

            log.error("CircularLinkedList.delete  -  Exception in deleting data at index: " + index, e);
        }

        return status;
    }

    @Override
    public void print() {

        log.info(LIST + listToString());
    }

    @Override
    public String toString() {
        return "CircularLinkedList: " +
                "size = " + size +
                ", head = " + head.getData() +
                ", last = " + last.getData() +
                ", list = " + listToString() ;
    }

    private String listToString() {

        String list = "";
        LinkedListNode<DataType> itr = head;

        do {

            list += itr.getData().toString() + " -> ";
            itr = itr.getNext();

        } while (itr != head);

        return list;
    }
}
