package com.practice.algorithms.core.designpatterns.creational.abstractfactory.factory;

import com.practice.algorithms.core.designpatterns.creational.abstractfactory.color.Blue;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.color.Green;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.color.IColor;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.shape.IShape;

public class ColorFactory  extends CoreAbstractFactory
{

    @Override
    public IColor getColor(String colorString) {

        IColor color = null;

        if (colorString.toUpperCase().equals("BLUE")) {

            color = new Blue();
        } else if (colorString.toUpperCase().equals("GREEN")) {

            color = new Green();
        }

        return color;

    }

    @Override
    public IShape getShape(String shapeString) {

        return null;
    }

}
