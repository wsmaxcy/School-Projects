import java.util.Scanner;
public class average 
{
	public static void main (String [] args)
	{
		Scanner scan = new Scanner (System.in);
		double  num1, num2, num3, average;
		
		System.out.println("Enter number 1"); 
		num1 = scan.nextDouble();
		
		System.out.println("Enter number 2");
		num2 = scan.nextDouble();
		
		System.out.println("Enter number 3");
		num3 = scan.nextDouble();
		
		average = ((num1+num2+num3)/3);
		System.out.println("the average of the three numbers is "+average+".");
	}
}