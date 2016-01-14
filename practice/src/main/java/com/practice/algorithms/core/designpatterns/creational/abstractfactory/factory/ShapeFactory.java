package com.practice.algorithms.core.designpatterns.creational.abstractfactory.factory;

import com.practice.algorithms.core.designpatterns.creational.abstractfactory.color.IColor;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.shape.Circle;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.shape.IShape;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.shape.Rectangle;

public class ShapeFactory extends CoreAbstractFactory
{

    @Override
    public IColor getColor(String colorString) {

        return null;
    }

    @Override
    public IShape getShape(String shapeString) {

        IShape shape = null;

        if (shapeString.toUpperCase().equals("CIRCLE")) {

            shape = new Circle();
        } else if (shapeString.toUpperCase().equals("RECTANGLE")) {

            shape = new Rectangle();
        }

        return shape;
    }

}
