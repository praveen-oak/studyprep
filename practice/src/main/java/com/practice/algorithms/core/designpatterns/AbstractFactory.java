package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.factory.CoreAbstractFactory;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.FactoryProducer;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class AbstractFactory implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(AbstractFactory.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("AbstractFactory.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        CoreAbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        CoreAbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        shapeFactory.getShape("CIRCLE").draw();
        colorFactory.getColor("BLUE").fill();

        return "Check logs for the output !!";
    }

}
