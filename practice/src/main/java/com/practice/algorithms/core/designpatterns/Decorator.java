package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.structural.decorator.RedShapeDecorator;
import com.practice.algorithms.core.designpatterns.structural.decorator.shape.Circle;
import com.practice.algorithms.core.designpatterns.structural.decorator.shape.IShape;
import com.practice.algorithms.core.designpatterns.structural.decorator.shape.Rectangle;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class Decorator implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(Decorator.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("Decorator.run  -  Exception in running algorithm", e);
        }

        StringBuilder myName = new StringBuilder("domanokz");

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        IShape circle = new Circle();

        IShape redCircle = new RedShapeDecorator(new Circle());

        IShape redRectangle = new RedShapeDecorator(new Rectangle());

        log.info("Circle with normal border");
        circle.draw();

        log.info("Circle of red border");
        redCircle.draw();

        log.info("Rectangle of red border");
        redRectangle.draw();

        return "Check logs for the output !!";
    }

}
