package com.practice.algorithms.core.designpatterns.creational.prototype.shape;

import org.apache.log4j.Logger;

public class Circle extends Shape
{

    private static Logger log = Logger.getLogger(Circle.class);

    public Circle(){

        type = "Circle";
    }

    @Override
    void draw() {

        log.info("Inside Circle::draw() method.");
    }
}
