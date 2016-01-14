package com.practice.algorithms.core.designpatterns.structural.decorator.shape;

import org.apache.log4j.Logger;

public class Circle implements IShape
{

    private static Logger log = Logger.getLogger(Circle.class);

    @Override
    public void draw() {

        log.info("Circle.draw  -  Drawing circle !!");
    }

}
