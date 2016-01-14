package com.practice.algorithms.core.designpatterns.creational.abstractfactory.shape;

import org.apache.log4j.Logger;

public class Rectangle implements IShape
{

    private static Logger log = Logger.getLogger(Rectangle.class);

    @Override
    public void draw() {

        log.info("Rectangle.draw  -  Drawing Rectangle !!");
    }

}
