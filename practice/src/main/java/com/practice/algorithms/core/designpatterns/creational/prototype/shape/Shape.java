package com.practice.algorithms.core.designpatterns.creational.prototype.shape;

import org.apache.log4j.Logger;

public abstract class Shape implements Cloneable
{

    private static Logger log = Logger.getLogger(Shape.class);

    private String id;

    protected String type;

    abstract void draw();

    public String getType(){

        return type;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public Object clone() {

        Object clone = null;

        try {

            clone = super.clone();

        } catch (CloneNotSupportedException e) {

            log.error("Shape.clone  -  Exception while cloning the object.", e);
            e.printStackTrace();
        }

        return clone;
    }

}
