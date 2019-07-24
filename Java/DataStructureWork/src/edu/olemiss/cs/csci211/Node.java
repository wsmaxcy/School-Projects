package edu.olemiss.cs.csci211;
//Will Maxcy
public class Node<T> {
	public Node<T> next;
	public T data;
	public Node<T> prev;
	
	public Node() {
		this(null, null);
	}

	public Node(Node<T> next, T data) {
		this.next = next;
		this.data = data;
	}
}