package com.practice.algorithms.core.designpatterns.creational.abstractfactory.color;

import org.apache.log4j.Logger;

public class Blue implements IColor
{

    private static Logger log = Logger.getLogger(Blue.class);

    @Override
    public void fill() {

        log.info("Blue.fill  -  Filling Blue color !!");
    }

}
