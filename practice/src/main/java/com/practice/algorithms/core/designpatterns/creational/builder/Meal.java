package com.practice.algorithms.core.designpatterns.creational.builder;

import com.practice.algorithms.core.designpatterns.creational.builder.item.IItem;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ArrayList;

public class Meal
{
    private static Logger log = Logger.getLogger(Meal.class);

    private List<IItem> items = new ArrayList<IItem>();

    public void addItem(IItem item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;

        for (IItem item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){

        for (IItem item : items) {
            log.info("Item : " + item.name());
            log.info("Packing : " + item.packing().pack());
            log.info("Price : " + item.price());
            log.info("");
        }
    }

}
