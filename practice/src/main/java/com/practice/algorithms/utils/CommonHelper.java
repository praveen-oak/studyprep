package com.practice.algorithms.utils;

import com.practice.algorithms.constants.CommonKeys;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import com.practice.algorithms.utils.datastructures.CircularLinkedList;
import com.practice.algorithms.utils.datastructures.DoublyLinkedList;
import com.practice.algorithms.utils.datastructures.SinglyLinkedList;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonHelper
{

    private static Logger log = Logger.getLogger(CommonHelper.class);

    private String inputPath;


    public CommonHelper(String inputPath) {

        this.inputPath = inputPath;
    }

    public JSONObject getJsonInput(String algorithmType, String fileName) {

        try {

            String file = inputPath + algorithmType + CommonKeys.DIRECTORY_SEPARATOR + fileName + CommonKeys.JSON;
            InputStream is = new FileInputStream(file);
            String jsonTxt = IOUtils.toString(is);
            JSONObject jsonInput = new JSONObject(jsonTxt);

            return jsonInput;

        } catch (Exception e) {

            log.error("CommonHelper.getJsonInput  -  Exception in loading json input from file:" + fileName, e);
        }

        return null;
    }

    public String splitJsonFileType(String jsonFileName) {

        String fileName = null;
        String pattern = "(\\w+)\\.json";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(jsonFileName);

        if (m.find( )) {
            fileName = m.group(1);
        }

        return fileName;
    }

    public static List<Integer> convertIntegerStringToList(String integerString) {

        String integerStringArray[] = integerString.split(CommonKeys.COMMA);
        List <Integer> integerList = new ArrayList<Integer>();

        for (int i=0; i<integerStringArray.length; i++) {

            integerList.add(Integer.parseInt(integerStringArray[i].trim()));
        }

        return integerList;

    }

    public static SinglyLinkedList<String> convertStringToSinglyLinkedList(String integerString) {

        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        String integerStringArray[] = integerString.split(CommonKeys.COMMA);

        for (int i=0; i<integerStringArray.length; i++) {

            singlyLinkedList.insert(integerStringArray[i].trim());
        }

        return singlyLinkedList;
    }

    public static DoublyLinkedList<String> convertStringToDoublyLinkedList(String integerString) {

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
        String integerStringArray[] = integerString.split(CommonKeys.COMMA);

        for (int i=0; i<integerStringArray.length; i++) {

            doublyLinkedList.insert(integerStringArray[i].trim());
        }

        return doublyLinkedList;
    }

    public static CircularLinkedList<String> convertStringToCircularLinkedList(String integerString) {

        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<String>();
        String integerStringArray[] = integerString.split(CommonKeys.COMMA);

        for (int i=0; i<integerStringArray.length; i++) {

            circularLinkedList.insert(integerStringArray[i].trim());
        }

        return circularLinkedList;
    }

    public static BinarySearchTree convertStringToBinarySearchTree(String integerString) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        List<Integer> treeData = convertIntegerStringToList(integerString);

        for (Integer data : treeData) {

            binarySearchTree.insert(data);
        }

        return binarySearchTree;
    }

}
