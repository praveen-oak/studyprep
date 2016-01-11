package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class MaximumWidthOfBinaryTree implements IAlgorithm
{

    private static Logger log = Logger.getLogger(MaximumWidthOfBinaryTree.class);

    private BinarySearchTree binarySearchTree;

    private List<Integer> count;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("MaximumWidthOfBinaryTree.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));
            count = new LinkedList<Integer>();

        } catch (Exception e) {

            log.error("MaximumWidthOfBinaryTree.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        populateWidth(binarySearchTree.getRoot(), 0);
        return "Max Width: " + getMaxElement();
    }

    private void populateWidth(TreeNode node, int level) {

        if (node == null) return;

        if (indexExists(level)) {

            int newCount = count.get(level) + 1;
            count.set(level, newCount);

        } else {

            count.add(level, 1);
        }

        populateWidth(node.getLeftChild(), level+1);
        populateWidth(node.getRightChild(), level+1);
    }

    private boolean indexExists(int i) {

        return (i < count.size()) ? true : false;
    }

    private int getMaxElement() {

        int maxElement = -1;
        for (Integer element : count) {

            if (element > maxElement) maxElement = element;
        }

        return maxElement;
    }
}
