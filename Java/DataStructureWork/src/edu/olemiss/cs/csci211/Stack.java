package edu.olemiss.cs.csci211;
//Will Maxcy

/** A Stack behaves like a stack of plates next to the sink. Elements can be added (i.e. pushed)
 * or removed (i.e. popped) only from the top. That is, the last element pushed is always the next
 * element popped.  
 * @author rhodes
 *
 * @param <T>
 */
public interface Stack<T> {
	
	
	/**
	 * Remove an element from the top of the stack.
	 * @return the topmost element.
	 */
	public T pop();
	
	/** Place an element on the top of the stack.
	 * 
	 * @param element the element to be placed.
	 */
	public void push(T element);

}
