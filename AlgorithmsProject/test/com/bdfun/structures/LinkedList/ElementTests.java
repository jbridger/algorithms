package com.bdfun.structures.LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Element class.
 */
public class ElementTests
{
	/**
	 * Tests constructing an element with a blank constructor. 
	 */
	@Test
	public void blankConstructor()
	{
		Element<Integer> element = new Element<Integer>();
				
		// Value and next element should be null
		assertNull(element.getValue());
		assertNull(element.getNextElement());
	}
	
	/**
	 * Tests constructing an element with the value constructor.
	 */
	@Test
	public void valueConstructor()
	{
		Element<Integer> element = new Element<Integer>(5);
		
		// Value should be as expected
		assertEquals(Integer.valueOf(5), element.getValue());
		
		// Next element should be null
		assertNull(element.getNextElement());
	}
	
	/**
	 * Tests constructing an element with the value and next and previous element constructor.
	 */
	@Test
	public void valueAndNextAndPreviousElementConstructor()
	{
		// Construct elements to point to
		Element<Integer> previousElement = new Element<Integer>(1);
		Element<Integer> nextElement = new Element<Integer>(10);
		
		// Construct element to point to the above element
		Element<Integer> element = new Element<Integer>(5, previousElement, nextElement);
		
		// Value should be as expected
		assertEquals(Integer.valueOf(5), element.getValue());
		
		// Get previous element, and check value
		assertEquals(previousElement, element.getPreviousElement());
		assertEquals(Integer.valueOf(1), element.getPreviousElement().getValue());
		
		// Get next element, and check the value
		assertEquals(nextElement, element.getNextElement());
		assertEquals(Integer.valueOf(10), element.getNextElement().getValue());
		
	}
	
	/**
	 * Test setters for element.
	 */
	@Test
	public void setters()
	{
		Element<Integer> element = new Element<Integer>();
		
		// Set value and next element
		Element<Integer> nextElement = new Element<Integer>(10);
		element.setValue(5);
		element.setNextElement(nextElement);
		
		// Check value and element is as expected
		assertEquals(Integer.valueOf(5), element.getValue());
		
		// Get next element, and check the value
		assertEquals(nextElement, element.getNextElement());
		assertEquals(Integer.valueOf(10), element.getNextElement().getValue());
		
	}
}
