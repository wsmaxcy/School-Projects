
public class Driver 
{
	public static void main (String [] args)
	{
		Policy [] policy = new Policy[5];
		
		policy[0] = new Automobile();
		policy[1] = new Property();
		policy[2] = new Automobile("5123", "03/29/2013",1347, "Wilbur", "1600 Penn. Avenue", "Tupelo", "MS", "03/29/1989", 77488374, "Mercades", "TS9000", "1967", 1, 12000);
		policy[3] = new Property("2664", "04/23/2001", 1845, "Clempton", "123 ABC Street", "Neverland Ranch", "NV", "12/24/1978", 1850, "2006", true, true);
		policy[4] = new Property("3254", "07/17/2007", 2004, "Cujo", "1513 Winter Valley Drive", "Oxford", "MS", "05/09/1943", 2020, "1999", false, false);
		
		for (int i = 0; i < policy.length; i++)
		{
			policy[i].writeOutput();
			System.out.println(policy[i].calculateMonthlyPremium());
		}
		
		policy[2].setDate("12/24/2005");
		System.out.println(policy[2].getDate());
		policy[2].setPolNum("1235");
		System.out.println(policy[2].getPolNum());
		policy[2].setYearly(1235);
		System.out.println(policy[2].getYearly());
		Owner own = new Owner("Dooder","222 State Street","New Orleans","LA","05/23/1978");
		policy[2].setOwn(own);
		System.out.println(own.getName()+" "+ own.getAddress()+" "+ own.getCity()+" "+ own.getState()+" "+ own.getBirth());
		//policy[2].get;
	}
}