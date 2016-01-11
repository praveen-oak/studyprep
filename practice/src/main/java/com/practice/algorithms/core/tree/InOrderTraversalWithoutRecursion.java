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
import java.util.Stack;

public class InOrderTraversalWithoutRecursion implements IAlgorithm
{

    private static Logger log = Logger.getLogger(InOrderTraversalWithoutRecursion.class);

    private BinarySearchTree binarySearchTree;

    private List<Integer> traversal;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("InOrderTraversalWithoutRecursion.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));
            traversal = new LinkedList<Integer>();

        } catch (Exception e) {

            log.error("InOrderTraversalWithoutRecursion.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        inOrderTraversalWithStack(binarySearchTree.getRoot());

        return "InOrderTraversal: " + traversal.toString() + " - Please do the solution without recursion and without stack too.";
    }

    private void inOrderTraversalWithStack(TreeNode node) {

        Stack<TreeNode> traversalStack = new Stack<TreeNode>();
        traversalStack.push(node);

        while (!traversalStack.empty()) {

            if (node.getLeftChild() != null) {

                node = node.getLeftChild();
                traversalStack.push(node);

            } else {

                node = traversalStack.pop();
                traversal.add(node.getData());

                if (node.getRightChild() != null) {

                    node = node.getRightChild();
                    traversalStack.push(node);
                }
            }
        }
    }

    private void inOrderTraversalWithoutStack(TreeNode node) {

    }
}
