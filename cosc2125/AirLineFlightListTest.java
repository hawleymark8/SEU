//Mark Hawley
//AirLineFlightListTest.java

public class AirLineFlightListTest
{
    public static void main(String args[])
    {
	AirLineFlightList a2 = new AirLineFlightList();
	a2.readDataFromFile();
	System.out.println("Current List:\n" + a2);
	a2.sortByFlightNumber();
	System.out.println("Sorted by flight number\n" + a2);
	a2.sortByOrigin();
	System.out.println("Sorted by origin \n" + a2);
	a2.sortByCost();
	System.out.println("Sorted by cost \n" + a2);
    }
}//end of class