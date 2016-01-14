package com.practice.algorithms.core.designpatterns.creational.builder.item;

import com.practice.algorithms.core.designpatterns.creational.builder.packing.IPacking;

public interface  IItem
{

    public String name();

    public IPacking packing();

    public float price();

}