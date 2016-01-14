package com.practice.algorithms.core.designpatterns.creational.abstractfactory.color;

import org.apache.log4j.Logger;

public class Green implements IColor
{

    private static Logger log = Logger.getLogger(Green.class);

    @Override
    public void fill() {

        log.info("Blue.fill  -  Filling Green color !!");
    }

}
