package com.practice.algorithms.core.tree;

import com.practice.algorithms.constants.ResponseKeys;
import com.practice.algorithms.core.IAlgorithm;
import com.practice.algorithms.utils.CommonHelper;
import com.practice.algorithms.utils.datastructures.BinarySearchTree;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class BinarySearchTreeTest implements IAlgorithm
{

    private static Logger log = Logger.getLogger(BinarySearchTreeTest.class);

    private BinarySearchTree binarySearchTree;

    @Override
    public String run(JSONObject input) {

        try {

            setInput(input);
            input.put(ResponseKeys.OUTPUT, runAlgorithm());

        } catch (Exception e) {

            log.error("BinarySearchTreeTest.run  -  Exception in running algorithm", e);
        }

        return input.toString();
    }

    @Override
    public void setInput(JSONObject input) {

        try {

            binarySearchTree = CommonHelper.convertStringToBinarySearchTree(input.getString(ResponseKeys.INPUT));

        } catch (Exception e) {

            log.error("BinarySearchTreeTest.setInput  -  Exception in setting input", e);
        }
    }

    private String runAlgorithm() {

        String preOrderTraversal = "Pre Order Traversal: " + binarySearchTree.getPreOrder().toString();
        String inOrderTraversal = "In Order Traversal: " + binarySearchTree.getInOrder().toString();
        String postOrderTraversal = "Post Order Traversal: " + binarySearchTree.getPostOrder().toString();

        log.info("R: " + binarySearchTree.getRoot().toString());
        log.info("LC: " + binarySearchTree.getRoot().getLeftChild().toString());
        log.info("RC: " + binarySearchTree.getRoot().getRightChild().toString());
        log.info("LLC: " + binarySearchTree.getRoot().getLeftChild().getLeftChild().toString());
        log.info("LRC: " + binarySearchTree.getRoot().getLeftChild().getRightChild().toString());

        log.info("InOrderSuccessor -> " + binarySearchTree.getRoot().getLeftChild().getData() + " : " +
                binarySearchTree.inOrderSuccessor(binarySearchTree.getRoot().getLeftChild()).getData()
        );

        log.info("InOrderSuccessor -> " + binarySearchTree.getRoot().getLeftChild().getRightChild().getData() + " : " +
                binarySearchTree.inOrderSuccessor(binarySearchTree.getRoot().getLeftChild().getRightChild()).getData()
        );

        log.info("InOrderSuccessor -> " + binarySearchTree.getRoot().getData() + " : " +
                binarySearchTree.inOrderSuccessor(binarySearchTree.getRoot()).getData()
        );

        log.info("IsLeaf -> " + binarySearchTree.getRoot().getLeftChild().getData() + " : " +
                binarySearchTree.isLeaf(binarySearchTree.getRoot().getLeftChild())
        );

        log.info("IsLeaf -> " + binarySearchTree.getRoot().getRightChild().getData() + " : " +
                binarySearchTree.isLeaf(binarySearchTree.getRoot().getRightChild())
        );

        log.info("HasOneChild -> " + binarySearchTree.getRoot().getLeftChild().getData() + " : " +
                binarySearchTree.hasOnlyOneChild(binarySearchTree.getRoot().getLeftChild())
        );

        log.info("HasOneChild -> " + binarySearchTree.getRoot().getRightChild().getData() + " : " +
                binarySearchTree.hasOnlyOneChild(binarySearchTree.getRoot().getRightChild())
        );

        log.info("HasTwoChild -> " + binarySearchTree.getRoot().getLeftChild().getData() + " : " +
                binarySearchTree.hasBothChild(binarySearchTree.getRoot().getLeftChild())
        );

        log.info("HasTwoChild -> " + binarySearchTree.getRoot().getRightChild().getData() + " : " +
                binarySearchTree.hasBothChild(binarySearchTree.getRoot().getRightChild())
        );

//        binarySearchTree.delete(binarySearchTree.getRoot());
        binarySearchTree.getPostOrder();
        binarySearchTree.delete(binarySearchTree.getRoot());
        binarySearchTree.getPostOrder();

        return preOrderTraversal + " <=> " + inOrderTraversal + " <=> " + postOrderTraversal +
                "  Check logs for more info !!";
    }

}
