//Will Maxcy
import java.io.IOException;
import java.io.StreamTokenizer;



/** 
 * Provides static methods for parsing Filesystem Descriptions from a StreamTokenizer. 
 * A filesystem description (FD) adheres to the syntax given below.
 * entry -> file | directory
 * file -> filename size
 * directory -> Ô(Ô  dirname entry* Ô)Õ
 * FD -> directory
 * @author rhodes
 *
 */
public class Parser {
	
	/**
	 * Parse the Filesystem Description read from the given tokenizer 
	 * and return the resulting FileSystem
	 * @param t
	 * @return
	 * @throws IOException
	 */
	public static FileSystem parse(StreamTokenizer t) throws IOException{
		
		return directory("", t);
	}
	
	/**
	 * Read necessary data for a plain file from the given tokenizer and return
	 * a newly constructed FileNode object. A corresponding message is printed
	 * to standard output, indented by the given prefix string. 
     *
	 * @param prefix  the indentation prefix
	 * @param t the tokenizer
	 * @return a new filenode
	 * @throws IOException
	 */
	private static FileEntry file(String prefix, StreamTokenizer t) throws IOException{
		
		String filename = nextWord(t);
		int filesize = (int) nextNumber(t);
		
		System.out.println(prefix + "File:" + filename + " size:"+filesize);
		
		return new FileEntry(filename, filesize);
	}


	/**
	 * Read necessary data for a Directory from the given tokenizer and return
	 * a newly constructed Filesystem object with a corresponding DirectoryNode object
	 * at the root of the tree, and all contained files and directories in the
	 * remaining nodes of the tree.
	 * 
	 * A corresponding message is printed to standard output,
	 * indented by the given prefix string.
	 * 
	 * @param prefix the indentation prefix
	 * @param t the tokenizer
	 * @return a new filenode
	 * @throws IOException
	 */
	private static FileSystem directory(String prefix, StreamTokenizer t) throws IOException{
		
		// ( dname entry entry entry ) 
		
		int token;
		boolean done=false;
		
		matchChar(t,'(');
		
		String directoryName = nextWord(t);
		System.out.println(prefix+"Directory: "+directoryName);
		
		FileSystem filesys = new FileSystem(new DirectoryEntry(directoryName));
	
		
		while(!done){
			
			token = t.nextToken();
			
			switch(token){
				case ')':
					done=true;
					break;
					
				case '(':
					t.pushBack();
					filesys.addSubtree(directory(prefix+"    ", t));
					break;
					
				case StreamTokenizer.TT_WORD:
					t.pushBack();
					filesys.addLeaf(file(prefix+"    ",t));
					break;

				case StreamTokenizer.TT_EOF:
					System.err.println("Parse Error: Unexpected EOF on line "+t.lineno());
					System.exit(1);
					break;

				default:
					System.err.println("Parse Error: Unknown Token on line "+t.lineno());
			
			}
		} 
		
		return filesys; 
	}
	
	
	/**
	 * Return a string containing a word read from the given tokenizer. An
	 * error message is printed if a type of token other than a word is returned by the tokenizer.
	 * @param t the tokenizer
	 * @return a string
	 * @throws IOException 
	 */
	public static String nextWord(StreamTokenizer t) throws IOException{
		
		int token = t.nextToken();
		
		if(token == StreamTokenizer.TT_WORD ){
			
			return t.sval;
		} else {
			
			System.err.print("Parse error. expected a word and found ");
			
			switch(token){
				case StreamTokenizer.TT_NUMBER:
					System.err.print("a number");
					break;
				case StreamTokenizer.TT_EOL:
					System.err.print("EOL");
					break;
				case StreamTokenizer.TT_EOF:
					System.err.print("EOF");
					break;
				default:
					System.err.print((char)token);
					break;
			}
			
			System.err.println(" on line "+t.lineno());
			
			return null;
		}
	}

	/**
	 * Return a string containing a number read from the given tokenizer. An
	 * error message is printed if a type of token other than a number is returned by the tokenizer.
	 * @param t
	 * @return a double value equal to the number read.
	 * @throws IOException
	 */
	public static double nextNumber(StreamTokenizer t) throws IOException{
		
		int token = t.nextToken();
		
		if(token == StreamTokenizer.TT_NUMBER ){
			
			return t.nval;
		} else {
			
			System.err.print("Parse error. expected a number and found ");
			
			switch(token){
				case StreamTokenizer.TT_WORD:
					System.err.print("a word");
					break;
				case StreamTokenizer.TT_EOL:
					System.err.print("EOL");
					break;
				case StreamTokenizer.TT_EOF:
					System.err.print("EOF");
					break;
				default:
					System.err.print((char)token);
					break;

			}
			
			System.out.println(" on line "+t.lineno());
			
			return -1;
		}
	}


	private static void matchString(StreamTokenizer t, String s) throws IOException{
		
		int token = t.nextToken();
				
		if( ! (token == StreamTokenizer.TT_WORD && t.sval.equals(s)) ){
						
			System.err.println("Parse error. expected "+s+" on line "+t.lineno());
		}
	}

	private static void matchChar(StreamTokenizer t, char c) throws IOException{
		
		int token = t.nextToken();
				
		if(token != c){
						
			System.err.println("Parse error. expected "+c+" on line "+t.lineno());
		}
	}


}
