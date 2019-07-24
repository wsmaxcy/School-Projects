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

//setting the class as public, naming it budget, creating class variables.
public class Budget 
{
	private Expense [] expenses;
	private int count;
	private double budgetAmount;
	private String name;
	
	//creating open budget class that automatically sets a budget object with no constructors.
	public Budget ()
	{
		name = "";
		budgetAmount = 0;
		count = 0;
		expenses = new Expense[7];
	}
	
	//method allowing the name of the budget object as well as the budget amount to be declared.
	public Budget (String n, double amt)
	{
		name = n;
		budgetAmount = amt;
		count = 0;
		expenses = new Expense[7];
	}
	
	//get method that returns the budget amount
	public double getAmount()
	{
		return budgetAmount;
	}
	
	//get method that returns the name
	public String getName()
	{
		return name;
	}
	
	//get method that returns the expense string.
	public Expense[] getExpense()
	{
		return expenses;
	}
	
	//get method that returns the count
	public int getCount()
	{
		return count;
	}
	
	//set method that sets the budget amount
	public void setAmount(double amt)
	{
		budgetAmount = amt;
	}
	
	//set method that sets the name
	public void setName (String n)
	{
		name = n;
	}
	
	//set method that sets the count
	public void setCount(int cnt)
	{
		count = cnt;
	}
	
	//sort expense method that sorts through the expenses and aligns them from low to high from expense
	public void sortExpense()
	{
		//Starting of the sorting loop that places the order of the prices spend from low to high
				int startScan;
				int index, minIndex;
				double minValue;
				
				for(startScan = 0; startScan < (expenses.length-1); startScan++)
				{
					minIndex=startScan;
					minValue= (int) expenses[startScan].getExpense();
					for(index = startScan +1; index <expenses.length; index++)
					{
						if (expenses[index].getExpense() < minValue)
						{
							minValue = expenses[index].getExpense();
							minIndex = index;
						}


					}
					//changing the data members in each of the account objects
					expenses[minIndex].setExpense(expenses[startScan].getExpense());
					expenses[minIndex].Desc(expenses[startScan].getDesc());
					expenses[minIndex].Date(expenses[startScan].getDate());
					expenses[minIndex].Time(expenses[startScan].getTime());
					expenses[startScan].setExpense(minValue);
					expenses[startScan].Date(expenses[minIndex].getDate());
					expenses[startScan].Time(expenses[minIndex].getTime());
					expenses[startScan].Desc(expenses[minIndex].getDesc());
				}
		
	}
	
	//over 100 method that prints the expense that are over 100
	public void over100()
	{
		System.out.println("");
		System.out.println("----------------------------------------------");
		System.out.println("List of expenses above $100 in Ascending order");
		System.out.println("For "+name+" with a budge of "+budgetAmount);
		System.out.println("----------------------------------------------");
		System.out.println("");
		
		int k = 1;
		//for loop with an if statement used to print out only the purchases that were over 100 dollars and also in order from lowest to
		//highest in amount spent
		for (int l = 0; l < expenses.length ; l++)
		{
			if (expenses[l].getExpense() > 100)
			{
				System.out.println("");
				System.out.println("Expense "+ k);
				System.out.println("--------------");
				System.out.println("Spent: $"+expenses[l].getExpense());
				System.out.println("Item Type: "+expenses[l].getDesc());
				System.out.println("Date: "+expenses[l].getDate());
				System.out.println("Time: "+expenses[l].getTime());
			k++;
			}
		}

	}
	
	//display method that displays all of the expense objects and the information that goes with them
	public void display()
	{
		//print out of the grand total of all expenses in the array.

		System.out.println("");
		System.out.println("----------------------------------------------");
		System.out.println("List of expenses for "+ name+ " with a budget of $"+budgetAmount);
		System.out.println("----------------------------------------------");
		System.out.println("");

		int j = 1;
		//for loop used to print out the properties of each expense object in the array.
		for (int i = 0; i < expenses.length; i++)
		{
			System.out.println("");
			System.out.println("Expense "+j);
			System.out.println("--------------");
			System.out.println("Spent: $"+expenses[i].getExpense());
			System.out.println("Item Type: "+expenses[i].getDesc());
			System.out.println("Date: "+expenses[i].getDate());
			System.out.println("Time: "+expenses[i].getTime());
			j++;
		}
	}
	
	//add expense method that adds a new expense amount, description, date, and time
	public void addExpense (double exp, String desc, String date, String time)
	{
		expenses[count]= new Expense(exp, desc, date, time);
		++count;
		
	}
}
