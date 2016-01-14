package com.practice.algorithms.core.designpatterns.structural.bridge.shape;

import com.practice.algorithms.core.designpatterns.structural.bridge.IDrawApi;

public abstract class Shape
{

    protected IDrawApi drawApi;

    protected Shape(IDrawApi drawAPI){

        this.drawApi = drawAPI;
    }

    public abstract void draw();

}
