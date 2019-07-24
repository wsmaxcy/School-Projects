//import Serializable in order to make sure that java can read the file that was exported and imported back in
import java.io.Serializable;
//name class and states that it implements Serializable in order to allow the import and export of files to and from binary.
public class Purchaser implements Serializable
{
	//class objects
	String name;
	String cardNum;
	//constructors
	public Purchaser(){
		name = null;
		cardNum = null;
	}
	
	public Purchaser(String N, String card){
		setName(N);
		setCardNum(card);
	}
	//accessor and mutator methods
	private void setCardNum(String card) {
		cardNum = card;
	}

	private void setName(String n) {
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCardNum(){
		return cardNum;
	}
	//toString method that outputs class information
	public String toString(){
		String s = "Purchasers Name: "+ name + "\nCard Number: " + cardNum+"\n";
		return s;
	}
}