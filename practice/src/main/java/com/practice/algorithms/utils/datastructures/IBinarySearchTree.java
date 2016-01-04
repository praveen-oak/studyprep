package com.practice.algorithms.utils.datastructures;

import com.practice.algorithms.models.TreeNode;

import java.util.List;

public interface IBinarySearchTree
{

    public TreeNode getRoot();

    public void insert(int data);

    public void delete(TreeNode node);

    public void delete(int data);

    public List<Integer> getPreOrder();

    public List<Integer> getInOrder();

    public List<Integer> getPostOrder();

    public boolean isLeaf(TreeNode node);

    public boolean hasOnlyOneChild(TreeNode node);

    public boolean hasBothChild(TreeNode node);

    public TreeNode inOrderSuccessor(TreeNode node);
}
