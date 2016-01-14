package com.practice.algorithms.core.designpatterns.structural.decorator;

import com.practice.algorithms.core.designpatterns.structural.decorator.shape.IShape;
import org.apache.log4j.Logger;

public class RedShapeDecorator extends ShapeDecorator
{

    private static Logger log = Logger.getLogger(RedShapeDecorator.class);

    public RedShapeDecorator(IShape decoratedShape) {

        super(decoratedShape);
    }

    @Override
    public void draw() {

        decoratedShape.draw();
        setRedBorder(decoratedShape);

    }

    private void setRedBorder(IShape decoratedShape){

        log.info("RedShapeDecorator.setRedBorder  -  Border Color: Red");
    }

}
