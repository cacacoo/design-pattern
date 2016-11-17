package com.dataStructure;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private BinaryTreeNode<T> root;
	private int nodeCount;

	public BinarySearchTree(List<T> values) {
		values.stream().forEach(this::save);
	}

	@Override
	public int height() {
		Map<BinaryTreeNode<T>, T> inorderTraversal = inorderTraversal(root, Maps.newLinkedHashMap());
		List<BinaryTreeNode> sortedByLevelList = inorderTraversal.keySet().stream()
			.sorted(comparing(BinaryTreeNode::getLevel))
			.collect(Collectors.toList());
		return sortedByLevelList.get(sortedByLevelList.size() - 1).getLevel();
	}

	@Override
	public long totalNode() {
		return nodeCount;
	}

	@Override
	public void save(T key) {
		BinaryTreeNode<T> node = new BinaryTreeNode<>(key);
		if (root == null) {
			initRoot(node);
			return;
		}
		updateNode(root, node);
	}

	private void initRoot(BinaryTreeNode<T> node) {
		root = node;
		nodeCount = 1;
	}

	private void updateNode(BinaryTreeNode<T> comparator, BinaryTreeNode<T> node) {
		int result = node.getValue().compareTo(comparator.getValue());
		if (result == 0)
			return;

		if (result > 0) {
			if (comparator.getRightChild() == null) {
				comparator.setRightChild(node);
				setChild(comparator, node);
				return;
			}
			updateNode(comparator.getRightChild(), node);
		} else {
			if (comparator.getLeftChild() == null) {
				comparator.setLeftChild(node);
				setChild(comparator, node);
				return;
			}
			updateNode(comparator.getLeftChild(), node);
		}
	}

	private void setChild(BinaryTreeNode<T> comparator, BinaryTreeNode<T> node) {
		node.setParent(comparator);
		nodeCount++;
	}

	@Override
	public void delete(T key) {
		if (key == null) {
			return;
		}

		BinaryTreeNode<T> node = find(key);
		if (node == null) {
			return;
		}

		if (isExternalNode(node)) {
			BinaryTreeNode<T> parent = node.getParent();
			BinaryTreeNode<T> newChild = null;
			if (parent.getLeftChild() == node) {
				newChild = findTempChild(node);
				parent.setLeftChild(newChild);
			} else if (parent.getRightChild() == node) {
				newChild = findTempChild(node);
				parent.setRightChild(newChild);
			}
			if (newChild != null) {
				newChild.setParent(node.getParent());
			}
		} else {
			Map<BinaryTreeNode<T>, T> treeNodeMap = inorderTraversal(root, Maps.newLinkedHashMap());
			Iterator<BinaryTreeNode<T>> it = treeNodeMap.keySet().iterator();
			BinaryTreeNode<T> newChild = null;
			while (it.hasNext()) {
				if (it.next() == node) {
					newChild = it.next();
				}
			}

			BinaryTreeNode<T> originLeftChild = node.getLeftChild();
			BinaryTreeNode<T> originRightChild = node.getRightChild();
			node.getParent().setRightChild(newChild);
			newChild.setParent(node.getParent());
			if (originRightChild != newChild) {
				originRightChild.setLeftChild(newChild.getRightChild());
				newChild.getRightChild().setParent(originRightChild);
			}
			newChild.setLeftChild(originLeftChild);
			newChild.setRightChild(originRightChild);
		}

		nodeCount--;
	}

	private BinaryTreeNode<T> findTempChild(BinaryTreeNode<T> node) {
		if (node.getLeftChild() != null) {
			return node.getLeftChild();
		} else if (node.getRightChild() != null) {
			return node.getRightChild();
		}
		return null;
	}

	private boolean isExternalNode(BinaryTreeNode<T> node) {
		return node.getLeftChild() == null || node.getRightChild() == null;
	}

	public BinaryTreeNode<T> find(T key) {
		return find(key, root);
	}

	private BinaryTreeNode<T> find(T key, BinaryTreeNode<T> node) {
		int result = node.getValue().compareTo(key);
		if (result == 0)
			return node;
		else if (result > 0) {
			if (node.getLeftChild() == null) {
				return null;
			}
			return find(key, node.getLeftChild());
		} else {
			if (node.getRightChild() == null) {
				return null;
			}
			return find(key, node.getRightChild());
		}
	}

	public List<T> traversal(TraversalType traversalType) {
		Map<BinaryTreeNode<T>, T> binaryTreeNodeMap = Maps.newLinkedHashMap();
		switch (traversalType) {
			case POSTORDER:
				binaryTreeNodeMap = postorderTraversal(root, binaryTreeNodeMap);
				break;
			case PREORDER:
				binaryTreeNodeMap = preorderTraversal(root, binaryTreeNodeMap);
				break;
			case INORDER:
				binaryTreeNodeMap = inorderTraversal(root, binaryTreeNodeMap);
				break;
		}
		return Lists.newArrayList(binaryTreeNodeMap.values());
	}

	private Map<BinaryTreeNode<T>, T> postorderTraversal(BinaryTreeNode<T> node, Map<BinaryTreeNode<T>, T> map) {
		if (nodeCount == map.size()) {
			return map;
		}

		BinaryTreeNode<T> parent = node.getParent();
		BinaryTreeNode<T> leftChild = node.getLeftChild();
		BinaryTreeNode<T> rightChild = node.getRightChild();
		BinaryTreeNode<T> sibling = parent != null ? parent.getRightChild() : null;
		if (traversable(map, leftChild)) {
			postorderTraversal(leftChild, map);
		} else {
			if (traversable(map, rightChild)) {
				postorderTraversal(rightChild, map);
			}

			if (!map.containsKey(node)) {
				map.put(node, node.getValue());
			}

			if (traversable(map, sibling)) {
				postorderTraversal(sibling, map);
			} else {
				postorderTraversal(parent, map);
			}
		}
		return map;
	}

	private Map<BinaryTreeNode<T>, T> preorderTraversal(BinaryTreeNode<T> node, Map<BinaryTreeNode<T>, T> map) {
		if (nodeCount == map.size()) {
			return map;
		}

		BinaryTreeNode<T> parent = node.getParent();
		BinaryTreeNode<T> leftChild = node.getLeftChild();
		BinaryTreeNode<T> rightChild = node.getRightChild();
		if (!map.containsKey(node)) {
			map.put(node, node.getValue());
			if (traversable(map, leftChild)) {
				preorderTraversal(leftChild, map);
			} else if (traversable(map, rightChild)) {
				preorderTraversal(rightChild, map);
			} else {
				preorderTraversal(parent, map);
			}
		} else {
			if (traversable(map, rightChild)) {
				preorderTraversal(rightChild, map);
			} else {
				preorderTraversal(parent, map);
			}
		}
		return map;
	}

	private Map<BinaryTreeNode<T>, T> inorderTraversal(BinaryTreeNode<T> node, Map<BinaryTreeNode<T>, T> map) {
		if (nodeCount == map.size()) {
			return map;
		}

		BinaryTreeNode<T> parent = node.getParent();
		BinaryTreeNode<T> leftChild = node.getLeftChild();
		BinaryTreeNode<T> rightChild = node.getRightChild();
		if (traversable(map, leftChild)) {
			inorderTraversal(leftChild, map);
		} else {
			if (!map.containsKey(node)) {
				map.put(node, node.getValue());
			}
			if (traversable(map, rightChild)) {
				inorderTraversal(rightChild, map);
			} else {
				inorderTraversal(parent, map);
			}
		}
		return map;
	}

	private boolean traversable(Map<BinaryTreeNode<T>, T> map, BinaryTreeNode<T> node) {
		return node != null && !map.containsKey(node);
	}
}
