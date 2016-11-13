package com.dataStructure;

public class BinaryTreeNode<T extends Comparable<T>> {

	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;
	private BinaryTreeNode<T> parent;
	private int level;
	private T value;

	public BinaryTreeNode(T key) {
		this.setValue(key);
	}

	public int getLevel() {
		return level;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode<T> parent) {
		this.parent = parent;
		updateLevel(this);
	}

	private void updateLevel(BinaryTreeNode<T> node) {
		node.level = node.parent.getLevel() + 1;
		if(node.leftChild != null) updateLevel(node.getLeftChild());
		if(node.rightChild != null) updateLevel(node.getRightChild());
	}

}
