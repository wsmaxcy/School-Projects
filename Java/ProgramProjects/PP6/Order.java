//import Serializable in order to make sure that java can read the file that was exported and imported back in
import java.io.Serializable;
//set class name and states that it implements Serializable in order to allow the import and export of files to and from binary.
public class Order implements Serializable
{
	//class variables and objects
	String date;
	Purchaser id;
	Purchases []items;
	double total;
	int count;
	//constructors
	public Order(){
		date = null;
	}
	
	public Order(String d){
		setDate(d);
		id = new Purchaser();
		items = new Purchases[10];
		count = 0;
	}
	//accessor and mutator methods
	public void setDate(String d){
		date = d;
	}
	
	public void addPerson(String n, String card){
		id = new Purchaser(n, card);
	}
	
	public void addPurchase(String desc, double amt){
		items[count] = new Purchases(desc, amt);
		count++;
	}
	
	public void changePurchase(int index, String desc, double amt){
		items[index] = new Purchases(desc, amt);
	}
	
	public String getDate(){
		return date;
	}
	
	public Purchaser getID(){
		return id;
	}
	
	public void getPurchases(){
		for (int i = 0; i < count; i++){
			System.out.println(items[i]);
		}
	}
	//method that adds the total of all objects in the Purchases[] array
	public double getTotal(){
		total = 0.0;
		for (int i = 0; i < count; i++){
			total += items[i].getAmount();
		}
		return total;
	}
	//method that counts how many items are in the Purchases[] array
	public int getCount(){
		int itemcount = count;
		return itemcount--;
	}
}