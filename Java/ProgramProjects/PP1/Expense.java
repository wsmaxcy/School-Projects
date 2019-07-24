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
public class Expense 
{
	//setting class variables
	private double total;
	private String descS;
	private String dateS;
	private String timeS;
	//expense class used to set the expense to 0 if there is no argument passed through the expense.
	public Expense()
	{	
		total = 0;	
	}
	//mutator method used to set the numerical value of the expense
	public Expense(double exp)
	{	
		total = exp;	
	}
	//another mutuator method used to set the numerical value of the expense
	public void setExpense(double set)
	{
		total = set;
	}
	//mutator method used to set the description of the object
	public void Desc (String desc)
	{
		descS = desc;
	}
	//mutator method used to set the date of the object
	public void Date (String date)
	{
		dateS = date;
	}
	//mutator method used to set the time that the object was bought.
	public void Time (String time)
	{
		timeS = time;
	}
	//accessor method used to return the expense of the object
	public double getExpense()
	{
		return total;
	}
	//accessor method used to return the description of the object
	public String getDesc()
	{
		return descS;
	}
	//accessor method used to return the date of the object
	public String getDate()
	{
		return dateS;
	}
	//accessor method used to return the time that the object was bought.
	public String getTime()
	{
		return timeS;
	}
}
