
public class Property extends Policy
{
	private double sqrft;
	private String built;
	private boolean fire;
	private boolean alarm;
	
	public Property()
	{
		super();
		sqrft = 0;
		built = "no year available";
		fire = false;
		alarm = false;
	}
	
	public Property(String p, String d, double yly, String na, String ad, String ci, String st, String bi, double s, String b, boolean f, boolean ala)
	{
		super(p, d, yly, na, ad, ci, st, bi);
		sqrft = s;
		built = b;
		fire = f;
		alarm = ala;
	}
	
	public double getSqrft() 
	{
		return sqrft;
	}
	
	public void setSqrft(double s) 
	{
		sqrft = s;	
	}
	
	public String getBuilt() 
	{
		return built;
	}
	
	public void setBuilt(String b) 
	{
		built = b;
	}
	
	public boolean isFire()
	{
		return fire;
	}
	
	public void setFire(boolean f)
	{
		fire = f;
	}
	
	public boolean isAlarm() 
	{
		return alarm;
	}
	
	public void setAlarm(boolean a) 
	{
		alarm = a;
	}
	
	public void writeOutput()
	{
		super.writeOutput();
		System.out.println("Policy Type: Property");
		System.out.println("Square Footage: "+sqrft);
		System.out.println("Year built: "+built);
		System.out.print("Fire station proximity discount: ");
		if (fire == true)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.print("Security alarm discount: ");
		if (alarm == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public double calculateMonthlyPremium()
	{
		System.out.print("Monthly Premium: $");
		if (fire = true)
			yearly -= 100;
		if (alarm = true)
			yearly -= 200;
		return yearly/12;
	}
}