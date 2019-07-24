/* 
  Name: Will Maxcy 
  Email: wsmaxcy@go.olemiss.edu
  Current Date: 4/15/13 
  Course Information: CSCI 112 - Section 02
  Instructor: Judy Etchison
  Program Description: Create a program that creates an ArrayList of Order objects that is filled with an array of Purchases objects and also a purchaser
  object. The ArrayList goes into the CompanyStory class that also uses exceptions to not crash the program. Also writes the ArrayList of Order objects 
  into a binary file and then reads this binary file back in and puts it inside an ArrayList. Finally, uses this ArrayList to print out through the 
  CompanyStore class to print out all the information given through the purchaser, purchases, and order classes.
  Sources Consulted: None.
  Honor Code Statement: In keeping with the honor code policies of the University of Mississippi, the School of Engineering,
   and the Department of Computer and Information Science, I affirm that I have neither given nor received assistance on this
   programming assignment. This assignment represents my individual, original effort. 
                   
*/
import java.io.*;

//main method, adding information to order objects, which addes info to purchase objects. 
public class Main{
	public static void main (String [] args) throws IOException{
		CompanyStore store = new CompanyStore("Wal-Mart");
		Order ord = new Order("12/24/2012");
		ord.addPurchase("iPod", 500);
		ord.addPurchase("Desk", 50);
		ord.addPurchase("Phone", 150);
		ord.addPerson("Will", "8904");
		Order ord1 = new Order("05/30/2013");
		ord1.addPurchase("Pants", 43.55);
		ord1.addPurchase("Socks", 12);
		ord1.addPurchase("Shoes", 83.23);
		ord1.addPurchase("Belt", 10.30);
		ord1.addPurchase("Underwear", 8.23);
		ord1.addPurchase("Hat",8.34);
		ord1.addPurchase("Shirt", 18.23);
		ord1.addPerson("Johnny", "3212");
		Order ord2 = new Order("09/17/2012");
		ord2.addPurchase("Keyboard", 32);
		ord2.addPurchase("Mouse", 12);
		ord2.addPurchase("Monitor", 128);
		ord2.addPurchase("Hard Drive", 98.23);
		ord2.addPurchase("CPU", 434.23);
		ord2.addPurchase("RAM", 60.23);
		ord2.addPurchase("GPU", 423.95);
		ord2.addPurchase("Case", 99.99);
		ord2.addPerson("Clempton", "0000");
		store.addOrder(ord);
		store.addOrder(ord1);
		store.addOrder(ord2);
		store.saveOrders("orders.dat");
		store.readOrders("orders.dat");
		//display orders method used to display all of the purchases and organize them by order. Also prints out the Total cost for the order.
		store.displayOrders();
	}
}
