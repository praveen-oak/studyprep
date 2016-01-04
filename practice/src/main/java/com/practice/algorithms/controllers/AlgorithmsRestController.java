package com.practice.algorithms.controllers;

import com.practice.algorithms.facades.AlgorithmFacade;
import com.practice.algorithms.utils.AlgorithmProperties;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlgorithmsRestController
{

    private static Logger log = Logger.getLogger(AlgorithmsRestController.class);

    @Autowired
    private AlgorithmProperties algorithmProperties;

    @Autowired
    private AlgorithmFacade algorithmFacade;

    @RequestMapping(value = "/get-application-property", method = RequestMethod.GET)
    public ResponseEntity getApplicationProperty(@RequestParam String key){

        log.info("AlgorithmsRestController.getApplicationProperty  -  Fetching application property for key:" + key);
        String property = algorithmProperties.getApplicationProperties().getProperty(key);

        return new ResponseEntity(property, HttpStatus.OK);
    }

    @RequestMapping(value = "/test-algorithm", method = RequestMethod.GET)
    public ResponseEntity testAlgorithm(){

        log.info("AlgorithmsRestController.testAlgorithm  -  Testing Algorithm");
        String output = algorithmFacade.testFacade();

        return new ResponseEntity(output, HttpStatus.OK);
    }

    @RequestMapping(value = "/invoke-algorithm/{algorithmType}/{algorithm}", method = RequestMethod.GET)
    public ResponseEntity invokeAlgorithm(@PathVariable String algorithmType, @PathVariable String algorithm){

        log.info("AlgorithmsRestController.testAlgorithm  -  Invoking Algorithm");
        String output = algorithmFacade.invokeAlgorithm(algorithmType, algorithm);

        return new ResponseEntity(output, HttpStatus.OK);
    }

    @RequestMapping(value = "/load-algorithm-config", method = RequestMethod.GET)
    public ResponseEntity loadAlgorithmConfig(){

        log.info("AlgorithmsRestController.loadAlgorithmConfig  -  Invoking Algorithm");
        String output = algorithmFacade.getAlgorithmConfig();

        return new ResponseEntity(output, HttpStatus.OK);
    }

}
