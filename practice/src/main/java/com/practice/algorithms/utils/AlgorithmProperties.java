package com.practice.algorithms.utils;

import java.util.Properties;

public class AlgorithmProperties
{

    private Properties dbProperties;

    private Properties applicationProperties;

    public AlgorithmProperties(){

    }

    public Properties getDbProperties() {
        return dbProperties;
    }

    public void setDbProperties(Properties dbProperties) {
        this.dbProperties = dbProperties;
    }

    public Properties getApplicationProperties() {
        return applicationProperties;
    }

    public void setApplicationProperties(Properties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }
}
