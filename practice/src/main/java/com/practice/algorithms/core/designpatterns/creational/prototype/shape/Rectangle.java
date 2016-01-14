package com.practice.algorithms.core.designpatterns.creational.prototype.shape;

import org.apache.log4j.Logger;

public class Rectangle extends Shape
{

    private static Logger log = Logger.getLogger(Rectangle.class);

    public Rectangle(){

        type = "Rectangle";
    }

    @Override
    void draw() {

        log.info("Inside Rectangle::draw() method.");
    }
}
