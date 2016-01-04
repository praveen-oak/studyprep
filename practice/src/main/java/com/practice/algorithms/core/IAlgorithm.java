package com.practice.algorithms.core;

import org.codehaus.jettison.json.JSONObject;

public interface IAlgorithm
{

    public String run(JSONObject input);

    public void setInput(JSONObject input);

}