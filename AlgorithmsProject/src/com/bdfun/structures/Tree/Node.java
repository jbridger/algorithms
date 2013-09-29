package com.bdfun.structures.Tree;

/**
 * Class to represent a node in a binary tree.
 * @param <T>
 */
public class Node<T extends Comparable<T>> 
{
	private T value = null;
	
	private Node<T> parent = null;
	private Node<T> leftChild = null;
	private Node<T> rightChild = null;
	
	/**
	 * Blank constructor.
	 */
	public Node() 
	{
		
	}
	
	/**
	 * Construct node with a value.
	 * @param value
	 */
	public Node(T value)
	{
		this.value = value;
	}

	/**
	 * Construct a node with value and children. The supplied nodes will be children of this node, 
	 * and they will be aware that this node is the parent.
	 * @param value
	 * @param leftChild
	 * @param rightChild
	 */
	public Node(T value, Node<T> leftChild, Node<T> rightChild)
	{
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		
		// Set this node as the parent in the children
		leftChild.setParent(this);
		rightChild.setParent(this);
	}

	/**
	 * Get value of node.
	 * @return Value of node.
	 */
	public T getValue()
	{
		return value;
	}

	/**
	 * Get reference to left child.
	 * @return Reference to left child if it exists.
	 */
	public Node<T> getLeftChild() 
	{
		return leftChild;
	}

	/**
	 * Get reference to right child.
	 * @return Reference to right child if it exists.
	 */
	public Node<T> getRightChild() 
	{
		return rightChild;
	}

	/**
	 * Gets parent of node.
	 * @return Reference ot parent node if it exists.
	 */
	public Node<T> getParent() 
	{
		return parent;
	}
	
	/**
	 * Sets the left child. The left child node will be aware that this node is the parent.
	 * @param leftChild
	 */
	public void setLeftChild(Node<T> leftChild) 
	{
		this.leftChild = leftChild;
		
		// Set parent node in the child
		leftChild.setParent(this);
	}
	
	/**
	 * Sets the right child. The right child node will be aware that this node is the parent.
	 * @param rightChild
	 */
	public void setRightChild(Node<T> rightChild) 
	{
		this.rightChild = rightChild;
		
		// Set parent node in the child
		rightChild.setParent(this);
	}
	
	/**
	 * Sets the parent node of this node.
	 * @param parent
	 */
	private void setParent(Node<T> parent) 
	{
		this.parent = parent;
	}
	
	@Override
	public String toString()
	{
		return value == null ? null : value.toString();
	}
}
