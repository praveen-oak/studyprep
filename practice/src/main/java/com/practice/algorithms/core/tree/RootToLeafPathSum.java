package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.models.TreeNode;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class RootToLeafPathSum implements IAlgorithm
{

    private static Logger log = Logger.getLogger(RootToLeafPathSum.class);

    private BinarySearchTree binarySearchTree;

    private int sum;

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
            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(inputData.getString("tree"));
            sum = inputData.getInt("sum");

        } catch (Exception e) {

            log.error("RootToLeafPathSum.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        return "IsSumPathExists: " + isSumPathExists(binarySearchTree.getRoot(), sum);
    }

    private boolean isSumPathExists(TreeNode node, int sum) {

        if (node == null) return false;

        sum = sum - node.getData();

        if (sum == 0 && node.getLeftChild() == null && node.getRightChild() == null) return true;

        return isSumPathExists(node.getLeftChild(), sum) || isSumPathExists(node.getRightChild(), sum);
    }

}
