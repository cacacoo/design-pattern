package com.dataStructure;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T>{

	private BinaryTreeNode<T> root;
	private int nodeCount;
	private int treeHeight;

	public BinarySearchTree(List<T> values) {
		values.stream().forEach(this::save);
	}

	@Override
	public int height() {
		return treeHeight;
	}

	@Override
	public long totalNode() {
		return nodeCount;
	}

	@Override
	public void save(T key) {
		BinaryTreeNode<T> node = new BinaryTreeNode<>(key);
		if(root == null) {
			initRoot(node);
			return;
		}
		updateNode(root, node);
	}

	private void initRoot(BinaryTreeNode<T> node) {
		root = node;
		treeHeight = 0;
		nodeCount = 1;
	}

	private void updateNode(BinaryTreeNode<T> comparator, BinaryTreeNode<T> node) {
		int result = node.getValue().compareTo(comparator.getValue());
		if(result == 0) return;

		if(result > 0) {
			if(comparator.getRightChild() == null) {
				comparator.setRightChild(node);
				setChild(comparator, node);
				return;
			}
			updateNode(comparator.getRightChild(), node);
		}else {
			if(comparator.getLeftChild() == null) {
				comparator.setLeftChild(node);
				setChild(comparator, node);
				return;
			}
			updateNode(comparator.getLeftChild(), node);
		}
	}

	private void setChild(BinaryTreeNode<T> comparator, BinaryTreeNode<T> node) {
		node.setParent(comparator);
		node.setLevel(comparator.getLevel()+1);
		nodeCount++;
		updateTreeHeight(node);
	}

	private void updateTreeHeight(BinaryTreeNode<T> node) {
		treeHeight = treeHeight > node.getLevel() ? treeHeight : node.getLevel();
	}

	@Override
	public void delete(T key) {

	}

	public void traversal(TraversalType traversalType) {
		Map<BinaryTreeNode<T>, T> binaryTreeNodeMap = Maps.newLinkedHashMap();
		switch (traversalType) {
			case POSTORDER:

				break;
			case PREORDER:
				preorderTraversal(root, binaryTreeNodeMap);
				break;
			case INORDER:
				inorderTraversal(root, binaryTreeNodeMap);
				break;
		}
	}

	private Map<BinaryTreeNode<T>, T> inorderTraversal(BinaryTreeNode<T> node, Map<BinaryTreeNode<T>, T> map) {
		if(nodeCount == map.size()) {
			return map;
		}

		BinaryTreeNode<T> parent = node.getParent();
		BinaryTreeNode<T> leftChild = node.getLeftChild();
		BinaryTreeNode<T> rightChild = node.getRightChild();
		if(!map.containsKey(node)) {
			map.put(node, node.getValue());
			System.out.println(node.getValue());

			if(traversable(map, leftChild)) {
				inorderTraversal(leftChild,map);
			} else if(traversable(map, rightChild)) {
				inorderTraversal(rightChild,map);
			}
			inorderTraversal(parent,map);
		} else {
			if(traversable(map, rightChild)) {
				inorderTraversal(rightChild,map);
			} else {
				inorderTraversal(parent,map);
			}
		}
		return map;
	}

	private Map<BinaryTreeNode<T>, T> preorderTraversal(BinaryTreeNode<T> node, Map<BinaryTreeNode<T>, T> map) {
		if(nodeCount == map.size()) {
			return map;
		}

		BinaryTreeNode<T> parent = node.getParent();
		BinaryTreeNode<T> leftChild = node.getLeftChild();
		BinaryTreeNode<T> rightChild = node.getRightChild();
		if(traversable(map,leftChild)) {
			preorderTraversal(leftChild, map);
		}else {
			map.put(node, node.getValue());
			System.out.println(node.getValue());

			if(traversable(map, rightChild)) {
				preorderTraversal(rightChild,map);
			}
			preorderTraversal(parent,map);
		}
		return map;
	}

	private boolean traversable(Map<BinaryTreeNode<T>, T> map, BinaryTreeNode<T> node) {
		return node != null && !map.containsKey(node);
	}
}
