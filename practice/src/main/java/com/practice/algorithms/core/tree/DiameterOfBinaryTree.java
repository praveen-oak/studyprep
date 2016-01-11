package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class DiameterOfBinaryTree implements IAlgorithm
{
    private static Logger log = Logger.getLogger(DiameterOfBinaryTree.class);

    private TreeNode root;

    private List<Integer> traversal;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("DiameterOfBinaryTree.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            traversal = new LinkedList<Integer>();

            root = newNode(1);
            root.setLeftChild(newNode(2));
            root.setRightChild(newNode(3));
            root.getLeftChild().setLeftChild(newNode(4));
            root.getLeftChild().setRightChild(newNode(5));
//            root.getRightChild().setLeftChild(newNode(2));

        } catch (Exception e) {

            log.error("DiameterOfBinaryTree.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        return "MaxDiameter: " + maxDiameter(root) + " - Please implement optimized solution too.";
    }

    private int maxDiameter(TreeNode node) {

        if (node == null) return 0;

        int lDiameter = maxDiameter(node.getLeftChild());
        int rDiameter = maxDiameter(node.getRightChild());
        int lHeight = height(node.getLeftChild());
        int rHeight = height(node.getRightChild());

        return max(lHeight + rHeight + 1, max(lDiameter, rDiameter));
    }

    private int height(TreeNode node) {

        if (node == null) return 0;

        return max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
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

    private int max(int x, int y) {

        return x > y ? x : y;
    }

}
