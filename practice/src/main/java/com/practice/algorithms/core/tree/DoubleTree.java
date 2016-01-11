package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class DoubleTree implements IAlgorithm
{

    private static Logger log = Logger.getLogger(DoubleTree.class);

    private BinarySearchTree binarySearchTree;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("DoubleTree.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("DoubleTree.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {
        binarySearchTree.getInOrder();
        doubleTree(binarySearchTree.getRoot());
        binarySearchTree.getInOrder();

        return "InOrderOfDoubleTree: " + binarySearchTree.getInOrder().toString();
    }

    private void doubleTree(TreeNode node) {

        if (node == null) return;

        TreeNode oldNode = node.getLeftChild();
        TreeNode newNode = createNode(node.getData());

        node.setLeftChild(newNode);
        node.getLeftChild().setLeftChild(oldNode);
    }

    private TreeNode createNode(int data) {

        TreeNode node = new TreeNode();
        node.setData(data);

        return node;
    }

}
