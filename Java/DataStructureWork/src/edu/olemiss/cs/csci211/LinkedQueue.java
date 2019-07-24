package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.Iterator;


/** A linked list implementation of a Queue.
 * @author you
 * 
 *
 *
 */
public class LinkedQueue<T> extends SinglyLinkedListIterator<T> implements Queue<T>, Iterable<T>{
	
	public LinkedQueue(edu.olemiss.cs.csci211.Node<T> head) {
		super(head);
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return this;
	}
	public LinkedQueue(){
		super(null);
	}

	@Override
	public void enqueue(T e) {
		addToRear(e);
		
	}

	@Override
	public T dequeue() {
		return removeFirst();
	}
	
}
