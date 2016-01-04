package com.practice.algorithms.models;

public class DoublyLinkedListNode <DataType> implements ILinkedListNode
{

    private DataType data;

    private DoublyLinkedListNode next;

    private DoublyLinkedListNode prev;

    public DoublyLinkedListNode(DataType data) {

        this.data = data;
        this.next = null;
        this.prev = null;

    }

    public DataType getData() {

        return data;
    }

    public DoublyLinkedListNode getNext() {

        return next;
    }

    public void setNext(DoublyLinkedListNode next) {

        this.next = next;
    }

    public DoublyLinkedListNode getPrev() {

        return prev;
    }

    public void setPrev(DoublyLinkedListNode prev) {

        this.prev = prev;
    }

}
