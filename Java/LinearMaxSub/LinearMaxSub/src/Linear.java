//Will Maxcy - Project 1 - 9/23/2016
public class Linear {
	public static void main (String[]args){
		
		int [] array = {-2,1,-3,4,-1,2,1,-5,4};
		findMax(array);
	}
	public static void findMax(int[]a){
		int left = 0;
		int right = 0;
		int curSum = 0;
		int maxSum = 0;
		
		for(int i = 0; i<a.length; i++){
			
			curSum = curSum+a[i];
			
			if(a[i]>curSum){
				left = i;
				curSum = a[i];
			}
			if(curSum>maxSum){
				maxSum=curSum;
				right = i;
			}
			
	       
		}
		 System.out.println("Maximum sum in the array is: "+maxSum);
		 System.out.println("This ranges from position "+left+" to position "+right+" in the array.");
		 System.out.println("So, from "+a[left]+" to "+a[right]+" creates the highest sum in the array.");
		 System.out.print("These numbers are all");
		 
		 for(int l= left;l<=right;l++){
			 System.out.print(" "+a[l]);
		 }
		 System.out.print(".");
	}
	
}
