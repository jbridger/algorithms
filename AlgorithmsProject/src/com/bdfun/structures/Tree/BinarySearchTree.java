package com.bdfun.structures.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of a binary search tree. Duplicates are not permitted.
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> 
{
	private Node<T> root;
	
	private int size = 0;

	/**
	 * Blank constructor.
	 */
	public BinarySearchTree() 
	{
		
	}

	/**
	 * Initialise tree from list of values.
	 * @param input List of values to initialise from.
	 */
	public BinarySearchTree(List<T> input) 
	{
		if (input != null && input.size() > 0)
		{
			// To help get get a reasonably balanced tree we want to pick the median value.
			// To do this, we need to copy the data and sort it.
			List<T> copyOfInput = new ArrayList<T>(input);
			Collections.sort(copyOfInput);
			
			// Pick median value
			int medianIndex = copyOfInput.size() / 2;
			
			// Create root node with median value
			insert(copyOfInput.remove(medianIndex));
			
			// Loop through list and add to tree
			for (T value : copyOfInput)
			{
				insert(value);
			}
		}
	}

	/**
	 * Check if tree is empty or not.
	 * @return True if empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		return root == null;
	}

	/**
	 * Number of nodes in tree.
	 * @return Number of nodes in tree.
	 */
	public int getSize() 
	{
		return size;
	}

	/**
	 * Insert value into tree.
	 * 
	 * Duplicate values are ignored.
	 * @param value Value to be inserted into tree.
	 */
	public void insert(T value) 
	{
		// If empty, then create root node
		if(isEmpty())
		{
			root = new Node<T>(value);
			
			// Increment node count
			size++;
		}
		else
		{
			// Try to insert on the root node
			insert(root, value);
		}
	}
	

	/**
	 * Return values in tree in order.
	 * @return List of values in order.
	 */
	public List<T> inOrder()
	{
		return inOrder(root);
	}
	
	/**
	 * Recursively try to insert the specified value into the correct place of a tree.
	 *	
	 * Duplicate values are ignored. 
	 * @param node Node to try to insert on.
	 * @param value Value to insert.
	 */
	private void insert(Node<T> node, T value)
	{
		if (node != null)
		{
			// If value is less than current node value then go down left child path
			if (value.compareTo(node.getValue()) < 0)
			{
				// Go down left child path
				if (node.getLeftChild() == null)
				{
					// No left child, create new one
					node.setLeftChild(new Node<T>(value));
					
					// Increment node count
					size++;
				}
				else
				{
					// Left child exists, call this method recursively on this child
					insert(node.getLeftChild(), value);
				}
			}
			// If value is greater than current node value then go down left child path
			else if (value.compareTo(node.getValue()) > 0)
			{
				// Go down right child path
				if (node.getRightChild() == null)
				{
					// No right child, create new one
					node.setRightChild(new Node<T>(value));
					
					// Increment node count
					size++;
				}
				else
				{
					// Right child exists, call this method recursively on this child
					insert(node.getRightChild(), value);
				}
			}
		}
	}

	/**
	 * Gets the root node.
	 * @return Root node if it exists.
	 */
	protected Node<T> getRootNode()
	{
		return root;
	}

	private List<T> inOrder(Node<T> node) 
	{
		List<T> values = new ArrayList<T>();
		
		if (node == null)
		{
			return values;
		}
		else
		{
			values.addAll(inOrder(node.getLeftChild()));
			values.add(node.getValue());
			values.addAll(inOrder(node.getRightChild()));
		}
		
		return values;
	}
}
