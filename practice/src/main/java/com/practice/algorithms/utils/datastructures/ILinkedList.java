package com.practice.algorithms.utils.datastructures;

import com.practice.algorithms.models.ILinkedListNode;

public interface ILinkedList <DataType>
{

    public boolean insert(DataType data);

    public boolean delete(ILinkedListNode<DataType> data);

    public boolean delete(int index);

    public void print();

}
