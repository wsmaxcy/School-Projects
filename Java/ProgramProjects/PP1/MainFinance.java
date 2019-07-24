/* 
  Name: Will Maxcy 
  Email: wsmaxcy@go.olemiss.edu
  Current Date: 2/5/13 
  Course Information: CSCI 112 - Section 02
  Instructor: Judy Etchison
  Program Description: Replace this with a brief description of the purpose of the 
  class's  responsibilities. 
  Sources Consulted: None.
  Honor Code Statement: In keeping with the honor code policies of the University of Mississippi, the School of Engineering,
   and the Department of Computer and Information Science, I affirm that I have neither given nor received assistance on this
   programming assignment. This assignment represents my individual, original effort. 
                   
*/

import java.util.Scanner;
public class MainFinance 
{
	public static void main (String [] args)
	{
		//creating account array.
		Expense[] account = new Expense[5];
		//creating account objects within the account array using the different methods inside the expense class.
		account[0]= new Expense(14.56);
		account[0].Desc("Food");
		account[0].Date("1/04/2012");
		account[0].Time("15:34:11");
		account[1]= new Expense();
		account[1].setExpense(231.48);
		account[1].Desc("Textbook");
		account[1].Date("1/09/2012");
		account[1].Time("09:14:24");
		account[2]= new Expense();
		account[2].setExpense(40.00);
		account[2].Desc("Gas");
		account[2].Date("1/14/2012");
		account[2].Time("17:42:52");
		account[3]= new Expense();
		account[3].setExpense(7.23);
		account[3].Desc("Food");
		account[3].Date("1/20/2012");
		account[3].Time("21:32:42");
		account[4]= new Expense();
		account[4].setExpense(33.00);
		account[4].Desc("Gas");
		account[4].Date("1/24/2012");
		account[4].Time("03:43:55");
		//creating scanner, budg, and total objects in order to find if the user is over or under their monthly budget.
		System.out.print("Enter Current monthly budget: $");
		Scanner scan = new Scanner(System.in);
		double budg = scan.nextDouble();
		double total = 0.0;
		//for loop used to find the sum of all of the expenses of the multiple objects in the array.
		for (int i = 0; i < account.length; i++)
		{
			total = ((account[i].getExpense()) + total);
		}
		//if statement used to tell if the user is over or under budget
		if(total <= budg)
			System.out.println("You are currently UNDER BUDGET.");
		else
			System.out.println("You are currently OVER BUDGET.");
		int j = 1;
		//for loop used to print out the properties of each expense object in the array.
		for (int i = 0; i < account.length; i++)
		{
			System.out.println("");
			System.out.println("Expense "+j);
			System.out.println("--------------");
			System.out.println("Spent: $"+account[i].getExpense());
			System.out.println("Item Type: "+account[i].getDesc());
			System.out.println("Date: "+account[i].getDate());
			System.out.println("Time: "+account[i].getTime());
			j++;
		}
		//print out of the grand total of all expenses in the array.
		System.out.println("");
		System.out.println("Grand total: $"+total+".");
	}
}
