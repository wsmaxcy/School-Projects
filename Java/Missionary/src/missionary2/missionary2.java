//Will Maxcy 9/24/15
//Program 1

package missionary2;

import java.util.ArrayList;
import java.util.Scanner;

public class missionary2 {
	static int BOAT_NUM;
	static int TOTAL_CAN;
	static int TOTAL_MIS;
	static ArrayList<State> list = new ArrayList<State>();
	static State END_STATE;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the number of seats in the boat between 2 and 4 : ");
		BOAT_NUM = scan.nextInt();
		while (BOAT_NUM < 2 || BOAT_NUM > 4) {
			System.out.println("Bruh, you need to put between 2 and 4 seats for this boat");
			BOAT_NUM = scan.nextInt();
		}

		System.out.print("Enter the number of total cannibals between 2 and 6 : ");
		TOTAL_CAN = scan.nextInt();
		while (TOTAL_CAN < 2 || TOTAL_CAN > 6) {
			System.out.println("Hey, you need between 2 and 6 cannibals! Try again!");
			TOTAL_CAN = scan.nextInt();
		}

		System.out.print("Enter the number of total missionaries between 2 and 6 : ");
		TOTAL_MIS = scan.nextInt();
		while (TOTAL_MIS < 2 && TOTAL_MIS > 6) {
			System.out.println("It isn't that hard to type a number between 2 and 6. Try again.");
			TOTAL_MIS = scan.nextInt();
		}
		while (TOTAL_CAN > TOTAL_MIS) {
			System.out.println(
					"More cannibals than missionaries! Side unsafe! Use more or the same amount of missionaries!");
			TOTAL_MIS = scan.nextInt();
		}

		scan.close();

		State dead = new State(0, 0, 0, 0, false, null);
		State state = new State(TOTAL_CAN, 0, TOTAL_MIS, 0, true, dead);
		END_STATE = new State(0, TOTAL_CAN, 0, TOTAL_MIS, false, null);

		cross(state);
		System.out.println("No known solution for this problem :(");

	}

	public static void cross(State state) {

		if (isEqual(state, END_STATE)) {
			printFinal(state);
			System.exit(1);
		}
		//printState(state);
		if (state.parent.parent != null) {
			// System.out.println(isLooped(state,state.parent));
			if (isLooped(state, state.parent)) {
				return;
			}
		}
		if (state.boatLeft == true) {
			if (BOAT_NUM > 3) {
				// ------4------//

				// CCCC>
				if (state.left_can > 3) {
					State bufferState = new State(state.left_can - 4, state.right_can + 4, state.left_mis,
							state.right_mis, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// CCCM>
				// death!

				// CCMM>
				if (state.left_can > 1 && state.left_mis > 1) {
					State bufferState = new State(state.left_can - 2, state.right_can + 2, state.left_mis - 2,
							state.right_mis + 2, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// CMMM>
				if (state.left_can > 0 && state.left_mis > 2) {
					State bufferState = new State(state.left_can - 1, state.right_can + 1, state.left_mis - 3,
							state.right_mis + 3, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// MMMM>
				if (state.left_mis > 3) {
					State bufferState = new State(state.left_can, state.right_can, state.left_mis - 4,
							state.right_mis + 4, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}
			}
			if (BOAT_NUM > 2) {
				// CCC>
				if (state.left_can > 2) {
					State bufferState = new State(state.left_can - 3, state.right_can + 3, state.left_mis,
							state.right_mis, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}
				// CCM>
				// get eaten on the boat!

				// CMM>
				if (state.left_can > 0 && state.left_mis > 1) {
					State bufferState = new State(state.left_can - 1, state.right_can + 1, state.left_mis - 2,
							state.right_mis + 2, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}
				// get eaten on the boat!

				// MMM>
				if (state.left_mis > 2) {
					State bufferState = new State(state.left_can, state.right_can, state.left_mis - 3,
							state.right_mis + 3, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

			}
			// C>
			if (state.left_can > 0) {
				State bufferState = new State(state.left_can - 1, state.right_can + 1, state.left_mis, state.right_mis,
						false, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}
			// M>
			if (state.left_mis > 0) {
				State bufferState = new State(state.left_can, state.right_can, state.left_mis - 1, state.right_mis + 1,
						false, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}

			}
			// CC>
			if (state.left_can > 1) {
				State bufferState = new State(state.left_can - 2, state.right_can + 2, state.left_mis, state.right_mis,
						false, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}

			// MM>
			if (state.left_mis > 1) {
				State bufferState = new State(state.left_can, state.right_can, state.left_mis - 2, state.right_mis + 2,
						false, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}

			// CM>
			if (state.left_can > 0 && state.right_can > 0) {
				State bufferState = new State(state.left_can - 1, state.right_can + 1, state.left_mis - 1,
						state.right_mis + 1, false, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}
			
		} else {
			// ------4------//
			if (BOAT_NUM > 3) {
				// CCCC<
				if (state.right_can > 3) {
					State bufferState = new State(state.left_can + 4, state.right_can - 4, state.left_mis,
							state.right_mis, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// CCCM<
				// will get eaten on the boat!

				// CCMM<
				if (state.right_can > 1 && state.right_mis > 1) {
					State bufferState = new State(state.left_can + 2, state.right_can - 2, state.left_mis + 2,
							state.right_mis - 2, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// CMMM<
				if (state.right_can > 0 && state.right_mis > 2) {
					State bufferState = new State(state.left_can + 1, state.right_can - 1, state.left_mis + 3,
							state.right_mis - 3, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// MMMM<
				if (state.right_mis > 3) {
					State bufferState = new State(state.left_can, state.right_can, state.left_mis + 4,
							state.right_mis - 4, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}
			}
			// -------3------//
			if (BOAT_NUM > 2) {
				// CCC<
				if (state.right_can > 2) {
					State bufferState = new State(state.left_can + 3, state.right_can - 3, state.left_mis,
							state.right_mis, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}
				// CCM<
				// get eaten on the boat!

				// CMM<
				if (state.right_can > 1 && state.right_mis > 0) {
					State bufferState = new State(state.left_can + 1, state.right_can - 1, state.left_mis + 2,
							state.right_mis - 2, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// MMM<
				if (state.right_mis > 2) {
					State bufferState = new State(state.left_can, state.right_can, state.left_mis + 3,
							state.right_mis - 3, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

			}
			// C<
			if (state.right_can > 0) {
				State bufferState = new State(state.left_can + 1, state.right_can - 1, state.left_mis, state.right_mis,
						true, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}

			// M<
			if (state.right_mis > 0) {
				State bufferState = new State(state.left_can, state.right_can, state.left_mis + 1, state.right_mis - 1,
						true, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}

			// CC<
			if (state.right_can > 1) {
				State bufferState = new State(state.left_can + 2, state.right_can - 2, state.left_mis, state.right_mis,
						true, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}

			// MM<
			if (state.right_mis > 1) {
				State bufferState = new State(state.left_can, state.right_can, state.left_mis + 2, state.right_mis - 2,
						true, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}

			// CM<
			if (state.right_can > 0 && state.right_mis > 0) {
				State bufferState = new State(state.left_can + 1, state.right_can - 1, state.left_mis + 1,
						state.right_mis - 1, true, state);
				if (isSafe(bufferState)) {
					cross(bufferState);
				}
			}
			// -------3------//
			if (BOAT_NUM > 2) {
				// CCC<
				if (state.right_can > 2) {
					State bufferState = new State(state.left_can + 3, state.right_can - 3, state.left_mis,
							state.right_mis, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}
				// CCM<
				// get eaten on the boat!

				// CMM<
				if (state.right_can > 1 && state.right_mis > 0) {
					State bufferState = new State(state.left_can + 1, state.right_can - 1, state.left_mis + 2,
							state.right_mis - 2, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

				// MMM<
				if (state.right_mis > 2) {
					State bufferState = new State(state.left_can, state.right_can, state.left_mis + 3,
							state.right_mis - 3, false, state);
					if (isSafe(bufferState)) {
						cross(bufferState);
					}
				}

			}
			
		}

	}

	public static void printState(State state) {

		for (int i = 0; i < state.left_can; i++) {
			System.out.print("C");
		}
		for (int j = 0; j < state.left_mis; j++) {
			System.out.print("M");
		}
		if (state.boatLeft) {
			System.out.print(" < ");
		} else {
			System.out.print(" > ");
		}
		for (int i = 0; i < state.right_can; i++) {
			System.out.print("C");
		}
		for (int j = 0; j < state.right_mis; j++) {
			System.out.print("M");
		}
		System.out.println("");

	}

	public static boolean isLooped(State state1, State state2) {
		// System.out.println("--Comparing--");
		// printState(state1);
		// System.out.println("--vs--");
		// if (state2 != null) {
		// printState(state2);
		// }
		if (state2 == null) {
			return false;
		}
		if (isEqual(state1, state2)) {
			// System.out.println("looped!");
			return true;
		} else {
			isLooped(state1, state2.parent);
		}
		return isLooped(state1, state2.parent);

	}

	public static boolean isEqual(State state1, State state2) {
		if (state1.left_can == state2.left_can && state1.left_mis == state2.left_mis
				&& state1.right_can == state2.right_can && state1.right_mis == state2.right_mis
				&& state1.boatLeft == state2.boatLeft) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isSafe(State state) {
		if (state.left_can <= state.left_mis || state.left_mis == 0) {
			if (state.right_can <= state.right_mis || state.right_mis == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static void printFinal(State state) {
		int count = 0;
		System.out.println("---Start---");
		while (state != null) {
			list.add(state);
			count++;
			//printState(state);
			state = state.parent;
		}
		for(int i = count; i > 1; i--){
			printState(list.get(i-2));
			
		}
		System.out.println("----End----");
	}
}
