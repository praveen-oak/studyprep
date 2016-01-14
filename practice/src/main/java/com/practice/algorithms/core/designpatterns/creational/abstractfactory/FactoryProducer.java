package com.practice.algorithms.core.designpatterns.creational.abstractfactory;

import com.practice.algorithms.core.designpatterns.creational.abstractfactory.factory.ColorFactory;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.factory.CoreAbstractFactory;
import com.practice.algorithms.core.designpatterns.creational.abstractfactory.factory.ShapeFactory;

public class FactoryProducer
{

    public static CoreAbstractFactory getFactory(String factoryString) {

        CoreAbstractFactory factory = null;

        if (factoryString.toUpperCase().equals("SHAPE")) {

            factory = new ShapeFactory();
        } else if (factoryString.toUpperCase().equals("COLOR")) {

            factory = new ColorFactory();
        }

        return factory;

    }

}