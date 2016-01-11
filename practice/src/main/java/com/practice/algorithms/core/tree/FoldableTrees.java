package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class FoldableTrees implements IAlgorithm
{
    private static Logger log = Logger.getLogger(FoldableTrees.class);

    private BinarySearchTree binarySearchTree;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("FoldableTrees.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("FoldableTrees.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        binarySearchTree.getInOrder();
        mirror(binarySearchTree.getRoot().getLeftChild());
        binarySearchTree.getInOrder();

        return "Is Foldable: " + areIdentical(binarySearchTree.getRoot().getLeftChild(), binarySearchTree.getRoot().getRightChild());
    }

    private void mirror(TreeNode node) {

        if (node == null) return;

        mirror(node.getLeftChild());
        mirror(node.getRightChild());

        TreeNode tmp = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(tmp);

    }

    private boolean areIdentical(TreeNode nodeOne, TreeNode nodeTwo) {

        if (nodeOne == null && nodeTwo == null) return true;

        if (nodeOne != null && nodeTwo != null && areIdentical(nodeOne.getLeftChild(), nodeTwo.getLeftChild()) &&
                areIdentical(nodeOne.getRightChild(), nodeTwo.getRightChild())) {

            return true;
        }

        return false;
    }

}
