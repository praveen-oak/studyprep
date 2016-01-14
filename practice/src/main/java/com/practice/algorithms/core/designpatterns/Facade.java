package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.structural.facade.CoreFacade;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class Facade implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(Facade.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("Facade.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        CoreFacade facade = new CoreFacade();

        facade.drawCircle();
        facade.drawRectangle();
        facade.drawSquare();

        return "Check logs for the output !!";
    }

}
