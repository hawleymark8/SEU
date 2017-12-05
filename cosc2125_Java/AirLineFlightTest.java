//Mark Hawley Cosc 2125
//AirLineFlightTest.java

import java.util.*;
import java.io.*;

public class AirLineFlightTest
{
    public static void main(String args[])
    {
	AirLineFlight a1 = new AirLineFlight();
	System.out.println("Created AirLineFlight a1: \n" + a1);

	System.out.println("Now testing mutators");
	a1.setFlightNumber("aa123");
	a1.setOriginAirport("SAT");
	a1.setDestAirport("DFW");
	a1.setCost(300);
	System.out.println("Here is a1 using (aa123, SAT, DFW, 300) \n" + a1);

	System.out.println("Now testing accessors");
	System.out.println("Flight Number: " + a1.getFlightNumber() + "\n Origin " +
			   "Airport: " + a1.getOriginAirport() + "\n Dest. Airport: " +
			    a1.getDestAirport() + "\n Cost: " + a1.getCost());

	System.out.println("Now testing for invalid cost (-100)");
	a1.setCost(-100);
	System.out.println("Cost: " + a1.getCost());

	System.out.println("Now testing for invalid flight number length (as1234567)");
	a1.setFlightNumber("as1234567");
	System.out.println("Flight Number: " + a1.getFlightNumber());

	System.out.println("Now testing for invalid flight number (asd12)");
	a1.setFlightNumber("asd12");
	System.out.println("Flight Number: " + a1.getFlightNumber());
	
	System.out.println("Now testing for invalid flight number (12asd)");
	a1.setFlightNumber("12asd");
	System.out.println("Flight Number: " + a1.getFlightNumber());

    }
}//end of class