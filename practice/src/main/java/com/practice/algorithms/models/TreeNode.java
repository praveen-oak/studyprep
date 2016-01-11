package com.practice.algorithms.models;

public class TreeNode
{

    private Integer data;

    private TreeNode parent;

    private TreeNode leftChild;

    private TreeNode rightChild;

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {

        String parent = (this.parent == null ? "" : this.parent.getData().toString());
        String leftChild = (this.leftChild == null ? "" : this.leftChild.getData().toString());
        String rightChild = (this.rightChild == null ? "" : this.rightChild.getData().toString());

        return "TreeNode{" +
                "data=" + data +
                ", parent=" + parent +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }

}
