//Mark Hawley Cosc2125
//AirLineFlight.java

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class AirLineFlight implements Comparable<AirLineFlight>
{
    private String flightNumber_;
    private String originAirport_;
    private String destAirport_;
    private int cost_;

    //Constructor

    //Pre: nothing
    //post: object
    public AirLineFlight()
    {
	this.setFlightNumber("aa0000");
	this.setOriginAirport("xxx");
	this.setDestAirport("xxx");
	this.setCost(0);
    }
    
    //Accessors

    //Pre: object
    //Post: returns FlightNumber
    public String getFlightNumber()
    {
	return this.flightNumber_;
    }

    //Pre: object
    //Post: returns originAirport
    public String getOriginAirport()
    {
	return this.originAirport_;
    }

    //Pre:object
    //Post: returns DestAirport
    public String getDestAirport()
    {
	return this.destAirport_;
    }
    
    //Pre: object
    //Post: returns Cost
    public int getCost()
    {
	return this.cost_;
    }

    //Modifiers

    //Pre: object
    //Post: sets Flight Number
    public void setFlightNumber(String flightNumber)
    {
	if(flightNumber.length() <= 7  && Character.isLetter(flightNumber.charAt(0))
	   && Character.isLetter(flightNumber.charAt(1)) && Character.isDigit(flightNumber.charAt(2))
	   && Character.isDigit(flightNumber.charAt(3)))
	    {
		this.flightNumber_ = flightNumber;

		if(flightNumber.length() >= 5 && Character.isDigit(flightNumber.charAt(4)))
		    {
			this.flightNumber_ = flightNumber;

			if(flightNumber.length() >= 6 && Character.isDigit(flightNumber.charAt(5)))
			    {			
				this.flightNumber_ = flightNumber;
			    }
		    }
	    }
        else
	    {
		this.flightNumber_ = "0000";
		System.out.println("Invalid Flight Number");
	    }
    }
    
    //Pre: object
    //Post: sets Origin Airport
    public void setOriginAirport(String originAirport)
    {
	this.originAirport_ = originAirport;
    }

    //Pre:object
    //Post: sets Destination Airport
    public void setDestAirport(String destAirport)
    {
	this.destAirport_ = destAirport;
    }

    //Pre: object
    //Post: sets Cost
    public void setCost(int cost)
    {
	if(cost >= 0)
	    {
		this.cost_ = cost;
	    }
	else
	    {
		System.out.println("invalid cost");
		this.cost_ = 0;
	    }
    }

    //toString
    //Pre: object
    //Post: String

    public String toString()
    {
	String line = "Flight Number: " + flightNumber_ + " Origin Airport: " +
	    originAirport_ + " Destination Airport: " + destAirport_ + " Cost: $"
	    + cost_;
	return line;
    }

    //Methods--------------------

    //Pre: Scanner
    //Post: boolean
    public boolean readFromScanner(Scanner in)
    {
	String flightNum = "";
	String flightOrigin = "";
	String flightDest = "";
	int flightCost = 0;

	try
	    {
		flightNum = in.next();
		flightOrigin = in.next();
		flightDest = in.next();
		flightCost = in.nextInt();
		in.nextLine();
	 	this.setFlightNumber(flightNum);
		this.setOriginAirport(flightOrigin);
		this.setDestAirport(flightDest);
		this.setCost(flightCost);
		return true;
	    }
       	catch (InputMismatchException e2)
	    {
		System.out.println(e2);
		return false;
	    }
	catch (NoSuchElementException e1)
	    {
		System.out.println(e1);
		return false;
	    }	
    }//end of readFromScanner

    //Pre: PrintWriter out
    //Post: nothing
    public void writeToFile(PrintWriter out)
    {
	out.println(this.getFlightNumber() + " " +
		    this.getOriginAirport() + " " +
		    this.getDestAirport() + " " +
		    this.getCost());
	return;
    }//end of writeToFile

    //Compare Methods

    //Pre: flight object
    //Post: int
    public int compareTo(AirLineFlight flight)
    {
	return this.getFlightNumber().compareTo(flight.getFlightNumber());
    }

    //Pre: flight object
    //Post: int
    public int compareByCost(AirLineFlight flight)
    {
       	if(this.getCost() > flight.getCost())
	    {
		return 1;
	    }
       	if(this.getCost() < flight.getCost())
	    {
		return -1;
	    }
	return 0;
    }

    //Pre: flight object
    //Post: int
    public int compareByDestination(AirLineFlight flight)
    {
	return this.getDestAirport().compareTo(flight.getDestAirport());
    }

    //Pre: flight object
    //Post: int
    public int compareByOrigin(AirLineFlight flight)
    {
	return this.getOriginAirport().compareTo(flight.getOriginAirport());
    }

    //equals Override

    public boolean equals(Object object)
    {
	if (this == object)
	    {
		return true;
	    }
	else if (!(object instanceof AirLineFlight))
	    {
		return false;
	    }
	else if (object == null)
	    {
		return false;
	    }
	else
	    {
		AirLineFlight flight = (AirLineFlight) object;
		return (this.getFlightNumber().equals(flight.getFlightNumber()) &&
			this.getOriginAirport().equals(flight.getOriginAirport()) &&
			this.getDestAirport().equals(flight.getDestAirport()) &&
			this.getCost() == flight.getCost());
	    }
    }//end of equals

    //hashCode Override

    public int hashCode()
    {
	int hash = 31;
	hash = 37 * hash + this.getCost();
	hash = hash * 31 + (this.getFlightNumber().hashCode());
	hash = hash * 31 + (this.getDestAirport().hashCode());
	hash = hash * 31 + (this.getOriginAirport().hashCode());
	return hash;
    }

}//end of class
