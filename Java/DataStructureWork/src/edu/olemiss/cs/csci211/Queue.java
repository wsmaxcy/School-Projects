package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.NoSuchElementException;


/**  A queue works much like a line of people waiting for the teller window at the bank. The person at
 * the front of the queue is next to be served and to leave the queue. Newly arrived customers are added
 * at the back of the queue. 
 * 
 * Consider an element x that is added to the queue (enqueued). Any elements that were enqueued before x
 * are considered to be ahead of x. All elements ahead of x will need to be removed (dequeued) before x can be 
 * dequeued.
 * 
 
 *
 * @author rhodes
 *
 */

public interface Queue<T> {

	/** Add an element e to the Queue. This is an enqueue operation,
	 * so e is added to the back of the queue. Any elements added before e will
	 * be returned by calls to dequeue() before e.
	 * 
	 * @param e the element to be added to the back of the queue.
	 */
	public void enqueue(T e);
	
	
	/** Dequeue an element from the front of the queue. Of the all the elements currently
	 * in the Queue, this method will return the element least recently enqueued, also
	 * removing it from the Queue. 
	 * 
	 * If this Queue is empty, a java.util.NoSuchElementException is thrown.
	 * 
	 * @return the element at the front of the queue.
	 * @throws NoSuchElementException
	 */
	public T dequeue();
	
}
