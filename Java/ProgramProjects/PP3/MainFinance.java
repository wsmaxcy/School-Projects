/* 
  Name: Will Maxcy 
  Email: wsmaxcy@go.olemiss.edu
  Current Date: 2/18/13 
  Course Information: CSCI 112 - Section 02
  Instructor: Judy Etchison
  Program Description: Taking the expense objects and ordering them from lowest to highest in numerical order. Doing this with 
  a main class, an expense class, and a budget class. the budget class is now responsible for holding all of the budget information,
  and methods that manipulate the budget and budget objects. The expense class is limited to manipulating the expense objects themselves
  Sources Consulted: None.
  Honor Code Statement: In keeping with the honor code policies of the University of Mississippi, the School of Engineering,
   and the Department of Computer and Information Science, I affirm that I have neither given nor received assistance on this
   programming assignment. This assignment represents my individual, original effort. 
                   
*/
public class MainFinance 
{
	public static void main (String [] args)
	{
		//creating new budget object that will take on the name of Will and have a budget amount of 500
		Budget budg = new Budget("Will", 500.00);
		
		//creating new expenses in the budget class with the money amount, description, date, and time	
		
		budg.addExpense(14.56, "Food,","1/04/2012","15:34:11");
		budg.addExpense(231.48, "Textbook","1/09/2012","09:14:24");
		budg.addExpense(100.00,"Gas","1/14/2012","17:42:52");
		budg.addExpense(284.64,"Food","1/20/2012","21:32:42");
		budg.addExpense(100.01,"Gas","1/24/2012","03:43:55");
		budg.addExpense(800.00,"Beer","2/11/2013","04:25:55");
		budg.addExpense(12.55,"Pants","4/24/2013","12:24:00");
		
		
		//first displaying the budget objects
		budg.display();
		//sorting the objects by expense price
		budg.sortExpense();
		//setting the name of the expenses to clempton
		budg.setName("Clempton");
		//changing the amount of the budget to 5200
		budg.setAmount(5200);
		//displaying the new, arranged expenses
		budg.display();
		//displaying the new, arranged expenses with expense prices over 100
		budg.over100();
		
		
	}

}
