//Mark Hawley
//lab5Test.java

import java.util.*;
import java.io.*;

public class lab5Test
{
    public static void main(String args[])
    {
	System.out.println("Lab 5 Test: \n");
	//System.out.println("Creating lists");
	
	System.out.println("Creating Passenger Mark Hawley and adding to passenger list");
	Passenger pass = new Passenger();
	pass.setFirstName("Mark");
	pass.setLastName("Hawley");
	PassengerList plist = new PassengerList();
	boolean worked = plist.add(pass);
	System.out.println(plist);
   
	System.out.println("Creating Reservation with passenger list, " + 
			   "then adding passenger list to reservation list");
	Reservation res = new Reservation();
	res.setPassengerList(plist);
	ReservationList rlist = new ReservationList();
	System.out.println("Setting departure date 2/23/1990");
	res.setDepartureDate("1/1/2010");
	rlist.add(res);
	System.out.println(rlist);
	
	System.out.println("Adding another passenger Joe Vrana to Passenger List 1, " + 
			   "adding passenger list 2 with passengers Chris Beale and Christina Villareale " +
			   " and reservations to the reservation list");
	Passenger pass2 = new Passenger("Joe","Vrana");
	worked = plist.add(pass2);
	PassengerList plist2 = new PassengerList();
	Passenger pass3 = new Passenger("Chris", "Beale");
	Passenger pass4 = new Passenger("Christina", "Villareale");
	worked = plist2.add(pass3);
	worked = plist2.add(pass4);
	System.out.println("Modified passenger lists:");
	System.out.println(plist);
	System.out.println(plist2);
	
	Reservation res2 = new Reservation();
	res2.setPassengerList(plist2);
	rlist.add(res2);
	res2.setDepartureDate("12/31/2010");
	System.out.println("Modified Reservation Lists:");
	System.out.println(rlist);

	System.out.println("Removing Christina Villareale from passenger list 2 " +
			   "then removing Mark Hawley/JoeVrana reservation 1 from reservation list");
	System.out.println("Removed Passenger: " + plist2.remove(pass4));
    	System.out.println("Removed Reservation: " + rlist.remove(res));
	System.out.println("New Reservation list: ");
	System.out.println(rlist);
	
	System.out.println("Removing all on passenger list with Chris Beale, then printing reservation list");
	plist2.removeAll();
	System.out.println(rlist);
	System.out.println("Removing all on reservation list then printing empty lsit");
	rlist.removeAll();
	System.out.println(rlist);
    }
}//end of lab5Test