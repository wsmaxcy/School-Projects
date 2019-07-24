//Will Maxcy
package edu.olemiss.csci211;

/** Basic operations for an unordered list.
 * 
 * @author rhodes
 *
 * @param <T> The type of element contained in the list.
 */
public interface UnorderedList<T> extends List<T> {
	
	
	/**  Add the given element to the front of the list.
	 * 
	 * @param e the element to be added.
	 */
	public void addToFront(T e);
	
	
	/** Add the given element to the rear of the list.
	 * 
	 * @param e the element to be added.
	 */
	public void addToRear(T e);
	
}
