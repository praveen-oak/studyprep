package com.practice.algorithms.models;

public class LinkedListNode<DataType> implements ILinkedListNode <DataType>
{

    private DataType data;

    private LinkedListNode next;

    public LinkedListNode(DataType data) {

        this.data = data;
        this.next = null;

    }

    public DataType getData() {

        return data;
    }

    public LinkedListNode getNext() {

        return next;
    }

    public void setNext(LinkedListNode next) {

        this.next = next;
    }

}
