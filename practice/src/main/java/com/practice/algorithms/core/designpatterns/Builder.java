package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.creational.builder.CoreBuilder;
import com.practice.algorithms.core.designpatterns.creational.builder.Meal;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class Builder implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(Builder.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("Builder.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        CoreBuilder mealBuilder = new CoreBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        log.info("Builder.runAlgorithm  -  Veg Meal");
        vegMeal.showItems();
        log.info("Builder.runAlgorithm  -  Total Cost: " + vegMeal.getCost());

        log.info("--------------------------------------");

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        log.info("Builder.runAlgorithm  -  Non-Veg Meal");
        nonVegMeal.showItems();
        log.info("Builder.runAlgorithm  -  Total Cost: " + nonVegMeal.getCost());

        return "Check logs for the output !!";
    }

}
