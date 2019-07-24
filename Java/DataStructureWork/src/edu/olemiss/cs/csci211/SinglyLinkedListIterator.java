
package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedListIterator<T> extends SinglyLinkedList<T> implements Iterator<T> {
	
	Node<T> current;
	public SinglyLinkedListIterator(){
		this(null);
	}
	
	public SinglyLinkedListIterator(Node<T> head){
		super(head);
		current = head;
	}
	
	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if (!hasNext()){
			throw new NoSuchElementException("Nothing here!");
		}
			
		T r = current.data;
		current = current.next;
		return r;
	}

	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("No support for argument");
	}


	
	
}
