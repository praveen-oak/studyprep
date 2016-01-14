package com.practice.algorithms.core.designpatterns.creational.builder.burger;

import com.practice.algorithms.core.designpatterns.creational.builder.item.Burger;

public class ChickenBurger extends Burger
{

    @Override
    public String name() {

        return "Chicken Burger";
    }

    @Override
    public float price() {

        return 30.0f;
    }

}
