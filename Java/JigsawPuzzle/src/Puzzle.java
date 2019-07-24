import java.util.ArrayList;
import java.util.Random;

public class Puzzle {
	static int empty;
	static char goal[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'X' };
	static int count;
	static int last = 4;
	static Node first;
	static ArrayList<Node> discarded = new ArrayList<Node>();
	static ArrayList<Node> discarded2 = new ArrayList<Node>();
	static Random rn = new Random();

	public static void main(String[] args) {
		char state[] = new char[goal.length];

		for (int i = 0; i < state.length; i++) {
			state[i] = goal[i];
		}
		findEmpty(state);
		System.out.println("Number of iterations in a random state generator solver is : " + count);
		System.out.println("\n\nA* Solving:-=-=-=-=-=-=-=-=");
		mixUp(state, 350);
		// printState(state);
		// System.out.println(count);
		printState(state);
		findEmpty(state);
		solveAStar(state);
		
			
		
		

		// solveAStar(messedUp);
		/*
		 * while (first != null) { System.out.print(first.state);
		 * System.out.println(" " + first.AStar); first = first.next; } for (int
		 * i = 0; i < discarded.size(); i++) { if (!discarded.isEmpty()) {
		 * System.out.println(discarded.get(i).state); } }
		 */
	}
	
	

	public static void printState(char state[]) {
		if (state.length != 9) {
			System.out.println("Error: state has too many numbers in it!");
		} else {
			System.out.println(" ____________________");
			System.out.println("|      |      |      |");
			System.out.println("|  " + state[0] + "   |  " + state[1] + "   |  " + state[2] + "   |");
			System.out.println("|______|______|______|");
			System.out.println("|      |      |      |");
			System.out.println("|  " + state[3] + "   |  " + state[4] + "   |  " + state[5] + "   |");
			System.out.println("|______|______|______|");
			System.out.println("|      |      |      |");
			System.out.println("|  " + state[6] + "   |  " + state[7] + "   |  " + state[8] + "   |");
			System.out.println("|______|______|______|");
		}

	}

	public static void solveHillClimbing(char state[]) {
		

		Node node = new Node(state, findManhattan(state), findMisplaced(state));
		ArrayList<Node> list = new ArrayList<Node>();
		findEmpty(node.state);
		discarded2.add(node);
		System.out.println("Node was chosen with "+node.AStar);
		char[] stateBuffer0 = new char[node.state.length];
		char[] stateBuffer1 = new char[node.state.length];
		char[] stateBuffer2 = new char[node.state.length];
		char[] stateBuffer3 = new char[node.state.length];
		Node buffer0 = new Node(stateBuffer0, findManhattan(stateBuffer0), findMisplaced(stateBuffer0));
		Node buffer1 = new Node(stateBuffer1, findManhattan(stateBuffer1), findMisplaced(stateBuffer1));
		Node buffer2 = new Node(stateBuffer2, findManhattan(stateBuffer2), findMisplaced(stateBuffer2));
		Node buffer3 = new Node(stateBuffer3, findManhattan(stateBuffer3), findMisplaced(stateBuffer3));

		if (empty % 3 != 0) {
			System.arraycopy(node.state, 0, stateBuffer0, 0, node.state.length);
			swapLeft(buffer0.state, empty);
			buffer0 = new Node(stateBuffer0, findManhattan(stateBuffer0), findMisplaced(stateBuffer0));

		}

		findEmpty(node.state);
		if (empty % 3 != 2) {
			System.arraycopy(node.state, 0, stateBuffer1, 0, node.state.length);
			swapRight(buffer1.state, empty);
			buffer1 = new Node(stateBuffer1, findManhattan(stateBuffer1), findMisplaced(stateBuffer1));

		}
		findEmpty(node.state);
		if (empty > 2) {
			System.arraycopy(node.state, 0, stateBuffer2, 0, node.state.length);
			swapUp(buffer2.state, empty);
			buffer2 = new Node(stateBuffer2, findManhattan(stateBuffer2), findMisplaced(stateBuffer2));

		}
		findEmpty(node.state);
		if (empty < 6) {
			System.arraycopy(node.state, 0, stateBuffer3, 0, node.state.length);
			swapDown(buffer3.state, empty);
			buffer3 = new Node(stateBuffer3, findManhattan(stateBuffer3), findMisplaced(stateBuffer3));

		}
		list.add(buffer0);
		list.add(buffer1);
		list.add(buffer2);
		list.add(buffer3);
		System.out.println(list.get(0).AStar);
		System.out.println(list.get(1).AStar);
		System.out.println(list.get(2).AStar);
		System.out.println(list.get(3).AStar);
		int x = 10000;
		int y = 10000;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).manhattan < x) {
				x = list.get(i).manhattan;
				if (!isDiscarded2(list.get(i))) {
					y = i;
				}
			}
		}
		if(y == 10000){
			findEmpty(node.state);
			node.state = mixUp(node.state,5);
			y = rn.nextInt(4);
			
		}
		solveHillClimbing(list.get(y).state);

	}

	public static void solveAStar(char state[]) {
		
		discarded.clear();
		count = 0;
		Node node = new Node(state, findManhattan(state), findMisplaced(state));
		first = node;
		deepen(first);
		while (!isGoal(first.state)) {
			deepen(first);
		}

	}

	public static void deepen(Node node) {
		if (isGoal(node.state)) {

			System.out.println("Number of states added to list: " + count);
			System.out.println("Number of states dequed from list: " + discarded.size()
					+ "\n\nPath from Goal to Start State\n------------------");
			System.out.println("State    |A* number");
			int num = 0;
			while (node != null) {
				//printState(node.state);
				System.out.print(node.state);
				System.out.println(" " + node.AStar);
				node = node.parent;
				num++;
			}
			System.out.println("Can be solved in exactly " + (num - 1) + " moves.");
			return;
		}
		if (isDiscarded(node)) {
			// for (int i = 0; i < discarded.size(); i++) {
			// if (i == 0) {
			// System.out.println("Start!");
			// }
			// System.out.print(discarded.get(i).state);
			// System.out.println(" "+discarded.get(i).AStar);
			// }

			// deepen(first);

			return;
		}
		// System.out.print("dequed ");
		// System.out.print(first.state);
		// System.out.println(" " + first.AStar);
		discarded.add(first);
		if (first.next != null) {
			first = first.next;
			first.prev = null;
		} else {
			first = null;
		}

		if (isInList(node)) {
			

			return;
		}

		findEmpty(node.state);
		if (empty % 3 != 0) {
			char[] stateBuffer = new char[node.state.length];
			System.arraycopy(node.state, 0, stateBuffer, 0, node.state.length);
			Node buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			swapLeft(buffer.state, empty);
			// System.out.println("left");
			buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			// printState(buffer.state);
			// System.out.println(buffer.AStar);
			if (!isDiscarded(buffer) && !isInList(buffer)) {
				buffer.parent = node;
				count++;
				add(buffer);
			}
		}
		findEmpty(node.state);
		if (empty % 3 != 2) {
			char[] stateBuffer = new char[node.state.length];
			System.arraycopy(node.state, 0, stateBuffer, 0, node.state.length);
			Node buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			swapRight(buffer.state, empty);
			// System.out.println("right");
			buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			// printState(buffer.state);
			// System.out.println(buffer.AStar);
			if (!isDiscarded(buffer) && !isInList(buffer)) {
				buffer.parent = node;
				count++;
				add(buffer);
			}

		}
		findEmpty(node.state);
		if (empty > 2) {
			char[] stateBuffer = new char[node.state.length];
			System.arraycopy(node.state, 0, stateBuffer, 0, node.state.length);
			Node buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			swapUp(buffer.state, empty);
			// System.out.println("up");
			buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			// printState(buffer.state);
			// System.out.println(buffer.AStar);
			if (!isDiscarded(buffer) && !isInList(buffer)) {
				buffer.parent = node;
				count++;
				add(buffer);
			}

		}
		findEmpty(node.state);
		if (empty < 6) {
			char[] stateBuffer = new char[node.state.length];
			System.arraycopy(node.state, 0, stateBuffer, 0, node.state.length);
			Node buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			swapDown(buffer.state, empty);
			// System.out.println("down");
			buffer = new Node(stateBuffer, findManhattan(stateBuffer), findMisplaced(stateBuffer));
			// printState(buffer.state);
			// System.out.println(buffer.AStar);
			if (!isDiscarded(buffer) && !isInList(buffer)) {
				buffer.parent = node;
				count++;
				add(buffer);
			}

		}
	//	 System.out.println("buffer state here");

		// printState(buffer.state);
		// printState(first.state);
		// printState(first.next.state);
		deepen(first);

	}

	public static void add(Node newNode) {

		if (first == null) {
			first = newNode;
			return;
		}
		// System.out.println("first astar " + first.AStar);
		// System.out.println("new astar " + newNode.AStar);

		Node cur = first;

		// all here new
		if (newNode.AStar < cur.AStar) {
			newNode.next = first;
			cur.prev = newNode;
			first = newNode;
			/*
			 * cur = first; System.out.println("=-=-=-=-CURRENT LIST"); while
			 * (cur != null) {
			 * 
			 * System.out.print(cur.state); System.out.println(" " + cur.AStar);
			 * cur = cur.next; }
			 */
			return;
		}
		while (newNode.AStar >= cur.AStar) {
			// System.out.print("new ");
			// System.out.print(newNode.state);
			// System.out.println(" " + newNode.AStar);
			// System.out.print("cur ");
			// System.out.print(cur.state);
		//	 System.out.println(" " + cur.AStar);
			if (cur.next != null) {
				cur = cur.next;
			} else {
				newNode.prev = cur;
				cur.next = newNode;
				/*
				 * cur = first; System.out.println("=-=-=-=-CURRENT LIST");
				 * while (cur != null) {
				 * 
				 * System.out.print(cur.state); System.out.println(" " +
				 * cur.AStar); cur = cur.next; }
				 */
				return;
			}

		}
		newNode.next = cur;
		newNode.prev = cur.prev;
		cur.prev.next = newNode;
		cur.prev = newNode;
		/*
		 * System.out.println("=-=-=-=-CURRENT LIST"); cur = first; while (cur
		 * != null) {
		 * 
		 * System.out.print(cur.state); System.out.println(" " + cur.AStar); cur
		 * = cur.next; }
		 */

	}

	public static void solveRandom(char state[]) {
		
		count = 0;
		findEmpty(state);
		while (!isGoal(state)) {

			int answer = rn.nextInt(4);
			while ((answer == last) || (empty % 3 == 0 && answer == 0) || (empty % 3 == 2 && answer == 1)
					|| (empty < 3 && answer == 2) || (empty > 5 && answer == 3)) {
				answer = rn.nextInt(4);
			}

			if (answer == 0) {
				last = 1;
				swapLeft(state, empty);
			} else if (answer == 1) {
				last = 0;
				swapRight(state, empty);
			} else if (answer == 2) {
				last = 3;
				swapUp(state, empty);
			} else {
				last = 2;
				swapDown(state, empty);
			}
			// printState(state);
			// System.out.println(count);
			count++;
		}
		System.out.println(count);

	}

	public static char[] mixUp(char state[], int times) {
		Random rn = new Random();
		for (int i = 0; i < times; i++) {
			int answer = rn.nextInt(4);
			if (answer == 0) {
				swapLeft(state, empty);
			} else if (answer == 1) {
				swapRight(state, empty);
			} else if (answer == 2) {
				swapUp(state, empty);
			} else {
				swapDown(state, empty);
			}
			// printState(state);
		}
		return state;

	}

	public static void findEmpty(char state[]) {
		for (int i = 0; i < state.length; i++) {
			if (state[i] == 'X') {
				empty = i;
			}
		}
	}

	public static char[] swapLeft(char state[], int a) {
		if (a % 3 == 0) {
			// System.out.println("Couldn't swap left!");
			return state;
		} else {
			char buffer = state[a];
			state[a] = state[a - 1];
			state[a - 1] = buffer;
			empty = a - 1;
			return state;
		}

	}

	public static char[] swapRight(char state[], int a) {
		if (a == 2 || a == 5 || a == 8) {
			// System.out.println("Couldn't swap right!");
			return state;
		} else {
			char buffer = state[a];
			state[a] = state[a + 1];
			state[a + 1] = buffer;
			empty = a + 1;
			return state;
		}

	}

	public static char[] swapUp(char state[], int a) {
		if (a < 3) {
			// System.out.println("Couldn't swap up!");
			return state;
		} else {
			char buffer = state[a];
			state[a] = state[a - 3];
			state[a - 3] = buffer;
			empty = a - 3;
			return state;
		}

	}

	public static char[] swapDown(char state[], int a) {
		if (a > 5) {
			// System.out.println("Couldn't swap down!");
			return state;
		} else {
			char buffer = state[a];
			state[a] = state[a + 3];
			state[a + 3] = buffer;
			empty = a + 3;
			return state;
		}

	}

	public static boolean isInList(Node node) {
		if (first == null) {
			return false;
		}
		Node cur;
		cur = first;
		while (cur != null) {

			// System.out.print(node.state);

			// System.out.print(" " + node.AStar + " ");
			// System.out.print(cur.state);
			// System.out.println(" " + cur.AStar + " ");
			if (matches(node.state, cur.state)) {
				// System.out.println("is in list");
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	public static boolean isDiscarded(Node node) {

		if (discarded.size() == 0) {
			return false;
		}

		for (int i = 0; i < discarded.size(); i++) {
			if (matches(discarded.get(i).state, node.state)) {

				// System.out.println("is in discarded list!");
				// System.out.println(discarded.get(i).state);
				// System.out.println(node.state);
				return true;
			}
		}
		return false;
	}

	public static boolean isDiscarded2(Node node) {

		if (discarded2.size() == 0) {
			return false;
		}

		for (int i = 0; i < discarded2.size(); i++) {
			if (matches(discarded2.get(i).state, node.state)) {

				 System.out.println("is in discarded list!");
				 System.out.println(discarded2.get(i).state);
				 System.out.println(node.state);
				return true;
			}
		}
		return false;
	}

	public static boolean isGoal(char state[]) {
		for (int i = 0; i < state.length; i++) {
			if (state[i] != goal[i]) {
				return false;
			}
		}
		return true;
	}

	public static int findMisplaced(char state[]) {
		int misplaced = 0;
		for (int i = 0; i < state.length; i++) {
			if (state[i] != goal[i]) {
				misplaced++;
			}
		}
		return misplaced;
	}

	public static int findManhattan(char state[]) {
		int total = 0;

		for (int i = 0; i < state.length; i++) {
			total = total + findPosition(i, state[i]);
		}

		return total;
	}

	public static boolean matches(char[] first, char[] second) {
		for (int i = 0; i < first.length; i++) {
			// System.out.println(first[i]+" "+second[i]);
			if (first[i] != second[i]) {
				return false;
			}
		}
		return true;
	}

	public static int findPosition(int pos, char value) {
		int answer = 10000;
		int pos0[] = { 0, 1, 2, 1, 2, 3, 2, 3, 4 };
		int pos1[] = { 1, 0, 1, 2, 1, 2, 3, 2, 3 };
		int pos2[] = { 2, 1, 0, 3, 2, 1, 4, 3, 2 };
		int pos3[] = { 1, 2, 3, 0, 1, 2, 1, 2, 3 };
		int pos4[] = { 2, 1, 2, 1, 0, 1, 2, 1, 2 };
		int pos5[] = { 3, 2, 1, 2, 1, 0, 3, 2, 1 };
		int pos6[] = { 2, 3, 4, 1, 2, 3, 0, 1, 2 };
		int pos7[] = { 3, 2, 3, 2, 1, 2, 1, 0, 1 };
		int pos8[] = { 4, 3, 2, 3, 2, 1, 2, 1, 0 };

		if (pos == 0) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos0[i];
				}
			}

		} else if (pos == 1) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos1[i];
				}
			}

		} else if (pos == 2) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos2[i];
				}
			}

		} else if (pos == 3) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos3[i];
				}
			}

		} else if (pos == 4) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos4[i];
				}
			}

		} else if (pos == 5) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos5[i];
				}
			}

		} else if (pos == 6) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos6[i];
				}
			}

		} else if (pos == 7) {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos7[i];
				}
			}

		} else {
			for (int i = 0; i < goal.length; i++) {
				if (value == goal[i]) {
					answer = pos8[i];
				}
			}

		}
		return answer;

	}

}
