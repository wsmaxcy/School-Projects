
public class Owner 
{
	private String name;
	private String address;
	private String city;
	private String state;
	private String birth;
	
	public Owner()
	{
		name = "no name available";
		address = "no address available";
		city = "no city available";
		state = "no state available";
		birth = "no birth date available";
	}
	public Owner (String n, String a, String c, String s, String b)
	{
		name = n;
		address = a;
		city = c;
		state = s;
		birth = b;
	}
	public String getName() 
	{
		return name;
	}
	
	public void setName(String n) 
	{
		name = n;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String a) 
	{
		address = a;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String c)
	{
		city = c;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setState(String s)
	{
		state = s;
	}
	
	public String getBirth()
	{
		return birth;
	}
	
	public void setBirth(String b) 
	{
		birth = b;
	}
	public void writeOutput()
	{
		System.out.println("");
		System.out.println("");
		System.out.println("Policy Overview for "+ name);
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("Name: "+name);
		System.out.println("Address: "+address);
		System.out.println("City: "+city);
		System.out.println("State: "+state);
		System.out.println("Birth: "+birth);
	}

}

