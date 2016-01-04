package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class IdenticalBinaryTrees implements IAlgorithm
{

    private static Logger log = Logger.getLogger(IdenticalBinaryTrees.class);

    private BinarySearchTree binarySearchTreeOne;

    private BinarySearchTree binarySearchTreeTwo;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("IdenticalBinaryTrees.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            JSONObject trees = input.getJSONObject(ResponseKeys.INPUT);

            binarySearchTreeOne = CommonHelper.convertStringToBinarySearchTree(trees.getString("treeOne"));
            binarySearchTreeTwo = CommonHelper.convertStringToBinarySearchTree(trees.getString("treeTwo"));

        } catch (Exception e) {

            log.error("IdenticalBinaryTrees.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        TreeNode rootOne = binarySearchTreeOne.getRoot();
        TreeNode rootTwo = binarySearchTreeTwo.getRoot();

        return "Identical: " + areIdentical(rootOne, rootTwo);
    }

    private boolean areIdentical(TreeNode nodeOne, TreeNode nodeTwo) {

        if (nodeOne == null && nodeTwo == null) {

            return true;

        } else if (nodeOne != null && nodeTwo != null){

            return nodeOne.getData() == nodeOne.getData() &&
                    areIdentical(nodeOne.getLeftChild(), nodeTwo.getLeftChild()) &&
                    areIdentical(nodeOne.getRightChild(), nodeTwo.getRightChild());

        } else {

            return false;

        }

    }
}
