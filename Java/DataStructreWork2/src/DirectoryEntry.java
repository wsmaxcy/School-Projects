
//Will Maxcy
/**
 * A class representing a directory in a file system.
 * @author rhodes
 *
 */
public class DirectoryEntry extends FileSystemObject{

	/**
	 * Construct a Directory entry with the given name.
	 * The size will be zero.
	 * @param name the directory name
	 */
	public DirectoryEntry(String name){
		
		super(name, 0);
	}
	
	public String toString(){
		return name;
	}
	

}
