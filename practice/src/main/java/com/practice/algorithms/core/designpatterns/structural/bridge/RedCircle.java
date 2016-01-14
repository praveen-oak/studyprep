package com.practice.algorithms.core.designpatterns.structural.bridge;

import org.apache.log4j.Logger;

//      Concrete bridge implementers
public class RedCircle implements IDrawApi
{

    private static Logger log = Logger.getLogger(RedCircle.class);

    @Override
    public void drawCircle(int radius, int x, int y) {

        log.info("RedCircle.drawCircle  -  Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
