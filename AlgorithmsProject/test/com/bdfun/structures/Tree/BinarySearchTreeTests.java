package com.bdfun.structures.Tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Unit tests for the BinarySearchTree class.
 */
public class BinarySearchTreeTests
{
	/**
	 * Tests constructing an empty tree.
	 */
	@Test
	public void emptyTree()
	{
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		// Tree should be empty
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.getSize());
	}
	
	/**
	 * Test initialising a tree from a list.
	 */
	@Test
	public void initialiseFromList()
	{
		List<Integer> original = Arrays.asList(9, 6, 1, 2, 3, 4, 5);
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 9);
		
		// Create tree from list 
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(original);
		
		// Check size of tree
		assertEquals(expected.size(), tree.getSize());
		
		// Root node should be the median value of the input list
		assertEquals(Integer.valueOf(4), tree.getRootNode().getValue());
		
		// Traverse list in order and check it is expected
		assertEquals(expected, tree.inOrder());
	}
	
	/**
	 * Test insertion on a tree. Which should result in something like this:
	 * 
	 *       5
	 *      /  \
	 *     3    7
	 */ 
	@Test
	public void insertion()
	{
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		// Insert values
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		
		// Check size of tree is as expected
		assertEquals(3, tree.getSize());
		
		// Get root node and test it is as expected
		Node<Integer> root = tree.getRootNode();
		assertEquals(Integer.valueOf(5), root.getValue());
		
		// Test the children
		assertEquals(Integer.valueOf(3), root.getLeftChild().getValue());
		assertEquals(Integer.valueOf(7), root.getRightChild().getValue());
		
	}
	
	/**
	 * Tests inserting duplicate elements on a tree. Duplicates should be ignored.
	 */
	@Test
	public void duplicateInsertion()
	{
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

		// Insert values multiple times
		tree.insert(5);
		tree.insert(5);
		tree.insert(3);
		tree.insert(3);
		tree.insert(7);
		tree.insert(7);
		
		// Check size of tree is as expected
		assertEquals(3, tree.getSize());
		
		// Get root node and test it is as expected
		Node<Integer> root = tree.getRootNode();
		assertEquals(Integer.valueOf(5), root.getValue());
		
		// Test the children
		assertEquals(Integer.valueOf(3), root.getLeftChild().getValue());
		assertEquals(Integer.valueOf(7), root.getRightChild().getValue());
	}
}
