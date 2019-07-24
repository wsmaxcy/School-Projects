//Will Maxcy
import edu.olemiss.csci211.List;
import edu.olemiss.csci211.Tree;


/**
 * A class that represents a file system. 
 * @author rhodes
 *
 */
public class FileSystem extends Tree<FileSystemObject>{
		
	
	public FileSystem(DirectoryEntry e){
		
		super(e);	
	}

	/**
	 * Add a file entry as a child of this filesystem root directory.
	 * @param e
	 */
	public void addFile(FileEntry e){
		
		addLeaf(e);
	}
	
	
	public void addDirectory(FileSystem e){
		
		addSubtree(e);
	}
	

	public List<String> locate(String name){
		
		return locate(new FileSystemObject(name), "/");
	}
	

}
