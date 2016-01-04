package com.practice.algorithms.facades;

import com.practice.algorithms.constants.CommonKeys;
import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.dummy.DummyAlgorithm;
import com.practice.algorithms.utils.AlgorithmProperties;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.lang.reflect.Method;

public class AlgorithmFacade implements IAlgorithmFacade
{

    private static Logger log = Logger.getLogger(AlgorithmFacade.class);

    private final String invokePackage;

    public AlgorithmFacade(String invokePackage) {

        this.invokePackage = invokePackage;
    }

    @Autowired
    private DummyAlgorithm dummyAlgorithm;

    @Autowired
    private CommonHelper commonHelper;

    @Autowired
    private AlgorithmProperties properties;

    @Override
    public String testFacade() {

        log.info("AlgorithmFacade.testFacade  -  Testing facade !!");
        return dummyAlgorithm.run(new JSONObject());
    }

    @Override
    public String invokeAlgorithm(String algorithmType, String algorithm) {

        try {

            JSONObject input = commonHelper.getJsonInput(algorithmType, algorithm);

            Class algorithmClass = Class.forName(
                    invokePackage + CommonKeys.PACKAGE_SEPARATOR + algorithmType + CommonKeys.PACKAGE_SEPARATOR + algorithm
            );

            Object algorithmObject = algorithmClass.newInstance();

            Method trigger = algorithmClass.getMethod(CommonKeys.ADAPTER_METHOD, JSONObject.class);

            return (String)trigger.invoke(algorithmObject, input);

        } catch (Exception e) {

            log.error("AlgorithmFacade.invokeAlgorithm  -  Exception in invoking algorithm:" + algorithm, e);
        }

        return null;
    }

    @Override
    public String getAlgorithmConfig() {

        JSONObject algorithmConfig = new JSONObject();

        try {

            algorithmConfig.put(ResponseKeys.ALGORITHM_TYPES_KEY, getAlgorithmTypes());
            algorithmConfig.put(ResponseKeys.ALGORITHM_LIST_KEY, getAlgorithms());

        } catch (Exception e) {

            log.error("AlgorithmFacade.getAlgorithmConfig  -  Exception in getting algorithm config.", e);
        }

        return algorithmConfig.toString();
    }

    private JSONArray getAlgorithmTypes() {

        JSONArray algorithmOptionsJson = new JSONArray();

        try {

            String algorithmTypes[] = properties.getApplicationProperties().getProperty("algorithmTypes").split(CommonKeys.COMMA);


            for (int i=0; i<algorithmTypes.length; i++) {

                JSONObject algorithmOptionJson = new JSONObject();
                String algorithmOption[] = algorithmTypes[i].split(CommonKeys.COLON);

                algorithmOptionJson.put(ResponseKeys.OPTION_KEY, algorithmOption[0]);
                algorithmOptionJson.put(ResponseKeys.OPTION_VALUE, algorithmOption[1]);

                algorithmOptionsJson.put(algorithmOptionJson);
            }

            log.info(algorithmOptionsJson.toString());

        } catch (Exception e) {

            log.error("AlgorithmFacade.getAlgorithmTypes  -  Exception in getting algorithm types.", e);
        }

        return algorithmOptionsJson;

    }

    private JSONObject getAlgorithms() {

        JSONObject algorithmConfig = new JSONObject();

        try {

            String inputPath = properties.getApplicationProperties().getProperty("inputPath");
            File folder = new File(inputPath);
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {

                if (listOfFiles[i].isDirectory()) {

                    String algorithmType = listOfFiles[i].getName().trim();
                    File algorithmInputFolder = new File(inputPath + algorithmType + "/");
                    File[] listOfInputFiles = algorithmInputFolder.listFiles();
                    JSONArray algorithms = new JSONArray();

                    for (int j = 0; j < listOfInputFiles.length; j++) {

                        String inputFile = listOfInputFiles[j].getName();

                        if (inputFile.contains(".json")) {

                            JSONObject algorithm = new JSONObject();

                            inputFile = commonHelper.splitJsonFileType(inputFile.trim());
                            algorithm.put(ResponseKeys.OPTION_KEY, inputFile);
                            algorithm.put(ResponseKeys.OPTION_VALUE, inputFile);

                            algorithms.put(algorithm);
                        }
                    }

                    algorithmConfig.put(algorithmType, algorithms);

                }
            }

        } catch (Exception e) {

            log.error("AlgorithmFacade.getAlgorithms  -  Exception in getting algorithms list.", e);
        }

        return algorithmConfig;
    }

}
