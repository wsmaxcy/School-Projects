package edu.olemiss.cs.csci211;
//Will Maxcy
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.Test;

public class LinkedQueueTest {

	@Test
	public void enqueue() {
		LinkedQueue<Integer> l = new LinkedQueue<Integer>();
		l.enqueue(1);
		assertEquals(l.rear.data, new Integer(1));
		l.enqueue(2);
		assertEquals(l.rear.data, new Integer(2));
		l.enqueue(3);
		assertEquals(l.rear.data, new Integer(3));
		l.enqueue(4);
		assertEquals(l.rear.data, new Integer(4));
		l.enqueue(5);
		assertEquals(l.rear.data, new Integer(5));
	}
	
	@Test
	public void dequeue(){
		LinkedQueue<Integer> l = new LinkedQueue<Integer>();
		l.enqueue(1);
		l.enqueue(2);
		l.enqueue(3);
		l.enqueue(4);
		l.enqueue(5);
		l.enqueue(6);
		assertEquals(l.dequeue(), new Integer(1));
		assertEquals(l.dequeue(), new Integer(2));
		assertEquals(l.dequeue(), new Integer(3));
		assertEquals(l.dequeue(), new Integer(4));
		assertEquals(l.dequeue(), new Integer(5));
		assertEquals(l.dequeue(), new Integer(6));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void exception1(){
		LinkedQueue<Integer> l = new LinkedQueue<Integer>();
		l.dequeue();
	}
	
	@Test
	public void multi(){
		LinkedQueue<Integer> l = new LinkedQueue<Integer>();
		l.enqueue(1);
		l.enqueue(2);
		l.enqueue(3);
		assertEquals(l.dequeue(), new Integer(1));
		l.enqueue(4);
		assertEquals(l.dequeue(), new Integer(2));
		assertEquals(l.dequeue(), new Integer(3));
		l.enqueue(5);
		l.enqueue(6);
		l.enqueue(7);
		assertEquals(l.dequeue(), new Integer(4));
		assertEquals(l.dequeue(), new Integer(5));
		assertEquals(l.dequeue(), new Integer(6));
		assertFalse(l.isEmpty());
		assertEquals(l.dequeue(), new Integer(7));
		assertTrue(l.isEmpty());
	}
	@Test
	public void iterator(){
		LinkedQueue<Integer> l = new LinkedQueue<Integer>();
		assertFalse(l.iterator().hasNext());
		l.addToFront(1);
		//Can not run test that would equal true for hasNext() due to the fact that this is only used mid execution		


	}

}
