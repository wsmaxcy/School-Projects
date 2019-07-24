//Will Maxcy
package edu.olemiss.csci211;

import java.util.Iterator;
import java.util.NoSuchElementException;



public class SinglyLinkedList<T> implements UnorderedList<T> { // might be better just implementing List<T>
	
	class Node{
		
		Node next;
		T data;
	}
	
	Node front;
	Node rear;
	int count=0;
	
	/** Construct an empty list.
	 * 
	 */
	public SinglyLinkedList(){
		
		front=rear=null;
		count=0;
	}
	
	
	/** Indicate whether this list is empty.
	 * 
	 * @return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty(){
		
		return count == 0;
	}
	
	
	/** Add an element to the front of the list.
	 * @param e the element to add.
	 */
	public void addToFront(T e){
		
		Node n = new Node();
		n.next=front;
		n.data = e;
		
		if( front == null ){
			
			rear=n;
		}
		
		front=n;
		count++;
	}
	
	/** Add an element to the rear of the list.
	 * @param e the element to add.
	 */
	public void addToRear(T e){

		Node n = new Node();
		n.next=null;
		n.data = e;

		if(rear != null){
			
			rear.next=n;
		} else {
			
			front=n;
		}
		
		rear=n;
		count++;
	}

	
	
	/** Remove an element from the front of the list.
	 *  @return the value of the first element in the list
	 *  @throws NoSuchElementException if the list is empty.
	 */
	public T removeFirst(){
		
		if(front == null){
			
			throw new NoSuchElementException("Empty list.");
		}
			
		T r = front.data;
		front=front.next; //we can safely advance front.
		
		if(front == null){
			
			rear = null;
		}
		
		count--;
		return r;
	}
	

	/** Remove an element from the rear of the list.
	 *  @return the value of the last element in the list
	 *  @throws NoSuchElementException if the list is empty.
	 */
	public T removeLast(){

		if(rear == null){
			
			throw new NoSuchElementException("Empty list.");
		}
		
		T r = rear.data;
		
		if(rear != null){
			
			rear.next=null;
		} else {
			
			front = null;
		}
		
		count--;
		return r;		
	}
	
	/** Return an iterator suitable for iterating over a SinglyLinkedList.
	 * 
	 * @return the iterator.
	 */
	public Iterator<T> iterator(){
		
		return new SinglyLinkedListIterator<T>(this);
	}
	
	/**
	 * Return a string containing a description of this list.
	 */
	public String toString(){
		
		StringBuffer retVal=new StringBuffer(100);
		
		for(T n: this){
			
			retVal.append(n);
			retVal.append("\n");
		}
		
		return retVal.toString();
	}



}
