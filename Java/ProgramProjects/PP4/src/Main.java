
public class Main 
{
	public static void main (String [] args)
	{
		Purchase purchase1 = new Purchase();
		Purchaser purchaser1 = new Purchaser("Billy", "55548789213564587");
		Order order = new Order(purchaser1, "12/24/2012", purchase1);
		order.addPurchase("IPod", 497.89);
		order.addPurchase("Pants", 49.78);
		order.addPurchase("Shoes", 163.89);
		order.addPurchase("Watch", 568.23);
		order.addPurchase("Laptop", 1208.74);
		order.addPurchase("Cell Phone Charger", 10.51);
		order.addPurchase("Keyboard", 48.28);
		order.total();
		order.reciept();
		
		
	}
}
