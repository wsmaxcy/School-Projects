package edu.olemiss.cs.csci211;
//Will Maxcy
import java.util.NoSuchElementException;


/** Basic operations supported by List classes.
 * 
 * @author rhodes
 *
 * @param <T>
 */
public interface List<T> extends Iterable<T> {

	
	/** Indicate whether this list is empty.
	 * 
	 * @return true if the list is empty, false otherwise.
	 */
	public boolean isEmpty();
	
	
	/** Remove an element from the front of the list.
	 *  @return the value of the first element in the list
	 *  @throws NoSuchElementException if the list is empty.
	 */
	public T removeFirst();

	
	/** Remove an element from the rear of the list.
	 *  @return the value of the last element in the list
	 *  @throws NoSuchElementException if the list is empty.
	 */
	public T removeLast();
	
}
