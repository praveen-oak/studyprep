package com.practice.algorithms.core.designpatterns.creational.builder.item;

import com.practice.algorithms.core.designpatterns.creational.builder.packing.Bottle;
import com.practice.algorithms.core.designpatterns.creational.builder.packing.IPacking;

public abstract class ColdDrink implements IItem
{

    @Override
    public IPacking packing() {

        return new Bottle();
    }

    @Override
    public abstract float price();

}
