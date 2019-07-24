
public class Automobile extends Policy 
{
	private double vin;
	private String make;
	private String model;
	private String year;
	private int accidents;
	private double miles;
	
	public Automobile()
	{
		super();
		vin = 0;
		make = "no make available";
		model = "no model available";
		year = "no year available";
		accidents = 0;
		miles = 0;
	}
	
	public Automobile(String p, String d, double yly, String na, String ad, String ci, String st, String bi, double v, String ma, String mo, String y, int a, double mi)
	{
		super(p, d, yly, na, ad, ci, st, bi);
		vin = v;
		make = ma;
		model = mo;
		year = y;
		accidents = a;
		miles = mi;
	}
	
	public double getVin() 
	{
		return vin;
	}
	
	public void setVin(double v) 
	{
		vin = v;
	}
	
	public String getMake() 
	{
		return make;
	}
	
	public void setMake(String m) 
	{
		make = m;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public void setModel(String m) 
	{
		model = m;
	}
	
	public String getYear() 
	{
		return year;
	}
	
	public void setYear(String y) 
	{
		year = y;
	}
	
	public int getAccidents() 
	{
		return accidents;
	}
	
	public void setAccidents(int a)
	{
		accidents = a;
	}
	
	public double getMiles()
	{
		return miles;
	}
	
	public void setMiles(double m) 
	{
		miles = m;
	}
	public void writeOutput()
	{
		super.writeOutput();
		System.out.println("Policy Type: Automobile");
		System.out.println("VIN number: "+vin);
		System.out.println("Make: "+make);
		System.out.println("Model: "+model);
		System.out.println("Year: "+year);
		System.out.println("Number of Accidents: "+accidents);
		System.out.println("Miles: "+miles);
		System.out.print("No Accident Discount: ");
		if (accidents == 0)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.print("Low Miles Discount: ");
		if ((miles/365) < 15)
			System.out.println("Yes");
		else
			System.out.println("No");
			
		
	}
	
	public double calculateMonthlyPremium()
	{
		System.out.print("Monthly Premium: $");
		if (accidents == 0)
			yearly -= 200;
		if ((miles/365)< 15)
			yearly -= 100;
		 return yearly/12;
		 

		 
	}
}