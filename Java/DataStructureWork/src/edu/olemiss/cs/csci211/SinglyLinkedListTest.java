package edu.olemiss.cs.csci211;
//Will Maxcy
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.NoSuchElementException;

public class SinglyLinkedListTest {

	@Test
	public void addToFront() {
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		l.addToFront(3);
		assertEquals(new Integer (3), l.front.data);
		l.addToFront(4);
		assertEquals(new Integer (4), l.front.data);
		l.addToFront(5);
		assertEquals(new Integer (5), l.front.data);
		l.addToFront(6);
		assertEquals(new Integer (6), l.front.data);
		l.addToFront(7);
		assertEquals(new Integer (7), l.front.data);
	}
	
	@Test
	public void addToRear(){
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		l.addToRear(1);
		assertEquals(new Integer(1),l.rear.data);
		l.addToRear(2);
		assertEquals(new Integer(2),l.rear.data);
		l.addToRear(3);
		assertEquals(new Integer(3),l.rear.data);
		l.addToRear(4);
		assertEquals(new Integer(4),l.rear.data);
		l.addToRear(5);
		assertEquals(new Integer(5),l.rear.data);
		l.addToRear(6);
		assertEquals(new Integer(6),l.rear.data);
		
	}
	@Test
	public void removeFirst(){
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		l.addToFront(1);
		l.addToFront(2);
		l.addToFront(3);
		l.addToFront(4);
		l.addToFront(5);
		l.addToFront(6);
		assertEquals(new Integer(6),l.removeFirst());
		assertEquals(new Integer(5),l.removeFirst());
		assertEquals(new Integer(4),l.removeFirst());
		assertEquals(new Integer(3),l.removeFirst());
		assertEquals(new Integer(2),l.removeFirst());
		assertEquals(new Integer(1),l.removeFirst());
	}
	
	@Test
	public void removeLast(){
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		l.addToFront(1);
		l.addToFront(2);
		l.addToFront(3);
		l.addToFront(4);
		l.addToFront(5);
		l.addToFront(6);
		assertEquals(new Integer(1),l.removeLast());
		assertEquals(new Integer(1),l.removeLast());
		assertEquals(new Integer(1),l.removeLast());
		assertEquals(new Integer(1),l.removeLast());
		assertEquals(new Integer(1),l.removeLast());
		assertEquals(new Integer(1),l.removeLast());
	}
	
	@Test
	public void isEmpty(){
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		assertTrue(l.isEmpty());
		l.addToFront(3);
		assertFalse(l.isEmpty());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void exception1(){
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		l.removeFirst();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void excpetion2(){
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		l.removeLast();
	}
	
	@Test
	public void multi(){
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		l.addToFront(1);
		l.addToFront(2);
		l.addToFront(3);
		assertEquals(new Integer(3), l.removeFirst());
		l.addToFront(4);
		assertEquals(new Integer(4), l.removeFirst());
		l.addToFront(5);
		l.addToFront(6);
		assertEquals(new Integer(6), l.removeFirst());
		assertEquals(new Integer(5), l.removeFirst());
		assertFalse(l.isEmpty());
		l.removeFirst();
		l.removeFirst();
		assertTrue(l.isEmpty());
	}
	
	@Test
	public void next(){
		LinkedStack<Integer> l = new LinkedStack<Integer>();
		l.addToFront(1);
		l.addToFront(2);
		l.addToFront(3);
		l.addToFront(4);
		l.addToFront(5);
		assertEquals(new Integer(4), l.front.next.data);
		assertEquals(new Integer(3), l.front.next.next.data);
		assertEquals(new Integer(2), l.front.next.next.next.data);
		assertEquals(new Integer(1), l.front.next.next.next.next.data);
	}
	
	@Test
	public void count(){
		LinkedStack<Integer> l = new LinkedStack<Integer>();
		l.addToFront(1);
		l.addToFront(2);
		l.addToFront(3);
		l.addToFront(4);
		l.addToFront(5);
		l.addToFront(6);
		assertEquals(new Integer(l.count),l.removeFirst());
		assertEquals(new Integer(5),new Integer(l.count));
		assertEquals(new Integer(l.count),l.removeFirst());
		assertEquals(new Integer(4),new Integer(l.count));
		assertEquals(new Integer(l.count),l.removeFirst());
		assertEquals(new Integer(3),new Integer(l.count));
		assertEquals(new Integer(l.count),l.removeFirst());
		assertEquals(new Integer(2),new Integer(l.count));
		assertEquals(new Integer(l.count),l.removeFirst());
		assertEquals(new Integer(1),new Integer(l.count));
	}

}
