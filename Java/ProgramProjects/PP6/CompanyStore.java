//import java.io so that exceptions can be caught and thrown. Imported ArrayList in order to be able to use the ArrayList object
import java.io.*;
import java.util.ArrayList;
//declaring class and setting class objects
public class CompanyStore
{
	String storeName;
	ArrayList<Order> list;
	//constructors
	public CompanyStore()
	{
		storeName = "";
		list = new ArrayList<Order>(20);
	}
	
	public CompanyStore(String name)
	{
		storeName = name;
		list = new ArrayList<Order>(20);
	}
	//accessor and mutator methods.
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public ArrayList<Order> getList() {
		return list;
	}

	public void setList(ArrayList<Order> list) {
		this.list = list;
	}
	//adding an order to the ArrayList of orders.
	public void addOrder(Order o)
	{
		list.add(o);
	}
	//Saving the individual Order objects stored inside the ArrayList by going through each index and saving each object located
	// in that index as a binary file. This binary file is in the filename object. This is done using the FileOutputStream
	//and ObjectOutputStream objects.
	//created this class to thrown an IOExceptoin in order to be able to manually handle io class excpetions.
	public void saveOrders(String filename) throws IOException
	{
		FileOutputStream orderfile = new FileOutputStream(filename);
		ObjectOutputStream objectFile = new ObjectOutputStream (orderfile);
		
		for (int i = 0; i < list.size(); i++)
		{
			objectFile.writeObject(list.get(i));
		}
		objectFile.close();
	}
	//Reads back in from the file that is specified in the filename object. catches error if filename does is not a binary file or 
	//does not match the file type that is specified. cathces error if class is not found for the ObjectInputStream and FileInputStream.
	public void readOrders(String filename) throws IOException
	{
		ArrayList<Order> list = new ArrayList<Order>();
		FileInputStream orderfile = new FileInputStream(filename);
		ObjectInputStream objectFile = new ObjectInputStream(orderfile);
		int count = 0;
		
		try
		{
			while(true)
			{
				list.add(count, (Order) objectFile.readObject());
				++count;
			}
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File was not found.");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("attempt to read an object of a type not defined");
		}
		catch (EOFException e)
		{
			objectFile.close();
		}
	}
	//displays all of the Orders by using two for loops to go through each order, then each purchase in that order. Uses toString
	//methods in Purchaser and Purchases classes in order to print off what is needed.
	public void displayOrders()
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println("Order Number "+ (i+1));
			System.out.println("Store Name: "+ storeName);
			System.out.println("Order Date: "+list.get(i).date);
			System.out.println("-------------------");
			System.out.println(list.get(i).getID().toString());
			for (int j = 0; j < list.get(i).getCount(); j++)
			{
				System.out.println("Item "+(j+1));
				System.out.println(list.get(i).items[j].toString());
			}
			System.out.println("Order Total: "+list.get(i).getTotal());
			System.out.println("-------------------");
			System.out.println("");
			System.out.println("");
		}
	}
}
