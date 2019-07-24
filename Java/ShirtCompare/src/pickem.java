import java.math.*;
import java.util.*;
public class pickem {
	
	public static int pandas = 1;
	public static int waves = 2;
	public static int tyedye = 3;
	public static int stripes = 4;
	public static final float ITERATIONS = 10000;
	
	static ArrayList<Integer> randGameScores = new ArrayList<>();
	
	public static void main(String [] args){
		
		ArrayList<Integer> oneRand = new ArrayList<>();
		ArrayList<Integer> twoRand = new ArrayList<>();
		
		oneRand.add(pandas);
		oneRand.add(waves);
		oneRand.add(tyedye);
		oneRand.add(stripes);
		
		twoRand.add(pandas);
		twoRand.add(waves);
		twoRand.add(tyedye);
		twoRand.add(stripes);
		
		System.out.print("What Player 1 thought was the same  : ");
		System.out.println(randonPlay(oneRand, twoRand));
		System.out.print("What Player 2 thought was better : ");
		System.out.println(gamePlay(oneRand, twoRand));
		
	}
	
	public static ArrayList<Integer> shuffle(ArrayList<Integer> l){
		
		Collections.shuffle(l);
		
		return l;
	}
	
	public static float randonPlay(ArrayList<Integer> s, ArrayList<Integer> w){
		
		int total = 0;
		int zeros = 0;
		int ones = 0;
		int twos = 0;
		int fours = 0;
		
		for(int i = 0; i < ITERATIONS; i++){
			
			shuffle(s); shuffle(w);
			
			int score = 0;
			
			if(s.get(0) == w.get(0)){
				score++;
			}
			if(s.get(1) == w.get(1)){
				score++;
			}
			if(s.get(2) == w.get(2)){
				score++;
			}
			if(s.get(3) == w.get(3)){
				score++;
			}

			total = total + score;
			if(score == 0)
				zeros++;
			if(score == 1)
				ones++;
			if(score == 2)
				twos++;
			if(score == 4)
				fours++;
		}
		
		//System.out.println("zeros: " + zeros + " ones: " + ones + " twos: " + twos + " fours: " + fours);
		
		float totalAvg = total/ITERATIONS;
		
		return totalAvg;
	}
	
	public static float gamePlay(ArrayList<Integer> s, ArrayList<Integer> w){
		
		int total = 0;
		int zeros = 0;
		int twos = 0;
		int fours = 0;
		
		for(int i = 0; i < ITERATIONS; i++){
			
			shuffle(s); shuffle(w);
			
			
			int score = 0;
			
			// w1 and s1 match
			if(s.get(0) == w.get(0)){
				score++;	
			}
			//s1 matches w0 AND w1 matches s0
			if(s.get(1)==w.get(0) && w.get(1)==s.get(0)){
				
				
				int swap = (int) (Math.random()%2+2);
				int temp = s.get(1);
				s.set(1, s.get(swap));
				s.set(swap, temp);
				
				swap = (int) (Math.random()%2+2);
				temp = w.get(1);
				w.set(1, w.get(swap));
				w.set(swap, temp);

			}
			//s1 matches w0
			else if(s.get(1)==w.get(0)){

				int swap = (int) (Math.random()%2+2);
				int temp = s.get(1);
				s.set(1, s.get(swap));
				s.set(swap, temp);
			//s0 matches w1
			}else if(w.get(1)==s.get(0)){

				int swap = (int) (Math.random()%2+2);
				int temp = w.get(1);
				w.set(1, w.get(swap));
				w.set(swap, temp);

			//all other cases + randomizer
			} else {

				int swap = (int)(Math.random()%3+1);
				int temp = s.get(1);
				s.set(1, s.get(swap));
				s.set(swap, temp);
				
				swap = (int)(Math.random()%3+1);
				temp = w.get(1);
				w.set(1, swap);
				w.set(swap, temp);


			}
			
			//s1 matches w1
			if(s.get(1)==w.get(1)){
				score++;
			}
			//s2 matches w1 or w0
			if(s.get(2)==w.get(1)||s.get(2)==w.get(0)){
				int temp = s.get(2);
				s.set(2, s.get(3));
				s.set(3, temp);
				

			//w2 matches s1 or s0
			}else if(w.get(2)==s.get(1)||w.get(2)==s.get(0)){
				
				int temp = w.get(2);
				w.set(2, w.get(3));
				w.set(3, temp);
				
			}else{
				int swap = (int)(Math.random()%2+2);
				int temp = s.get(2);
				s.set(2, s.get(swap));
				s.set(swap, temp);
				
				swap = (int)(Math.random()%2+2);
				temp = w.get(2);
				w.set(2, swap);
				w.set(swap, temp);
				

			}

		//	System.out.println("Score Smart: " + score);
			total = total + score;
				
		}
		//System.out.println("zeros: " + zeros + " twos: " + twos + " fours: " + fours);
		float totalAvg = total/ITERATIONS;
		
		return totalAvg;
	}

}
