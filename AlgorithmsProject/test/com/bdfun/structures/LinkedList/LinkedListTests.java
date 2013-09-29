package com.bdfun.structures.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Tests for the LinkedList class.
 */
public class LinkedListTests 
{
	/**
	 * Tests the blank constructor.
	 */
	public void blankConstructor()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// Assert list is empty
		assertTrue(list.isEmpty());
		assertEquals(0, list.getSize());
		assertNull(list.pop());
	}
	
	/**
	 * Tests constructing a list with a list of values.
	 */
	@Test
	public void valueConstructor()
	{
		// Create list of integers to put into linked list
		List<Integer> testIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		// Create linked list with the list above
		LinkedList<Integer> list = new LinkedList<Integer>(testIntegers);
		
		// The list should be in the order of the supplied list
		for(int i = 0; i < testIntegers.size(); i++)
		{
			// Pop element off list
			assertEquals(testIntegers.get(i), list.pop());
		}
	}
	
	/**
	 * Tests an empty list.
	 */
	@Test
	public void emptyList()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// Assert list is empty
		assertTrue(list.isEmpty());
	}

	/**
	 * Tests pushing and popping one item on list.
	 */
	@Test
	public void pushAndPop()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// Create and push item on to list
		list.push(5);
		
		// Check list is not empty
		assertFalse(list.isEmpty());
		assertEquals(1, list.getSize());
		
		// Pop item
		Integer poppedItem = list.pop();
		
		// Check that the popped item is the same item
		assertEquals(Integer.valueOf(5), poppedItem);
		
		// List should now be empty
		assertTrue(list.isEmpty());
		assertEquals(0, list.getSize());
	}
	
	/**
	 * Tests pushing and popping multiple items from list.
	 */
	@Test
	public void pushAndPopMultiple()
	{
		// Create list of integers to put into linked list
		List<Integer> testIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		// Create linked list
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// Loop through test integers and add all of them to the list.
		for(int i = 0; i < testIntegers.size(); i++)
		{
			// Push on to list
			list.push(testIntegers.get(i));
			
			// Check size
			assertEquals(i+1, list.getSize());
		}
		
		// List should not be empty
		assertFalse(list.isEmpty());
		
		// Loop through test integers and pop them off
		for(int i = 0; i < testIntegers.size(); i++)
		{
			// Pop element off list
			assertEquals(testIntegers.get(i), list.pop());
			
			// Check size
			assertEquals(testIntegers.size() - (i+1), list.getSize());
		}
		
		// List should be empty
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Tests deleting the first occurrence of the specified value.
	 * 
	 * List is empty in this test.
	 */
	@Test
	public void deleteFirstOnEmptyList()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// Result of deletion should be false
		assertFalse(list.deleteFirst(5));
	}
	
	/**
	 * Tests deleting the first occurrence of the specified value.
	 * 
	 * List only has one item.
	 */
	@Test
	public void deleteFirstOnOneItemList()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.push(5);
		
		// Result of deletion should be true
		assertTrue(list.deleteFirst(5));
		
		// List should be empty
		assertTrue(list.isEmpty());
		assertEquals(0, list.getSize());
		assertNull(list.pop());
	}
	
	/**
	 * Tests deleting the first occurrence of the specified value.
	 * 
	 * List has multiple items.
	 */
	@Test
	public void deleteFirstOnMultipleItemList()
	{
		// Integers to initialise linked list from. Note a duplicate value in list.
		List<Integer> testIntegers = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7);
		
		// Initialise linked list from above integers
		LinkedList<Integer> list = new LinkedList<Integer>(testIntegers);
		
		// Delete a non-existent value
		assertFalse(list.deleteFirst(50));
		// Size should be unchanged
		assertEquals(testIntegers.size(), list.getSize());
		
		// Result of deletion should be true
		assertTrue(list.deleteFirst(2));
		
		// Check list is as expected
		assertTrue(list.equalsList(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
	}
	
	/**
	 * Tests deleting the first item in the list, and then checking the list is correct.
	 */
	@Test
	public void deleteFirstItemInList()
	{
		// Integers to initialise linked list from. Note a duplicate value in list.
		List<Integer> testIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		// Initialise linked list from above integers
		LinkedList<Integer> list = new LinkedList<Integer>(testIntegers);
			
		// Result of deletion should be true
		assertTrue(list.deleteFirst(1));
		
		// Check list is as expected
		assertTrue(list.equalsList(Arrays.asList(2, 3, 4, 5, 6, 7)));
	}
	
	/**
	 * Tests deleting the last item in the list, and then checking the list is correct.
	 */
	@Test
	public void deleteLastItemInList()
	{
		// Integers to initialise linked list from. Note a duplicate value in list.
		List<Integer> testIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		// Initialise linked list from above integers
		LinkedList<Integer> list = new LinkedList<Integer>(testIntegers);

		// Result of deletion should be true
		assertTrue(list.deleteFirst(7));

		// Check list is as expected
		assertTrue(list.equalsList(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}
	
	/**
	 * Tests counting the number of occurrences of the specified value.
	 */
	@Test
	public void count()
	{
		// Integers to initialise linked list from. Note a duplicate value in list.
		List<Integer> testIntegers = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7);
		
		// Initialise linked list from above integers
		LinkedList<Integer> list = new LinkedList<Integer>(testIntegers);
		
		// Look for non-existent number
		assertEquals(0, list.count(20));
		
		// Look for number that only occurs once
		assertEquals(1, list.count(4));
		
		// Look for number that occurs twice
		assertEquals(2, list.count(2));
	}
	
	/**
	 * Tests comparing a java.util.List with the LinkedList. The order of the elements is important.
	 */
	@Test
	public void listEquals()
	{
		// Integers to initialise linked list from.
		List<Integer> testIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		// Initialise linked list from above integers
		LinkedList<Integer> list = new LinkedList<Integer>(testIntegers);
		
		// Lists of integers that will not match
		List<Integer> empty = Arrays.asList();
		List<Integer> differentFirst = Arrays.asList(2, 2, 3, 4, 5, 6, 7);
		List<Integer> differentLast = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
		List<Integer> justDifferent = Arrays.asList(1, 3, 5, 4, 8, 6, 8);
		
		// Check it matches the list we initialised from
		assertTrue(list.equalsList(testIntegers));
		
		// Test against lists that will not match
		assertFalse(list.equalsList(empty));
		assertFalse(list.equalsList(differentFirst));
		assertFalse(list.equalsList(differentLast));
		assertFalse(list.equalsList(justDifferent));
	}
	
	/**
	 * Tests comparing a java.util.List with the LinkedList. The order of the elements is important.
	 * 
	 * Linked list starts empty.
	 */
	@Test
	public void listEqualsEmptyList()
	{	
		// Lists of integers that will not match
		List<Integer> empty = Arrays.asList();
		List<Integer> differentFirst = Arrays.asList(2, 2, 3, 4, 5, 6, 7);
		List<Integer> differentLast = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
		List<Integer> justDifferent = Arrays.asList(1, 3, 5, 4, 8, 6, 8);

		// Test comparing an empty linked list
		LinkedList<Integer> emptyList = new LinkedList<Integer>();
		
		// Empty linked list should match empty list
		assertTrue(emptyList.equalsList(empty));
		
		// Empty linked list should not match anything else
		assertFalse(emptyList.equalsList(differentFirst));
		assertFalse(emptyList.equalsList(differentLast));
		assertFalse(emptyList.equalsList(justDifferent));
	}
}
