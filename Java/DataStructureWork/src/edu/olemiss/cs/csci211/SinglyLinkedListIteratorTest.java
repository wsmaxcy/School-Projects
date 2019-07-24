package edu.olemiss.cs.csci211;
//Will Maxcy
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class SinglyLinkedListIteratorTest {
	

	@Test
	public void hasNext() {
		SinglyLinkedListIterator<Integer> l = new SinglyLinkedListIterator<Integer>();
		assertFalse(l.hasNext());
		
	}
	@Test(expected = UnsupportedOperationException.class)
	public void exception1(){
		SinglyLinkedListIterator<Integer> l = new SinglyLinkedListIterator<Integer>();
		l.remove();
	}
	
	@Test(expected= NoSuchElementException.class)
	public void exception2(){
		SinglyLinkedListIterator<Integer> l = new SinglyLinkedListIterator<Integer>();
		l.next();
	}

}
