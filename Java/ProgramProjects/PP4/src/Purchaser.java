public class Purchaser 
{
	private String name;
	private String ccNum;
	
	public Purchaser()
	{
		name = "";
		ccNum = "";
	}
	public Purchaser(String nm, String cc)
	{
		name = nm;
		ccNum = cc;
	}

	public String getName() 
	{
		return name;
	}
	public void setName(String nm) 
	{
		name = nm;
	}

	public String getccNum() 
	{
		return ccNum;
	}

	public void setccNum(String cc) 
	{
		ccNum = cc;
	}
	public String toString() 
	{
		return "Purchaser [name= " + name + ", ccNum= "+ ccNum + "]";
	}
	
}
