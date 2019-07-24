/* 
  Name: Will Maxcy 
  Email: wsmaxcy@go.olemiss.edu
  Current Date: 2/11/13 
  Course Information: CSCI 112 - Section 02
  Instructor: Judy Etchison
  Program Description: Taking the expense objects and ordering them from lowest to highest in numerical order. Also printing out the
  expense object data members as well. 
  Sources Consulted: None.
  Honor Code Statement: In keeping with the honor code policies of the University of Mississippi, the School of Engineering,
   and the Department of Computer and Information Science, I affirm that I have neither given nor received assistance on this
   programming assignment. This assignment represents my individual, original effort. 
                   
*/
public class MainFinance 
{
	public static void main (String [] args)
	{
		//creating account array.
		Expense[] account = new Expense[7];
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
		account[2].setExpense(100.00);
		account[2].Desc("Gas");
		account[2].Date("1/14/2012");
		account[2].Time("17:42:52");
		account[3]= new Expense();
		account[3].setExpense(284.64);
		account[3].Desc("Food");
		account[3].Date("1/20/2012");
		account[3].Time("21:32:42");
		account[4]= new Expense();
		account[4].setExpense(100.01);
		account[4].Desc("Gas");
		account[4].Date("1/24/2012");
		account[4].Time("03:43:55");
		account[5]= new Expense();
		account[5].setExpense(8000.00);
		account[5].Desc("Beer");
		account[5].Date("2/11/2013");
		account[5].Time("04:25:55");
		account[6]= new Expense();
		account[6].setExpense(12.55);
		account[6].Desc("Pants");
		account[6].Date("4/24/2013");
		account[6].Time("12:24:00");
		
		//print out of the grand total of all expenses in the array.

		System.out.println("");
		System.out.println("----------------------------------------------");
		System.out.println("List of expenses ");
		System.out.println("----------------------------------------------");
		System.out.println("");

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
		System.out.println("----------------------------------------------");
		System.out.println("List of expenses above $100 in Ascending order");
		System.out.println("----------------------------------------------");
		System.out.println("");
		
		//Starting of the sorting loop that places the order of the prices spend from low to high
		int startScan;
		int index, minIndex;
		double minValue;
		int i = 0;
		for(startScan = 0; startScan < (account.length-1); startScan++)
		{
			minIndex=startScan;
			minValue= (int) account[startScan].getExpense();
			for(index = startScan +1; index <account.length; index++)
			{
				if (account[index].getExpense() < minValue)
				{
					minValue = account[index].getExpense();
					minIndex = index;
				
				}


			}
			//changing the data members in each of the account objects
			account[minIndex].setExpense(account[startScan].getExpense());
			account[minIndex].Desc(account[startScan].getDesc());
			account[minIndex].Date(account[startScan].getDate());
			account[minIndex].Time(account[startScan].getTime());
			account[startScan].setExpense(minValue);
			account[startScan].Date(account[minIndex].getDate());
			account[startScan].Time(account[minIndex].getTime());
			account[startScan].Desc(account[minIndex].getDesc());
			System.out.println(index);
			System.out.println(minIndex);

			

		}
		int k = 1;
		//for loop with an if statement used to print out only the purchases that were over 100 dollars and also in order from lowest to
		//highest in amount spent
		for (int l = 0; l < account.length ; l++)
		{
			if (account[l].getExpense() > 100)
			{
				System.out.println("");
				System.out.println("Expense "+ k);
				System.out.println("--------------");
				System.out.println("Spent: $"+account[l].getExpense());
				System.out.println("Item Type: "+account[l].getDesc());
				System.out.println("Date: "+account[l].getDate());
				System.out.println("Time: "+account[l].getTime());
			k++;
			}
		}

	}

}
