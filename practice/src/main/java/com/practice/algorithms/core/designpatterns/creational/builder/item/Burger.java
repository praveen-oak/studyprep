package com.practice.algorithms.core.designpatterns.creational.builder.item;

import com.practice.algorithms.core.designpatterns.creational.builder.packing.IPacking;
import com.practice.algorithms.core.designpatterns.creational.builder.packing.Wrapper;

public abstract class Burger implements IItem
{

    @Override
    public IPacking packing() {

        return new Wrapper();
    }

    @Override
    public abstract float price();

}