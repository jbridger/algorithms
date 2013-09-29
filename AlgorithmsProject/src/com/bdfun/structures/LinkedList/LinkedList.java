package com.bdfun.structures.LinkedList;

import java.util.List;

/**
 * Implementation of a singly linked list.
 * @param <T> Type of list to instantiate.
 */
public class LinkedList<T> 
{
	private Element<T> first = null;
	private Element<T> last = null;
	
	// Size of list
	private int size = 0;
	
	/**
	 * Blank constructor
	 */
	public LinkedList()
	{
		
	}
	
	/**
	 * Initialise list with supplied values, also in the same order.
	 * @param values Values to initialise list from/
	 */
	public LinkedList(List<T> values)
	{
		for(T value : values)
		{
			push(value);
		}
	}

	/**
	 * Tests whether the list is empty or not.
	 * @return True if list is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		return first == null;
	}

	/**
	 * Gets the size of the list.
	 * @return Size of list.
	 */
	public int getSize() 
	{
		return size;
	}

	/**
	 * Pops the item at the head of the list
	 * @return First item of list, or null if empty. 
	 */
	public T pop() 
	{
		T value = null;
		
		if(!isEmpty())
		{
			// Get value of first item
			value = first.getValue();
			
			// Delete the head item
			delete(first);
		}
		
		return value;
	}

	/**
	 * Adds the value to the list.
	 * @param value Value to add to list.
	 */
	public void push(T value) 
	{
		// Increase size count
		size++;
		
		// Create element with the value
		Element<T> element = new Element<T>(value);
		
		// If list is empty, then the new value is the first and last element
		if (isEmpty())
		{
			first = element;
			last = element;
		}
		else
		{
			// Add to end of list
			// First set next element for the current last element
			last.setNextElement(element);
			
			// Set new element to point to end of list 
			element.setPreviousElement(last);
			
			// Set the end of list to the new element
			last = element;
		}
	}
	
	/**
	 * Deletes first occurrence of the specified value.
	 * @param value Value to delete.
	 * @return True if successfully deleted, false otherwise.
	 */
	public boolean deleteFirst(T value) 
	{
		boolean deleted = false;
		
		if (!isEmpty())
		{
			// Check if it is the first element in the list
			if(first.getValue() == value)
			{
				// First element in the list, so delete it
				delete(first);
				deleted = true;
			}
			// Check if it is the last element in the list
			else if (last.getValue() == value)
			{
				// Last element in the list, so delete it
				delete(last);
				deleted = true;
			}
			else
			{
				// Iterate through list to find the value
				Element<T> nextElement = first.getNextElement();
				while (nextElement != null)
				{
					if (nextElement.getValue().equals(value))
					{
						// Found the value, delete the element
						delete(nextElement);
						deleted = true;
						break;
					}
					
					// Get next element
					nextElement = nextElement.getNextElement();
				}
			}
		}
			
		return deleted;
	}
	
	/**
	 * Deletes element from list. Ensures list is still linked.
	 * @param element Element to delete.
	 */
	private void delete(Element<T> element) 
	{
		// Decrease size count
		size--;
		
		if (!isEmpty())
		{
			// Check if the element is the first element
			if (first == element)
			{
				// Is it also the last element?
				if (last == element)
				{
					// Delete the last element
					last = null;
				}
				
				// Set first element in list to be the next element in the list
				first = first.getNextElement();
			}
			else
			{
				// Not the first element, so iterate through the list for the element.
				// Set links before and after the element to delete to skip over it

				// Update previous element
				Element<T> previousElement = element.getPreviousElement();
				if (previousElement != null)
				{
					previousElement.setNextElement(element.getNextElement());
				}

				// Update next element
				Element<T> nextElement = element.getNextElement();
				if (nextElement != null)
				{
					nextElement.setPreviousElement(previousElement);
				}
			}
		}
	}

	/**
	 * Count the occurrences of the specified value.
	 * @param value Value to look for.
	 * @return Number of occurrences.
	 */
	public int count(T value) 
	{
		int count = 0;
		
		if (!isEmpty())
		{
			Element<T> nextElement = first.getNextElement();
			while (nextElement != null)
			{
				if (nextElement.getValue().equals(value))
				{
					// Found a match, increment counter
					count++;
				}

				// Get next element
				nextElement = nextElement.getNextElement();
			}
		}
		
		return count;
	}

	/**
	 * Compares list with this list. The sequence must match.
	 * @param list List to test against
	 * @return True if match, false otherwise
	 */
	public boolean equalsList(List<T> list) 
	{
		boolean match = true;
		
		// Check the size matches
		if (size != list.size())
		{
			// Size doesn't match
			match = false;
		}
		else
		{
			// Size matches, now do element by element comparison
			Element<T> nextElement = first;
			for (T valueInList : list)
			{
				// Compare element values
				if(!valueInList.equals(nextElement.getValue()))
				{
					// No match, break out of loop
					match = false;
					break;
				}
				
				// Get next element
				nextElement = nextElement.getNextElement();
			}
		}
		
		return match;
	}
}
