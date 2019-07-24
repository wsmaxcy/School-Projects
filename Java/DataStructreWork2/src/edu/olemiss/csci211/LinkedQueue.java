//Will Maxcy
package edu.olemiss.csci211;

import java.util.NoSuchElementException;



/** A linked list implementation of a Queue.
 * @author you
 * 
 *
 *
 */
public class LinkedQueue<T> extends SinglyLinkedList<T> implements Queue<T>{
		
	//TODO: Use composition instead of inheritance.
		
	/**
	 * Enqueue an element at the tail of the queue.
	 * 
	 * @param e the element to be added.
	 */
	public void enqueue(T e){
		
		addToRear(e);
	}
	
	
	/** Remove an element from the head of the queue.
	 * 
	 * @return The element that was removed.
	 * @throws NoSuchElementException when called on an empty Queue
	 */
	public T dequeue(){
		
		return removeFirst();
	}
}
