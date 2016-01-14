package com.practice.algorithms.core.designpatterns.creational.builder;

import com.practice.algorithms.core.designpatterns.creational.builder.burger.ChickenBurger;
import com.practice.algorithms.core.designpatterns.creational.builder.burger.VegBurger;
import com.practice.algorithms.core.designpatterns.creational.builder.drink.Coke;
import com.practice.algorithms.core.designpatterns.creational.builder.drink.Pepsi;

public class CoreBuilder
{

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
