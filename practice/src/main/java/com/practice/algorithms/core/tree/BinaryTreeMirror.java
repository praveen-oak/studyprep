package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class BinaryTreeMirror implements IAlgorithm
{

    private static Logger log = Logger.getLogger(BinaryTreeMirror.class);

    private BinarySearchTree binarySearchTree;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("BinaryTreeMirror.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("BinaryTreeMirror.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        TreeNode root = binarySearchTree.getRoot();
        String normalTree = "Normal Tree: " + binarySearchTree.getInOrder().toString();
        mirror(root);
        String mirrorTree = "Mirror Tree: " + binarySearchTree.getInOrder().toString();

        return normalTree + " | " + mirrorTree;
    }

    private void mirror(TreeNode node) {

        if (node == null) return;

        mirror(node.getLeftChild());
        mirror(node.getRightChild());

        TreeNode tmp = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(tmp);

    }

}
