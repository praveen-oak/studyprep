package com.practice.algorithms.core.dummy;

import com.practice.algorithms.core.IAlgorithm;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class DummyAlgorithm implements IAlgorithm
{

    private static Logger log = Logger.getLogger(DummyAlgorithm.class);

    @Override
    public String run(JSONObject input) {

        try {

            log.info("DummyAlgorithm.run  -  Running Algorithm !!");
            log.info("DummyAlgorithm.run  -  Algorithm input - " + input.toString());

            input.put("output", "Hello World");

        } catch (JSONException e) {

            log.error("DummyAlgorithm.run  -  Exception in executing algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

    }

}
