package com.practice.algorithms.utils.datastructures;

import com.practice.algorithms.models.TreeNode;
import org.apache.log4j.Logger;

import java.util.*;

public class BinarySearchTree implements IBinarySearchTree
{

    private static Logger log = Logger.getLogger(BinarySearchTree.class);

    private TreeNode root;

    private List<Integer> traversal;

    @Override
    public TreeNode getRoot() {

        return root;
    }

    @Override
    public void insert(int data) {

        TreeNode newNode = new TreeNode();
        newNode.setData(data);

        if (root == null) {

            root = newNode;
        } else {

            root = insert(root, newNode);
        }
    }

    @Override
    public void delete(TreeNode node) {

        if (node == null) {

            log.info("BinarySearchTree.delete  -  Given node cannot be deleted");
        } else {

            deleteNode(root, node);
        }
    }

    @Override
    public void delete(int data) {

        log.info("BinarySearchTree.delete  -  Implementation not found");
    }

    @Override
    public List<Integer> getPreOrder() {

        traversal = new LinkedList<Integer>();
        preOrder(root);
        log.info("BinarySearchTree.getPreOrder  -  Pre Order Traversal: " + traversal.toString());

        return traversal;
    }

    @Override
    public List<Integer> getInOrder() {

        traversal = new LinkedList<Integer>();
        inOrder(root);
        log.info("BinarySearchTree.getInOrder  -  In Order Traversal: " + traversal.toString());

        return traversal;
    }

    @Override
    public List<Integer> getPostOrder() {

        traversal = new LinkedList<Integer>();
        postOrder(root);
        log.info("BinarySearchTree.getPostOrder  -  Post Order Traversal: " + traversal.toString());

        return traversal;
    }

    @Override
    public boolean isLeaf(TreeNode node) {

        return
                node.getLeftChild() == null && node.getRightChild() == null ?
                        true : false;
    }

    @Override
    public boolean hasOnlyOneChild(TreeNode node) {

        return
                (node.getLeftChild() == null && node.getRightChild() != null) ||
                        (node.getLeftChild() != null && node.getRightChild() == null) ?
                        true : false;
    }

    @Override
    public boolean hasBothChild(TreeNode node) {

        return
                node.getLeftChild() != null && node.getRightChild() != null ?
                        true : false;
    }

    @Override
    public TreeNode inOrderSuccessor(TreeNode node) {

        TreeNode successor;

        if (node.getRightChild() != null) {

            successor = minValue(node.getRightChild());

        } else {

            TreeNode parent = node.getParent();

            while (parent != null && node == parent.getRightChild()) {

                node = parent;
                parent = node.getParent();
            }

            successor = parent;
        }

        return successor;
    }

    private TreeNode insert(TreeNode node, TreeNode newNode) {

        if (node == null) {

            return newNode;
        }

        newNode.setParent(node);

        if (newNode.getData() < node.getData()) {

            node.setLeftChild(
                    insert(node.getLeftChild(), newNode)
            );

        } else {

            node.setRightChild(
                    insert(node.getRightChild(), newNode)
            );
        }

        return node;
    }

    private void preOrder(TreeNode node) {

        if (node == null) return;

        traversal.add(node.getData());
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());

    }

    private void inOrder(TreeNode node) {

        if (node == null) return;

        inOrder(node.getLeftChild());
        traversal.add(node.getData());
        inOrder(node.getRightChild());

    }

    private void postOrder(TreeNode node) {

        if (node == null) return;

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        traversal.add(node.getData());

    }

    private TreeNode deleteNode(TreeNode traverseNode, TreeNode node) {

        if (traverseNode == null) {

            return null;

        } else  if (node.getData() < traverseNode.getData()) {

            traverseNode.setLeftChild(deleteNode(traverseNode.getLeftChild(), node));

        } else if (node.getData() > traverseNode.getData()) {

            traverseNode.setRightChild(deleteNode(traverseNode.getRightChild(), node));

        } else {

            if (isLeaf(traverseNode)) {

                return null;

            } else if (hasOnlyOneChild(traverseNode)) {

                if (traverseNode.getLeftChild() != null) {

                    traverseNode.getLeftChild().setParent(traverseNode.getParent());
                    return traverseNode.getLeftChild();

                } else {

                    traverseNode.getRightChild().setParent(traverseNode.getParent());
                    return traverseNode.getRightChild();

                }

            } else {

                TreeNode inOrderSuccessor = minValue(traverseNode.getRightChild());
                traverseNode.setData(inOrderSuccessor.getData());

                traverseNode.setRightChild(deleteNode(traverseNode.getRightChild(), inOrderSuccessor));

            }

        }

        return traverseNode;
    }

    private TreeNode minValue(TreeNode node) {

        TreeNode current = node;

        while (current.getLeftChild() != null) {

            current = current.getLeftChild();
        }

        return current;
    }

}
