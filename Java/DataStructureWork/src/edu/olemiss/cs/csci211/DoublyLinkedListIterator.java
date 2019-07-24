package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 */

/** An iterator class for doubly linked lists.
 * @author Will Maxcy
 *
 */
public class DoublyLinkedListIterator<E> extends DoublyLinkedList<E> implements Iterator<E> {
	
	Node<E> current;
	
	public DoublyLinkedListIterator(Node<E> head){
		super(head);
		current = head;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public E next() {
		if (!hasNext()){
			throw new NoSuchElementException("Nothing here!");
		}
			
		E r = current.data;
		current = current.next;
		return r;
	}

	@Override
	public void remove() {
		if (super.iterator().next()==null){
			super.removeLast();
		}
		else{
			super.iterator().remove();
		}
		
	}
	

}
