package com.practice.algorithms.core.designpatterns.creational.abstractfactory.factory;

import com.practice.algorithms.core.designpatterns.creational.abstractfactory.color.IColor;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.shape.IShape;

public abstract class CoreAbstractFactory
{

    public abstract IColor getColor(String colorString);

    public abstract IShape getShape(String shapeString) ;

}
