//Will Maxcy


/**
 * A class representing an object in a filesystem, such as a file or directory.
 * @author rhodes
 */

public  class FileSystemObject {
	
	protected String name;
	protected int size;

	/**
	 * Construct a FileSystemObject with the given name and size.
	 * @param name
	 * @param size
	 */
	public FileSystemObject(String name, int size){
		
		this.name = name;
		this.size = size;
	}
	
	/**
	 * Construct a FileSystemObject with the given name and zero size.
	 * @param name
	 */
	public FileSystemObject(String name){
		
		this.name = name;
		this.size = 0;
	}

	/** Return the name of this FileSystemObject.
	 * 
	 * @return the name
	 */
	public String name(){
		
		return this.name; // Strings are immutable, so this is safe.
	}
	
	/** Return the size of this FileSystemObject.
	 * 
	 * @return the size
	 */
	public int size(){
		
		return this.size; 
	}

	
	@Override
	/** Check if this FileSystemObject is equal to the argument. FileSystemObjects are considered equal if
	 * they have the same name.
	 * 
	 * @return true if the FileSystemObject are equal, false otherwise.
	 * 
	 */	
	public boolean equals(Object o){
		
		return name.equals(((FileSystemObject)o).name);
	}
	
	/** Return a string representation of this object.
	 * 
	 */
	public String toString(){
		
		return new String(name+" size: "+ size);
	}


}
