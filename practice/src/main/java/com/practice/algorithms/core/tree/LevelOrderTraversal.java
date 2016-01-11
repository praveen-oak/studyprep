package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal implements IAlgorithm
{

    private static Logger log = Logger.getLogger(LevelOrderTraversal.class);

    private BinarySearchTree binarySearchTree;

    private Queue<TreeNode> queue;

    private Queue<SpiralNode> spiralQueue;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("LevelOrderTraversal.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));
            queue = new LinkedList<TreeNode>();
            spiralQueue = new LinkedList<SpiralNode>();

        } catch (Exception e) {

            log.error("LevelOrderTraversal.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        return spiralLevelOrderTraversal();
//        return levelOrderTraversal();
    }

    private String levelOrderTraversal() {

        String levelOrder = "";
        TreeNode node = binarySearchTree.getRoot();

        queue.add(node);

        while (!queue.isEmpty()) {

            node = queue.poll();
            levelOrder += node.getData() + " -> ";

            if (node.getLeftChild() != null) queue.add(node.getLeftChild());
            if (node.getRightChild() != null) queue.add(node.getRightChild());
        }

        return "Level Order Traversal: " + levelOrder;

    }

    private String spiralLevelOrderTraversal() {

        String levelOrder = "";
        TreeNode node = binarySearchTree.getRoot();

        int level = 0;
        boolean binarySwitch = false;

        SpiralNode spiralNode = new SpiralNode(node, level);
        SpiralNode prvNode = spiralNode;
        spiralQueue.add(spiralNode);

        while (!spiralQueue.isEmpty()) {

            spiralNode = spiralQueue.poll();
            levelOrder += spiralNode.node.getData() + ":" + spiralNode.level + " -> ";

            if (prvNode.level != spiralNode.level) {

                log.info("--------->> Level Changed -->> " + prvNode.node.getData() + ":" + prvNode.level + " - " + spiralNode.node.getData() + ":" + spiralNode.level);
                binarySwitch = !binarySwitch;
            }


            if (binarySwitch) {

                if (spiralNode.node.getLeftChild() != null) spiralQueue.add(
                        new SpiralNode(spiralNode.node.getLeftChild(), spiralNode.level+1));

                if (spiralNode.node.getRightChild() != null) spiralQueue.add(
                        new SpiralNode(spiralNode.node.getRightChild(), spiralNode.level+1));

            } else {

                if (spiralNode.node.getRightChild() != null) spiralQueue.add(
                        new SpiralNode(spiralNode.node.getRightChild(), spiralNode.level+1)
                );

                if (spiralNode.node.getLeftChild() != null) spiralQueue.add(
                        new SpiralNode(spiralNode.node.getLeftChild(), spiralNode.level+1)
                );
            }

            prvNode = spiralNode;
        }

        return "Spiral Level Order Traversal: " + levelOrder;

    }

    private class SpiralNode {

        public TreeNode node;

        public int level;

        private SpiralNode(TreeNode node, int level) {

            this.node = node;
            this.level = level;
        }
    }
}
