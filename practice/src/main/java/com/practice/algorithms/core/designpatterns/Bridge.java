package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.structural.bridge.BlueCircle;
import com.practice.algorithms.core.designpatterns.structural.bridge.RedCircle;
import com.practice.algorithms.core.designpatterns.structural.bridge.shape.Circle;
import com.practice.algorithms.core.designpatterns.structural.bridge.shape.Shape;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class Bridge implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(Bridge.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("Bridge.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape blueCircle = new Circle(100,100, 10, new BlueCircle());

        redCircle.draw();
        blueCircle.draw();

        return "Check logs for the output !!";
    }

}
