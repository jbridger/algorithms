package com.bdfun.structures.LinkedList;

import java.util.List;

/**
 * Interface for LinkedLists.
 */
public interface LinkedList <T>
{
	/**
	 * Tests whether the list is empty or not.
	 * @return True if list is empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Gets the size of the list.
	 * @return Size of list.
	 */
	public int getSize();
	
	/**
	 * Removes the head item of the list.
	 * @return First item of list, or null if empty. 
	 */
	public T remove();
	
	/**
	 * Adds the value to the end of the list.
	 * @param value Value to add to list.
	 */
	public void push(T value);
	
	/**
	 * Deletes first occurrence of the specified value.
	 * @param value Value to delete.
	 * @return True if successfully deleted, false otherwise.
	 */
	public boolean deleteFirst(T value);
	
	/**
	 * Count the occurrences of the specified value.
	 * @param value Value to look for.
	 * @return Number of occurrences.
	 */
	public int count(T value);
	
	/**
	 * Compares list with this list. The sequence must match.
	 * @param list List to test against
	 * @return True if match, false otherwise
	 */
	public boolean equalsList(List<T> list);
}

