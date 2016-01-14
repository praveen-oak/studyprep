package com.practice.algorithms.core.designpatterns.structural.bridge;

import org.apache.log4j.Logger;

//      Concrete bridge implementers
public class BlueCircle implements IDrawApi
{
    private static Logger log = Logger.getLogger(BlueCircle.class);

    @Override
    public void drawCircle(int radius, int x, int y) {

        log.info("BlueCircle.drawCircle  -  Drawing Circle[ color: blue, radius: " + radius + ", x: " + x + ", " + y + "]");
    }

}
