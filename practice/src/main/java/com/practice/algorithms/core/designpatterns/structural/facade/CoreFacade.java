package com.practice.algorithms.core.designpatterns.structural.facade;

import com.practice.algorithms.core.designpatterns.structural.facade.shape.Circle;
import com.practice.algorithms.core.designpatterns.structural.facade.shape.IShape;
import com.practice.algorithms.core.designpatterns.structural.facade.shape.Rectangle;
import com.practice.algorithms.core.designpatterns.structural.facade.shape.Square;
import org.apache.log4j.Logger;

public class CoreFacade
{

    private static Logger log = Logger.getLogger(CoreFacade.class);

    private IShape circle;

    private IShape rectangle;

    private IShape square;

    public CoreFacade() {

        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();

    }

    public void drawCircle() {

        circle.draw();
    }

    public void drawRectangle() {

        rectangle.draw();
    }

    public void drawSquare() {

        square.draw();
    }


}
