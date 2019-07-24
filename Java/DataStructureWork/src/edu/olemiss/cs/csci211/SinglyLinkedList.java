package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T>{
	Node<T> front, rear;
	int count;

	
	public SinglyLinkedList() {
		this(null);
	}
	
	public SinglyLinkedList(Node<T> start) {
		front = rear = start;
		if (start == null){
			count = 0;
		}
		else
			count = 1;
	}
	

	public void addToFront(T e){
		Node<T> n = new Node<T>();
		n.data=e;
		n.next=front;
		if(front==null) {
			rear=n;
		}
		front=n;
		count++;
	}
	
	public void addToRear(T e){
		Node<T> n = new Node<T>();
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
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public T removeFirst(){
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
	
	public T removeLast(){
		if (isEmpty()){
			throw new NoSuchElementException("Empty List");
		}
		T r = rear.data;
		count--;
		if(isEmpty()){
			rear=null;
			front=null;
		}
		return r;
	}

	@Override
	public Iterator<T> iterator() {
		
		return iterator();
	}

}