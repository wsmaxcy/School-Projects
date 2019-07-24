package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.Iterator;



/** This is a linked list implementation of a stack. 
 * 
 * @author Will Maxcy
 *
 * @param <T> the type of element.
 *
 */
public class LinkedStack<T> extends SinglyLinkedListIterator<T> implements Stack<T>, Iterable<T>{
	
	public LinkedStack(edu.olemiss.cs.csci211.Node<T> head) {
		super(head);
	}
	
	public LinkedStack(){
		super(null);
	}
	
	@Override
	public Iterator<T> iterator() {
		return this;
	}

	@Override
	public T pop() {
		return removeFirst();
	}

	@Override
	public void push(T element) {
		addToFront(element);
	}
	
	
}
 
