package com.dataStructure;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class BinarySearchTreeTest {

	@Test
	public void bstTest() {

		List<Integer> integerList = Lists.newArrayList(10,2,18,6,5,4,1,11,22,19,20,7,14,54,62);

		BinarySearchTree<Integer> bst = new BinarySearchTree<>(integerList);

		List<Integer> preorder = bst.traversal(TraversalType.PREORDER);

		List<Integer> postorder = bst.traversal(TraversalType.POSTORDER);

		List<Integer> inorder = bst.traversal(TraversalType.INORDER);

		BinaryTreeNode<Integer> two = bst.find(22);


		bst.delete(18);

		System.out.println(bst.height());

		bst.delete(62);

		System.out.println(bst.height());

		bst.delete(4);

		System.out.println(bst.height());
	}
}
