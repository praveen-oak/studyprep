package com.practice.algorithms.core.designpatterns.creational.builder.burger;

import com.practice.algorithms.core.designpatterns.creational.builder.item.Burger;

public class VegBurger extends Burger
{

    @Override
    public String name() {

        return "Veg Burger";
    }

    @Override
    public float price() {

        return 25.0f;
    }

}
