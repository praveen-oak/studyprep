package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class CheckBalancingOfBinaryTree implements IAlgorithm
{

    private static Logger log = Logger.getLogger(CheckBalancingOfBinaryTree.class);

    private BinarySearchTree binarySearchTree;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("CheckBalancingOfBinaryTree.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("CheckBalancingOfBinaryTree.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        return "TreeIsBalanced: " + isBalanced(binarySearchTree.getRoot()) + " - Implement the optimized solution";
    }

    private boolean isBalanced(TreeNode node) {

        if (node == null) return true;

        int lHeight = height(node.getLeftChild());
        int rHeight = height(node.getRightChild());

        if (Math.abs(lHeight-rHeight) <= 1) return true;

        return false;
    }

    private int height(TreeNode node) {

        if (node == null) return 0;

        return max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
    }

    private int max(int x, int y) {

        return x > y ? x : y;
    }

}
