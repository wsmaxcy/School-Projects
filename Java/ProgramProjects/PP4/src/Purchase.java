public class Purchase 
{
	private String prodDesc;
	private double amount;

	public Purchase()
	{
		prodDesc = "";
		amount = 0;
	}
	public Purchase(String pd, double amnt)
	{
		prodDesc = pd;
		amount = amnt;
	}
	public String getProdDesc() 
	{
		return prodDesc;
	}
	public void setProdDesc(String pd) 
	{
		prodDesc = pd;
	}
	public double getAmount() 
	{
		return amount;
	}
	public void setAmount(double amnt) 
	{
		amount = amnt;
	}
	
	public String toString() 
	{
		return "Purchase [prodDesc=" + prodDesc + ", amount=" + amount + "]";
	}
	
}
