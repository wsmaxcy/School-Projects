
public class EditDistance {

	public static void main(String[] args) {

		char x[] = { 'a', 'l', 'g', 'o', 'r', 'i', 't', 'h', 'm' };
		char y[] = { 'a', 'l', 't', 'r', 'u', 'i', 's', 't', 'i', 'c' };
		char z[] = { 'a', 't', 'l', 'a', 'n', 't', 'a' };
		char q[] = { 'a', 't', 'l', 'a', 'n', 't', 'i', 'c', 'a' };

		System.out.println(compare(x, y));
		System.out.println();
		System.out.println(compare(x, q));
		System.out.println();
		System.out.println(compare(x, z));
		System.out.println();
		System.out.println(compare(z, x));

	}

	public static double compare(char[] s1, char[] s2) {
		char[] finished = new char[s2.length];

		double cost = 0;
		int i = 0, j = 0;

		System.out.print("Action \n 	Word 1: ");
		printArr(s1,s1.length);
		System.out.print(" | Word 2: ");
		printArr(s2,s2.length);
		System.out.println();

		while (i != s1.length) {

			//System.out.print(j+1 + ". ");

			if (j == s2.length && i < s1.length) {
				System.out.print("kill\n--Final cost: ");
				cost = cost + 5;
				
				return cost;
			}

			// copy

			else if (s1[i] == s2[j]) {

				finished[j] = s1[i];
				System.out.print("copy        --  ");
				printArr1(s1,i);
				System.out.print(" | ");
				printArr(finished,j);
				System.out.println();

				j++;
				i++;

			}

			// twiddle 1.5

			else if (i + 1 < s1.length && j + 1 < s2.length && s1[i + 1] == s2[j] && s1[i] == s2[j + 1]) {
				cost = cost + 1.5;
				finished[j] = s1[i + 1];
				finished[j + 1] = s1[i];
				System.out.print("twiddle     --  ");
				printArr1(s1,i);
				System.out.print(" | ");
				printArr(finished,j);
				System.out.println();
				j = j + 2;
				i = i + 2;

			}

			// delete 1

			else if (j + 1 < s2.length && s1[i] == s2[j + 1]) {

				System.out.print("delete      --  ");
				printArr1(s1,i);
				System.out.print(" | ");
				printArr(finished,j);
				System.out.println();
				cost = cost + 1;
				i++;
				// j++;
			}

			// insert 1
			else if (s1[i] != s2[j] && contains(s2, s2[j], j + 1)) {

				finished[j] = s2[j];

				System.out.print("insert      --  ");
				printArr1(s1,i);
				System.out.print(" | ");
				printArr(finished,j);
				System.out.println();
				cost = cost + 1;
				j++;
				// i++;

			}

			// replace 2
			else if (s1[i] != s2[j]) {
				finished[j] = s2[j];
				System.out.print("replace     --  ");
				printArr1(s1,i);
				System.out.print(" | ");
				printArr(finished,j);
				System.out.println();
				cost = cost + 2;
				j++;
				i++;

			}

		}
		
		return cost;
	}

	public static boolean contains(char a[], char b, int x) {
		for (int i = x; i < a.length; i++) {
			if (a[i] == b) {
				return true;
			}
		}
		return false;
	}

	public static void printArr(char a[],int x) {

		for (int i = 0; i < a.length; i++) {
			if(i <= x){
				System.out.print(a[i]);
			} else {
				System.out.print("-");
			}
		}

	}

	public static void printArr1(char a[], int x) {

		for (int i = 0; i < a.length; i++) {
			if (i < x) {
				System.out.print(a[i]);
			} else {
				System.out.print("-");
			}
		}
	}

}
