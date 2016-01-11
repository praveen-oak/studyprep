package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class LeafNodeCount implements IAlgorithm
{

    private static Logger log = Logger.getLogger(LeafNodeCount.class);

    private BinarySearchTree binarySearchTree;

    private int leafNodeCount;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("LeafNodeCount.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));
            leafNodeCount = 0;

        } catch (Exception e) {

            log.error("LeafNodeCount.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        TreeNode root = binarySearchTree.getRoot();
        preOrderTraversal(root);

        return "Leaf Node Count: " + leafNodeCount;
    }

    private void preOrderTraversal(TreeNode node) {

        if (node == null) return;
        if (node.getLeftChild() == null && node.getRightChild() == null) leafNodeCount++;

        preOrderTraversal(node.getLeftChild());
        preOrderTraversal(node.getRightChild());

    }

}
