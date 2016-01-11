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

public class RootToLeafPaths implements IAlgorithm
{
    private static Logger log = Logger.getLogger(RootToLeafPaths.class);

    private BinarySearchTree binarySearchTree;

    private List<Integer> rootToLeafPath;

    private String rootToLeafPaths;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("RootToLeafPaths.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));
            rootToLeafPath = new LinkedList<Integer>();
            rootToLeafPaths = "";

        } catch (Exception e) {

            log.error("RootToLeafPaths.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        TreeNode root = binarySearchTree.getRoot();
        printRootToLeafPaths(root, 0);

        return rootToLeafPaths;
    }

    private void printRootToLeafPaths(TreeNode node, int level) {

        if (node == null) {

            return;
        }

        rootToLeafPath.add(level, node.getData());

        if (node.getLeftChild() == null && node.getRightChild() == null) {

            rootToLeafPaths += rootToLeafPath.toString();
        } else {

            printRootToLeafPaths(node.getLeftChild(), level + 1);
            printRootToLeafPaths(node.getRightChild(), level + 1);
        }

        rootToLeafPath.remove(level);

    }

}
