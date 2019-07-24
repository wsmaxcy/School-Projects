//Will Maxcy
package edu.olemiss.csci211;

import java.util.Iterator;

/**
 * 
 */

/** An iterator class for singly linked lists.
 * @author rhodes
 *
 */
public class SinglyLinkedListIterator<E> implements Iterator<E> {
	
	SinglyLinkedList<E>.Node next;
	
	/** Construct an iterator that will iterate through the items
	 * in the given list.
	 * 
	 * @param list the list to be iterated over.
	 */
	public SinglyLinkedListIterator(SinglyLinkedList<E> list){
		
		next=list.front;
	}

	@Override
	/** Indicate whether this iterator has another element remaining in the iteration.
	 * @return true if there is a next element, false otherwise.
	 */
	public boolean hasNext() {
		
		return next != null;
	}

	@Override
	/** Advance to the next element in the iteration. A null reference is returned if no 
	 * more elements are available.
	 * @return the next element in the iteration, or null.
	 */
	public E next() {
		
		if(hasNext()) {
			E r = next.data;
			next=next.next;
			return r;
		} else
			return null;
	}

	/** Not implemented. 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void remove() {
		
		throw new UnsupportedOperationException("remove() is not supported.");
	}
	
	

}
