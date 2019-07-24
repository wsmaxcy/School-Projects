
public class Policy 
{
	private String polNum;
	private String date;
	protected Owner own;
	protected double yearly;
	
	public Policy()
	{
		polNum = "no number available";
		date = "no date available";
		own = new Owner();
		yearly = 0;
	}
	
	public Policy(String p, String d, double yly, String na, String ad, String ci, String st, String bi)
	{
		polNum = p;
		date = d;
		own = new Owner(na, ad, ci, st, bi);
		yearly = yly;
	}

	public String getPolNum() 
	{
		return polNum;
	}
	
	public void setPolNum(String p)
	{
		polNum = p;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String d)
	{
		date = d;
	}
	
	public Owner getOwn()
	{
		return own;
	}
	
	public void setOwn(Owner o)
	{
		own = o;
	}
	
	public double getYearly() 
	{
		return yearly;
	}
	
	public void setYearly(double y)
	{
		yearly = y;
	}
	
	public void writeOutput()
	{
		own.writeOutput();
		System.out.println("Policy Number: "+polNum);
		System.out.println("Policy Date: "+date);
		System.out.println("Yearly Premium: "+yearly);
	}
	
	public double calculateMonthlyPremium()
	{
		return yearly/12;
	}
	
}
