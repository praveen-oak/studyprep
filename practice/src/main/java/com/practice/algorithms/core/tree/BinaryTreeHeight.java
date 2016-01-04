package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class BinaryTreeHeight implements IAlgorithm
{

    private static Logger log = Logger.getLogger(BinaryTreeHeight.class);

    private BinarySearchTree binarySearchTree;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("BinaryTreeHeight.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("BinaryTreeHeight.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        TreeNode root = binarySearchTree.getRoot();

        return "Height: " + height(root);
    }

    private int height(TreeNode node) {

        if (node == null) {

            return 0;
        }

        return max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
    }

    private int max (int x, int y) {

        return x > y ? x : y;
    }
}
