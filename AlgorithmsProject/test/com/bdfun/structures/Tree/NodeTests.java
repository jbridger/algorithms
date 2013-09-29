package com.bdfun.structures.Tree;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for the Node class of a tree.
 */
public class NodeTests
{
	/**
	 * Test constructing a node using the blank constructor.
	 */
	@Test
	public void blankConstructor()
	{
		Node<Integer> node = new Node<Integer>();
		
		// Null value
		assertNull(node.getValue());
		
		// Null children
		assertNull(node.getLeftChild());
		assertNull(node.getRightChild());
		
		// Null parent
		assertNull(node.getParent());
	}
	
	/**
	 * Tests constructing a node with just the value.
	 */
	@Test
	public void valueConstructor()
	{
		Node<Integer> node = new Node<Integer>(2);
		
		// Check value is as expected
		assertEquals(Integer.valueOf(2), node.getValue());
	}
	
	/**
	 * Tests constructing a node with children
	 */
	@Test
	public void valueAndChildrenConstructor()
	{
		// Construct children first
		Node<Integer> leftChild = new Node<Integer>(1);
		Node<Integer> rightChild = new Node<Integer>(3);
		
		// Construct node with the children
		Node<Integer> node = new Node<Integer>(2, leftChild, rightChild);
		
		// Value should be as expected
		assertEquals(Integer.valueOf(2), node.getValue());
		
		// Children should be in their correct places
		assertEquals(leftChild, node.getLeftChild());
		assertEquals(rightChild, node.getRightChild());
		
		// Null parent
		assertNull(node.getParent());
		
		// Children should have reference to its parent
		assertEquals(node, leftChild.getParent());
		assertEquals(node, rightChild.getParent());
	}
	
	/**
	 * Tests using the setter to set the children
	 */
	@Test
	public void setChildren()
	{
		// Construct children first
		Node<Integer> leftChild = new Node<Integer>(1);
		Node<Integer> rightChild = new Node<Integer>(3);

		// Construct node without children nodes
		Node<Integer> node = new Node<Integer>(2);

		// Set the children
		node.setLeftChild(leftChild);		
		node.setRightChild(rightChild);
		
		// Children should be in their correct places
		assertEquals(leftChild, node.getLeftChild());
		assertEquals(rightChild, node.getRightChild());

		// Children should have reference to its parent
		assertEquals(node, leftChild.getParent());
		assertEquals(node, rightChild.getParent());
	}
}
