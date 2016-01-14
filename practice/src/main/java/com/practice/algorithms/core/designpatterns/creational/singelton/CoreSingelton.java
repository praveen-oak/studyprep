package com.practice.algorithms.core.designpatterns.creational.singelton;

import org.apache.log4j.Logger;

public class CoreSingelton
{

    private static Logger log = Logger.getLogger(CoreSingelton.class);

    //create an object of SingleObject
    private static CoreSingelton instance = null;

    //make the constructor private so that this class cannot be
    //instantiated
    private CoreSingelton() {

        log.info("CoreSingelton.CoreSingelton  -  Initializing Singelton object.");

    }

    //Get the only object available
    public static CoreSingelton getInstance(){

        // Lazy Initialization
        if (instance == null) {

            instance = new CoreSingelton();
        }

        return instance;
    }

    public void showMessage(){

        log.info("CoreSingelton.showMessage  -  Hello World !!");
    }

}
