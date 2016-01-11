package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class ChildrenSumProperty implements IAlgorithm
{

    private static Logger log = Logger.getLogger(ChildrenSumProperty.class);

    private TreeNode root;

    private List<Integer> traversal;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("ChildrenSumProperty.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            traversal = new LinkedList<Integer>();

            root = newNode(10);
            root.setLeftChild(newNode(8));
            root.setRightChild(newNode(3));
            root.getLeftChild().setLeftChild(newNode(3));
            root.getLeftChild().setRightChild(newNode(5));
            root.getRightChild().setLeftChild(newNode(2));

        } catch (Exception e) {

            log.error("ChildrenSumProperty.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        inOrderTraversal(root);
        log.info(traversal.toString());

        return "Children Sum Property: " + isChildrenSumPropertyHolds(root);
    }

    private boolean isChildrenSumPropertyHolds(TreeNode node) {

        if (node == null) return true;

        boolean childrenSum = isChildrenSumPropertyHolds(node.getLeftChild()) && isChildrenSumPropertyHolds(node.getRightChild());

        if (!childrenSum) return false;

        boolean nodeSum;

        if (node.getLeftChild() != null && node.getRightChild() != null) {

            nodeSum = (node.getData() == node.getLeftChild().getData() + node.getRightChild().getData());

        } else if (node.getLeftChild() != null) {

            nodeSum = (node.getData() == node.getLeftChild().getData());

        } else if (node.getRightChild() != null) {

            nodeSum = (node.getData() == node.getRightChild().getData());

        } else {

            nodeSum = true;
        }

        return nodeSum;
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

