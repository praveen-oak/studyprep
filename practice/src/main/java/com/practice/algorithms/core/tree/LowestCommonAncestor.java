package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class LowestCommonAncestor implements IAlgorithm
{

    private static Logger log = Logger.getLogger(LowestCommonAncestor.class);

    private BinarySearchTree binarySearchTree;
    private Integer nodeOne;
    private Integer nodeTwo;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("LowestCommonAncestor.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            JSONObject inputData = input.getJSONObject(ResponseKeys.INPUT);
            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(inputData.getString("tree"));
            nodeOne = inputData.getInt("nodeOne");
            nodeTwo = inputData.getInt("nodeTwo");

        } catch (Exception e) {

            log.error("LowestCommonAncestor.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        TreeNode root = binarySearchTree.getRoot();
        binarySearchTree.getInOrder();

        return "Lowest Common Ancestor: " + lowestCommonAncestorIterative(root);
    }

    private Integer lowestCommonAncestor(TreeNode node) {

        if (node == null) {

            return -1;
        }

        if (node.getData() == nodeOne || node.getData() == nodeTwo) {

            log.info("LowestCommonAncestor.lowestCommonAncestor  -  Found ->" + node.getData());
            return node.getData();
        } else if (nodeOne < node.getData() && nodeTwo > node.getData()) {

            log.info("LowestCommonAncestor.lowestCommonAncestor  -  Found ->>" + node.getData());
            return node.getData();
        } else if (node.getData() > nodeOne && node.getData() > nodeTwo) {

            log.info("LowestCommonAncestor.lowestCommonAncestor  -  Processing_1 ->>" + node.getData());
            return lowestCommonAncestor(node.getLeftChild());
        } else if (node.getData() < nodeOne && node.getData() < nodeTwo){

            log.info("LowestCommonAncestor.lowestCommonAncestor  -  Processing_2 ->>" + node.getData());
            return lowestCommonAncestor(node.getRightChild());
        } else {

            log.info("LowestCommonAncestor.lowestCommonAncestor  -  Processing_3 ->>" + node.getData());
        }

        return -1;
    }

    private Integer lowestCommonAncestorIterative(TreeNode node) {

        while (node != null) {

            if (node.getData() > nodeOne && node.getData() > nodeTwo) {

                node = node.getLeftChild();
            } else if (node.getData() < nodeOne && node.getData() < nodeTwo) {

                node = node.getRightChild();
            } else {

                return node.getData();
            }

        }

        return -1;
    }

}
