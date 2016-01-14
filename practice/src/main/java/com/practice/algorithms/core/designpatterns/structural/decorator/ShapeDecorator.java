package com.practice.algorithms.core.designpatterns.structural.decorator;

import com.practice.algorithms.core.designpatterns.structural.decorator.shape.IShape;

public abstract class ShapeDecorator implements IShape
{

    protected IShape decoratedShape;

    public ShapeDecorator(IShape decoratedShape){

        this.decoratedShape = decoratedShape;
    }

    public void draw(){

        decoratedShape.draw();
    }

}
