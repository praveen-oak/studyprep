package com.practice.algorithms.core.designpatterns.structural.bridge.shape;

import com.practice.algorithms.core.designpatterns.structural.bridge.IDrawApi;

public class Circle extends Shape
{

    private int x, y, radius;

    public Circle(int x, int y, int radius, IDrawApi drawAPI) {

        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;

    }

    public void draw() {

        drawApi.drawCircle(radius,x,y);
    }

}
