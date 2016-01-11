package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class ArbitraryBinaryTreeToChildrenSumTree implements IAlgorithm
{
    private static Logger log = Logger.getLogger(ArbitraryBinaryTreeToChildrenSumTree.class);

    private TreeNode root;

    private List<Integer> traversal;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ArbitraryBinaryTreeToChildrenSumTree.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            traversal = new LinkedList<Integer>();

            root = newNode(50);
            root.setLeftChild(newNode(7));
            root.setRightChild(newNode(2));
            root.getLeftChild().setLeftChild(newNode(3));
            root.getLeftChild().setRightChild(newNode(5));
            root.getRightChild().setLeftChild(newNode(1));
            root.getRightChild().setRightChild(newNode(30));

        } catch (Exception e) {

            log.error("ArbitraryBinaryTreeToChildrenSumTree.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        inOrderTraversal(root);
        log.info(traversal.toString());

        convertToChildrenSumTree(root);
        traversal = new LinkedList<Integer>();
        inOrderTraversal(root);
        log.info(traversal.toString());

        return traversal.toString();
    }

    private int convertToChildrenSumTree(TreeNode node) {

        if (node == null) return 0;

        int childrenSum = convertToChildrenSumTree(node.getLeftChild()) + convertToChildrenSumTree(node.getRightChild());

        if (childrenSum > node.getData()) {

            node.setData(childrenSum);
            return childrenSum;

        } else {

            if (node.getLeftChild() != null) {

                incrementSum(node.getLeftChild(), node.getData() - childrenSum);

            } else if (node.getRightChild() != null) {

                incrementSum(node.getRightChild(), node.getData() - childrenSum);
            }

            return node.getData();
        }

    }

    private void incrementSum(TreeNode node, int incrementValue) {

        if (node == null) return;

        node.setData(node.getData() + incrementValue);

        if (node.getLeftChild() != null) {

            incrementSum(node.getLeftChild(), incrementValue);
        } else {

            incrementSum(node.getRightChild(), incrementValue);
        }
    }

    private TreeNode newNode(int data) {

        TreeNode node = new TreeNode();
        node.setData(data);

        return node;
    }

    private void inOrderTraversal(TreeNode node) {

        if (node == null) return;

        inOrderTraversal(node.getLeftChild());
        traversal.add(node.getData());
        inOrderTraversal(node.getRightChild());
    }

}