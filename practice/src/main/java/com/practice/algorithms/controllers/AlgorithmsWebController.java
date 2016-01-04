package com.practice.algorithms.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlgorithmsWebController
{

    private static Logger log = Logger.getLogger(AlgorithmsWebController.class);

    @RequestMapping(value = "/")
    public String defaultPage(){

        log.info("AlgorithmsWebController.defaultPage  -  Loading index page !!");
        return "index";
    }

    @RequestMapping(value = "/index")
    public String index(){

        log.info("AlgorithmsWebController.index  -  Loading index page !!");
        return "index";
    }

}
