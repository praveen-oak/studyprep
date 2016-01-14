package com.practice.algorithms.core.designpatterns.structural.facade.shape;

import org.apache.log4j.Logger;

public class Square implements IShape
{

    private static Logger log = Logger.getLogger(Square.class);

    @Override
    public void draw() {

        log.info("Square.draw  -  Drawing square !!");
    }

}
