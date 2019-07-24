//import Serializable in order to make sure that java can read the file that was exported and imported back in
import java.io.Serializable;
//namce class and states that it implements Serializable in order to allow the import and export of files to and from binary.
public class Purchases implements Serializable
{
	//class objects
	String description;
	Double amount;
	//constructors
	public Purchases(){
		description = null;
		amount = 0.0;
	}
	
	public Purchases (String desc, double amt){
		setDescription(desc);
		setAmount(amt);
	}
	//mutator and accessor methods
	public void setAmount(double amt) {
		amount = amt;
	}

	public void setDescription(String desc) {
		description = desc;
	}
	
	public String getDescription(){
		return description;
	}
	
	public double getAmount(){
		return amount;
	}
	//toString method that outputs class variables
	public String toString(){
		String s = "Purchase description: " + description + " \nAmount: $" + amount +"\n----";
		return s;
	}
}