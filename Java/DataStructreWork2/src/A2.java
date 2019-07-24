//Will Maxcy
import java.io.*;

import edu.olemiss.csci211.List;

public class A2 {

	/** The a2 main program.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		StreamTokenizer t = new StreamTokenizer(br);

		System.out.println("Please enter a valid filesystem description (FD):");
		FileSystem tree = Parser.parse(t);
		
		
		
		System.out.println("Parsing complete. Please enter commands at the prompt below.");
		doCommands(t,tree);
		
		
		System.out.println("Done.");
	}
	
	/** Read and execute commands from the given tokenizer until 'quit' is encountered.
	 *  
	 * @param t a StreamTokenizer that has already been associated with a reader
	 * @param filesys an empty tree
	 * @throws IOException
	 */
	public static void doCommands(StreamTokenizer t, FileSystem filesys) throws IOException{
		
		String command;
		String argument;
		boolean done=false;
		
		
		do{
			System.out.print("\n?>");
			command=Parser.nextWord(t);
			command = command.toLowerCase();

			if(command.equals("locate")){
				
				argument = Parser.nextWord(t);
				List<String> paths = filesys.locate(argument);
				
				System.out.println(paths);			
			} else if(command.equals("list")){
					
				filesys.print();
			} else if(command.equals("space")){
				
				int size = 0;
				for(FileSystemObject f:filesys){
					
					size+=f.size();
					
					System.out.println("Object size: "+ f.size());
				}
				System.out.println("total space: "+ size);
			} else if(command.equals("help")){
				
				System.out.println("Valid commands are find list space help and quit.");	
			} else if(command.equals("quit")){
				
				done=true;
			} else {
				
				System.out.print("Unrecognized command: "+command);
			}
			
		} while(!done);
		
	}

}
