package com.practice.algorithms.core.designpatterns.creational.builder.drink;

import com.practice.algorithms.core.designpatterns.creational.builder.item.ColdDrink;

public class Pepsi extends ColdDrink
{

    @Override
    public String name() {

        return "Pepsi";
    }

    @Override
    public float price() {

        return 25.0f;
    }

}
