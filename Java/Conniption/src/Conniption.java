import java.util.Scanner;

public class Conniption {
	static int[] state = new int[42];
	static boolean turn;
	static int win;

	public static void main(String[] args) {
		win = 0;
		/*
		 * newState(); printState(state); drop(0); printState(state); drop(0);
		 * printState(state); drop(1); printState(state); drop(0);
		 * printState(state); drop(2); printState(state); drop(1);
		 * printState(state); drop(6); printState(state); drop(0);
		 * printState(state); flip(); printState(state); drop(0);
		 * printState(state); drop(0); printState(state); drop(6);
		 * printState(state); flip(); printState(state); flip();
		 * printState(state); drop(3); printState(state); drop(3);
		 * printState(state); drop(4); printState(state); drop(5);
		 * printState(state); drop(6); printState(state); drop(5);
		 * printState(state); drop(5); printState(state); drop(5);
		 * printState(state); drop(4); printState(state); flip();
		 * printState(state); flip(); printState(state); flip();
		 * printState(state); drop(3); printState(state); drop(2);
		 * printState(state);
		 */
		Scanner scan = new Scanner(System.in);
		while (win == 0) {
			System.out.println("What row would you like to play?");
			int x = scan.nextInt();
			if (x == 7) {
				flip();
				printState(state);
			} else if (x >= 0 && x < 7) {
				drop(x);
				printState(state);
				map(state);
			} else {
				System.out.println("retry");
			}

		}

	}

	public static void map(int[] state) {
		int[] stateMap = new int[42];

		int i = 0;
		while (i < 39) {

			// \diag
			if (i % 7 < 4 && i < 17) {
				// for x
				if (state[i] != 0 || state[i + 8] != 0 || state[i + 16] != 0 || state[i + 24] != 0) {
					if ((state[i] == 1 || state[i] == 0) && (state[i + 8] == 1 || state[i + 8] == 0)
							&& (state[i + 16] == 1 || state[i + 16] == 0)
							&& (state[i + 24] == 1 || state[i + 24] == 0)) {
						stateMap[i]++;
						stateMap[i + 8]++;
						stateMap[i + 16]++;
						stateMap[i + 24]++;
					}
				}
				// for o
				if (state[i] != 0 || state[i + 8] != 0 || state[i + 16] != 0 || state[i + 24] != 0) {
					if ((state[i] == 2 || state[i] == 0) && (state[i + 8] == 2 || state[i + 8] == 0)
							&& (state[i + 16] == 2 || state[i + 16] == 0)
							&& (state[i + 24] == 2 || state[i + 24] == 0)) {
						stateMap[i]++;
						stateMap[i + 8]++;
						stateMap[i + 16]++;
						stateMap[i + 24]++;
					}
				}

			}
			// / diag
			if (i % 7 > 2 && i < 21) {
				// for x
				if (state[i] != 0 || state[i + 6] != 0 || state[i + 12] != 0 || state[i + 18] != 0) {
					if ((state[i] == 1 || state[i] == 0) && (state[i + 6] == 1 || state[i + 6] == 0)
							&& (state[i + 12] == 1 || state[i + 12] == 0)
							&& (state[i + 18] == 1 || state[i + 18] == 0)) {
						stateMap[i]++;
						stateMap[i + 6]++;
						stateMap[i + 12]++;
						stateMap[i + 18]++;
					}
				}
				// for o
				if (state[i] != 0 || state[i + 6] != 0 || state[i + 12] != 0 || state[i + 18] != 0) {
					if ((state[i] == 2 || state[i] == 0) && (state[i + 6] == 2 || state[i + 6] == 0)
							&& (state[i + 12] == 2 || state[i + 12] == 0)
							&& (state[i + 18] == 2 || state[i + 18] == 0)) {
						stateMap[i]++;
						stateMap[i + 6]++;
						stateMap[i + 12]++;
						stateMap[i + 18]++;
					}
				}

			}
			// vert
			if (i < 21) {
				// for x
				if (state[i] != 0 || state[i + 7] != 0 || state[i + 14] != 0 || state[i + 21] != 0) {
					if ((state[i] == 1 || state[i] == 0) && (state[i + 7] == 1 || state[i + 7] == 0)
							&& (state[i + 14] == 1 || state[i + 14] == 0)
							&& (state[i + 21] == 1 || state[i + 21] == 0)) {
						stateMap[i]++;
						stateMap[i + 7]++;
						stateMap[i + 14]++;
						stateMap[i + 21]++;
					}
				}
				// for o
				if (state[i] != 0 || state[i + 7] != 0 || state[i + 14] != 0 || state[i + 21] != 0) {
					if ((state[i] == 2 || state[i] == 0) && (state[i + 7] == 2 || state[i + 7] == 0)
							&& (state[i + 14] == 2 || state[i + 14] == 0)
							&& (state[i + 21] == 2 || state[i + 21] == 0)) {
						stateMap[i]++;
						stateMap[i + 7]++;
						stateMap[i + 14]++;
						stateMap[i + 21]++;
					}
				}

			}
			// horz
			if (i % 7 < 4) {
				// for x
				if (state[i] != 0 || state[i + 1] != 0 || state[i + 2] != 0 || state[i + 3] != 0) {
					if ((state[i] == 1 || state[i] == 0) && (state[i + 1] == 1 || state[i + 1] == 0)
							&& (state[i + 2] == 1 || state[i + 2] == 0) && (state[i + 3] == 1 || state[i + 3] == 0)) {
						stateMap[i]++;
						stateMap[i + 1]++;
						stateMap[i + 2]++;
						stateMap[i + 3]++;
					}
				}
				// for o
				if (state[i] != 0 || state[i + 1] != 0 || state[i + 2] != 0 || state[i + 3] != 0) {
					if ((state[i] == 2 || state[i] == 0) && (state[i + 1] == 2 || state[i + 1] == 0)
							&& (state[i + 2] == 2 || state[i + 2] == 0) && (state[i + 3] == 2 || state[i + 3] == 0)) {
						stateMap[i]++;
						stateMap[i + 1]++;
						stateMap[i + 2]++;
						stateMap[i + 3]++;
					}
				}

			}
			i++;
		}
		for (int j = 0; j < state.length; j++) {
			if (state[j] != 0) {
				stateMap[j] = 0;
			}
		}

		printStateMap(stateMap);

	}

	public static void checkWin() {
		int i = 0;
		while (i < 39) {

			// front and back diag, vertical
			if (i % 7 < 4 && i < 21) {
				// back diag
				if (state[i] != 0 && state[i] == state[i + 8] && state[i] == state[i + 16]
						&& state[i] == state[i + 24]) {
					System.out.println("YOU WIN! left diag");
					win = 1;
					return;
				}
			}
			if (i % 7 > 2 && i < 21) {
				// right diag
				if (state[i] != 0 && state[i] == state[i + 6] && state[i] == state[i + 12]
						&& state[i] == state[i + 18]) {
					System.out.println("YOU WIN! right diag");
					win = 1;
					return;
				}
			}
			if (i % 7 < 4) {
				// horizontal
				if (state[i] != 0 && state[i] == state[i + 1] && state[i] == state[i + 2] && state[i] == state[i + 3]) {
					System.out.println("YOU WIN! horozontal");
					win = 1;
					return;
				}
			}
			if (i < 21) {
				// vertical
				if (state[i] != 0 && state[i] == state[i + 7] && state[i] == state[i + 14]
						&& state[i] == state[i + 21]) {
					System.out.println("YOU WIN! vertical");
					win = 1;
					return;
				}
			}

			i++;
		}

	}

	public static void flip() {
		int[] buffer = new int[42];
		System.arraycopy(state, 0, buffer, 0, state.length);
		newState();
		for (int i = 0; i < buffer.length; i++) {
			if (buffer[i] != 0) {
				drop(i % 7, buffer[i]);
			}
		}

		checkWin();

	}

	public static void drop(int slot) {
		int check = 0;
		if (slot > 6) {
			System.out.println("must be between numbers 0 - 6.");
			return;
		}

		for (int i = state.length; i > 0; i = i - 7) {
			if (state[i - (7 - slot)] == 0) {
				if (turn) {
					state[i - (7 - slot)] = 1;
					check = 1;
					break;
				} else {
					state[i - (7 - slot)] = 2;
					check = 1;
					break;
				}
			}
		}
		if (check == 1) {
			if (turn) {
				turn = false;
			} else {
				turn = true;
			}
		} else {
			System.out.println("row full, pick another row!");
		}
		checkWin();

	}

	public static void drop(int slot, int num) {
		for (int i = state.length; i > 0; i = i - 7) {
			if (state[i - (7 - slot)] == 0) {

				state[i - (7 - slot)] = num;
				break;

			}
		}
	}

	public static void printState(int[] state) {
		// 1 = X
		// 2 = O

		for (int i = 0; i < state.length; i++) {
			if (state[i] == 0) {
				System.out.print("| ");
			} else if (state[i] == 1) {
				System.out.print("|X");
			} else if (state[i] == 2) {
				System.out.print("|O");
			} else {
				System.out.println("error");
				return;
			}
			if (i % 7 == 6) {
				System.out.println("|");
			}
		}
		System.out.println();

	}

	public static void printStateMap(int[] state) {
		for (int i = 0; i < state.length; i++) {
			System.out.print("|" + state[i]);
			if (i % 7 == 6) {
				System.out.println("|");
			}
		}
	}

	public static void newState() {
		for (int i = 0; i < state.length; i++) {
			state[i] = 0;
		}
	}

}
