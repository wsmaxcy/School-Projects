package edu.olemiss.cs.csci211;
//Will Maxcy
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.Test;

public class LinkedStackTest {

	@Test
	public void push() {
		LinkedStack<Integer> l = new LinkedStack<Integer>();
		l.push(1);
		assertEquals(new Integer(1),l.front.data);
		l.push(2);
		assertEquals(new Integer(2),l.front.data);
		l.push(3);
		assertEquals(new Integer(3),l.front.data);
		l.push(4);
		assertEquals(new Integer(4),l.front.data);
		l.push(5);
		assertEquals(new Integer(5),l.front.data);
		l.push(6);
		assertEquals(new Integer(6),l.front.data);
	}
	
	@Test
	public void pop(){
		LinkedStack<Integer> l = new LinkedStack<Integer>();
		l.push(1);
		l.push(2);
		l.push(3);
		l.push(4);
		l.push(5);
		l.push(6);
		l.push(7);
		assertEquals(l.pop(),new Integer(7));
		assertEquals(l.pop(),new Integer(6));
		assertEquals(l.pop(),new Integer(5));
		assertEquals(l.pop(),new Integer(4));
		assertEquals(l.pop(),new Integer(3));
		assertEquals(l.pop(),new Integer(2));
		assertEquals(l.pop(),new Integer(1));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void exception1(){
		LinkedStack<Integer> l = new LinkedStack<Integer>();
		l.pop();
	}
	
	@Test
	public void multi(){
		LinkedStack<Integer> l = new LinkedStack<Integer>();
		l.push(1);
		l.push(2);
		l.push(3);
		assertEquals(l.pop(), new Integer(3));
		assertEquals(l.pop(), new Integer(2));
		l.push(4);
		assertEquals(l.front.data, new Integer(4));
		l.pop();
		assertEquals(l.pop(), new Integer(1));
	}
	
	@Test
	public void iterator(){
		LinkedStack<Integer> l = new LinkedStack<Integer>();
		assertFalse(l.iterator().hasNext());
		l.addToFront(1);
		//Can not run test that would equal true for hasNext() due to the fact that this is only used mid execution
	}

}
