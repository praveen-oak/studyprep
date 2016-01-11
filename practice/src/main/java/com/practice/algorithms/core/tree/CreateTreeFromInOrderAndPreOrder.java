package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class CreateTreeFromInOrderAndPreOrder implements IAlgorithm
{

    private static Logger log = Logger.getLogger(RootToLeafPathSum.class);

    private static int preIndex = 0;

    private List<Integer> inOrder;

    private List<Integer> preOrder;

    private List<Integer> traversal;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("RootToLeafPathSum.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            JSONObject inputData = input.getJSONObject(ResponseKeys.INPUT);

            inOrder = CommonHelper.convertIntegerStringToList(inputData.getString("inOrder"));
            preOrder = CommonHelper.convertIntegerStringToList(inputData.getString("preOrder"));
            traversal = new LinkedList<Integer>();

        } catch (Exception e) {

            log.error("RootToLeafPathSum.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        TreeNode root = createBinaryTree(0, inOrder.size()-1);
        postOrder(root);

        return "PostOrderTraversal: " + traversal.toString();
    }

    private TreeNode createBinaryTree(int inStart, int inEnd) {

        if (inStart > inEnd) return null;

        int nodeData = preOrder.get(preIndex++);
        TreeNode node = createNode(nodeData);

        if (inStart == inEnd) return node;

        int nodeIndex = findNodeIndex(nodeData, inStart, inEnd);

        node.setLeftChild(createBinaryTree(inStart, nodeIndex-1));
        node.setRightChild(createBinaryTree(nodeIndex+1, inEnd));

        return node;
    }

    private void postOrder(TreeNode node) {

        if (node == null) return;

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        traversal.add(node.getData());

    }

    private TreeNode createNode(int data) {

        TreeNode node = new TreeNode();
        node.setData(data);

        return node;
    }

    private int findNodeIndex(int data, int start, int end) {

        int index = 0;

        for (int i=start; i<=end; i++) {

            if (inOrder.get(i) == data) return i;
        }
        return -1;
    }
}
