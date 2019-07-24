
public class Node {
	Node next;
	Node prev;
	Node parent;
	char [] state;
	int manhattan;
	int misplaced;
	int AStar = manhattan + misplaced;
	
	public Node(char[] s, int man, int mis){
		state = s;
		manhattan = man;
		misplaced = mis;
		AStar = man + mis;
	}
	

}
