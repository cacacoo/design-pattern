package com.dataStructure;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class BinarySearchTreeTest {

	@Test
	public void bstTest() {

		List<Integer> integerList = Lists.newArrayList(10,2,18,6,5,4,1,11,19,7);

		BinarySearchTree<Integer> bst = new BinarySearchTree<>(integerList);

		bst.traversal(TraversalType.INORDER);
		bst.traversal(TraversalType.PREORDER);
	}
}
