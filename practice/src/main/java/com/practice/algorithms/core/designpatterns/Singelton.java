package com.practice.algorithms.core.designpatterns;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IDesignPatterns;
import com.practice.algorithms.core.designpatterns.creational.singelton.CoreSingelton;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class Singelton implements IDesignPatterns
{

    private static Logger log = Logger.getLogger(Singelton.class);

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("Singelton.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

    private String runAlgorithm() {

        CoreSingelton singeltonObject = CoreSingelton.getInstance();
        singeltonObject.showMessage();

        log.info("Singelton.runAlgorithm  -  " + singeltonObject);

        singeltonObject = CoreSingelton.getInstance();

        log.info("Singelton.runAlgorithm  -  " + singeltonObject);

        return "Check logs for the output !!";
    }

}
