
package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.Iterator;
import java.util.NoSuchElementException;

/** This class maintains a list of elements with no specific order. This is a linked implementation, in
 * which space is allocated for list nodes dynamically. List nodes keep track of
 * both the next node and previous node in the list. If no such node exists, a null reference is
 * used to indicate the end of the list.
 * 
 * @author Will Maxcy
 *
 * @param <T>
 */
public class DoublyLinkedList<T> implements UnorderedList<T>{
	
	
	Node<T> front, rear;
	int count;
		
	public DoublyLinkedList() {
		this(null);
	}
	
	public DoublyLinkedList(Node<T> start) {
		front = rear = start;
		if (start == null){
			count = 0;
		}
		else
			count = 1;
	}
	
	@Override
	public Iterator<T> iterator() {
		return iterator();
		
	
	}

	@Override
	public boolean isEmpty() {
		return (count==0);
	}

	@Override
	public T removeFirst() {
		if (isEmpty()){
			throw new NoSuchElementException("Empty List");
		}
		T r = front.data;
		front = front.next;
		count--;
		if(isEmpty()){
			rear=null;
			front=null;
		}
		return r;
	}

	@Override
	public T removeLast() {
		T r = rear.data;
		rear=rear.prev;
		count--;
		if(isEmpty()){
			rear=null;
			front=null;
			throw new NoSuchElementException("Empty List");
		}
		return r;
	}

	@Override
	public void addToFront(T e) {
		Node<T> n = new Node<T>();
		n.data=e;
		n.next=front;
		n.prev=null;
		if(front!=null) {
			front.prev=n;
		}
		else{
			rear=n;
		}
		front=n;
		count++;
		
	}

	@Override
	public void addToRear(T e) {
		Node<T> n = new Node<T>();
		n.prev = rear;
		n.data=e;
		n.next=null;
		if(rear!=null){
			rear.next=n;
		}
		else{
			front=n;
		}
		count++;
		rear=n;
		
	}
	

}
