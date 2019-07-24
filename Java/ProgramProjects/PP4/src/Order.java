
public class Order 
{
	private Purchaser purchaser;
	private String date;
	private Purchase [] purchases;
	private double total;
	private int count;

	public Order()
	{
		date = "";
		purchaser = null;
		purchases = new Purchase[7];
		count = 0;
		
	}
	public Order(Purchaser p, String d, Purchase pse)
	{
		date = d;
		purchaser = p;
		purchases = new Purchase[7];
		count = 0;
	}
	public Purchaser getPurchaser() 
	{
		return purchaser;
	}
	public void setPurchaser(Purchaser p) 
	{
		purchaser = p;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String d) 
	{
		date = d;
	}
	public Purchase[] getPurchases() 
	{
		return purchases;
	}
	public void setPurchases(Purchase[] p) 
	{
		purchases = p;
	}
	public void setCount(int c)
	{
		count = c;
	}
	public int getCount()
	{
		return count;
	}
	public double total()
	{
		for(int i = 0; i < purchases.length; i++)
		{
			total = purchases[i].getAmount() + total;
		}
		return total;
	}
	
	public void reciept() 
	{
		System.out.println("--------------Order Information--------------");
		System.out.println("Name: "+ purchaser.getName());
		System.out.println("Credit Card Number: " + purchaser.getccNum());
		System.out.println("Date: "+ date);
		System.out.println("----------------------------------------------");
		System.out.println("------------------Purchases-------------------");
		for (int i = 0; i < purchases.length; i++)
		{
			System.out.println("Purchase " + (i+1) +" - "+ purchases[i].getProdDesc());
			System.out.println("Price: $"+purchases[i].getAmount());
			System.out.println("");
		}
		System.out.println("Grand Total: $"+ total);
	}
	public void addPurchase(String desc, double amnt)
	{
		purchases[count]= new Purchase(desc, amnt);
		++count;
	}

}
