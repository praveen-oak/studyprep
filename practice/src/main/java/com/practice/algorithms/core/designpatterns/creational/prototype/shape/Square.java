package com.practice.algorithms.core.designpatterns.creational.prototype.shape;

import org.apache.log4j.Logger;

public class Square extends Shape
{

    private static Logger log = Logger.getLogger(Square.class);

    public Square(){

        type = "Square";
    }

    @Override
    void draw() {

        log.info("Inside Square::draw() method.");
    }

}
