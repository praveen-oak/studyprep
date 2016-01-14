package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.creational.prototype.ShapeCache;
import com.practice.algorithms.core.designpatterns.creational.prototype.shape.Shape;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class Prototype implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(Prototype.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("Prototype.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        ShapeCache.loadCache();

        Shape clonedShape1 = (Shape) ShapeCache.getShape("1");
        log.info("Prototype.runAlgorithm  -  Shape : " + clonedShape1.getType() + clonedShape1.getId());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        log.info("Prototype.runAlgorithm  -  Shape : " + clonedShape2.getType() + clonedShape2.getId());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        log.info("Prototype.runAlgorithm  -  Shape : " + clonedShape3.getType() + clonedShape3.getId());

        return "Check logs for the output !!";
    }

}
