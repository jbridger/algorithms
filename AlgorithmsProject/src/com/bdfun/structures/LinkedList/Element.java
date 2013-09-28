package com.bdfun.structures.LinkedList;

/**
 * Element in the doubly linked list.
 */
public class Element<T> 
{
	// Value of element
	private T value = null;

	// Link to previous element
	private Element<T> previousElement = null;
	
	// Link to next element
	private Element<T> nextElement = null;
	
	/**
	 * Blank constructor.
	 */
	public Element()
	{
		
	}
	
	/**
	 * Constructor.
	 * @param value Value to set for the element.
	 */
	public Element(T value)
	{
		this.value = value;
	}
	
	/**
	 * Constructor.
	 * @param value Value to set for the element.
	 * @param previousElement Previous element to link to.
	 * @param nextElement Next element to link to.
	 */
	public Element(T value, Element<T> previousElement, Element<T> nextElement) 
	{
		this.value = value;
		this.setPreviousElement(previousElement);
		this.nextElement = nextElement;
	}

	/**
	 * Get value of element.
	 * @return Value of element.
	 */
	public T getValue() 
	{
		return value;
	}

	/**
	 * Set value of element.
	 * @param value Value to store in element.
	 */
	public void setValue(T value) 
	{
		this.value = value;
	}

	/** 
	 * Get previous element.
	 */
	public Element<T> getPreviousElement() 
	{
		return previousElement;
	}

	/**
	 * Sets the previous element.
	 * @param previousElement
	 */
	public void setPreviousElement(Element<T> previousElement) 
	{
		this.previousElement = previousElement;
	}
	
	/**
	 * Get the next element.
	 * @return
	 */
	public Element<T> getNextElement() 
	{
		return nextElement;
	}

	/**
	 * Set next element to link to.
	 * @param nextElement
	 */
	public void setNextElement(Element<T> nextElement) 
	{
		this.nextElement = nextElement;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Element<?> other = (Element<?>) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		
		return true;
	}

	@Override
	public String toString() 
	{
		return value.toString();
	}
}
