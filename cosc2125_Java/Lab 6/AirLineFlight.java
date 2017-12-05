//Mark Hawley Cosc2125
//AirLineFlight.java

import java.util.*;
import java.io.*;

public class AirLineFlight implements Comparable<AirLineFlight>
{
    private String flightNumber_;
    private String originAirport_;
    private String destAirport_;
    private ReservationList resList_;
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
	this.resList_ = new ReservationList();
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
    
    public ReservationList getList()
    {
    	return this.resList_;
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
    
    public void setReservationList(ReservationList resList)
    {
   		this.resList_ = resList;
    }

    //toString
    //Pre: object
    //Post: String

    public String toString()
    {
	String line = "Flight Number: " + flightNumber_ + " Origin Airport: " +
	    originAirport_ + " Destination Airport: " + destAirport_ + " Cost: $"
	    + cost_ + "\n " + "Reservation List: \n" + resList_;
	return line;
    }

    //Methods------------------------------------------------------------------

    //Pre: Scanner
    //Post: boolean
    public boolean readFromScanner(Scanner in)
    {
	/**String flightNum = "";
	String flightOrigin = "";
	String flightDest = "";
	int flightCost = 0;*/

	try
	    {
		this.flightNumber_ = in.next();
		this.originAirport_ = in.next();
		this.destAirport_ = in.next();
		this.cost_ = in.nextInt();
		in.nextLine();
		this.resList_.readFromFile(in);
		return true;
	    }
       	catch (InputMismatchException e2)
	    {
		System.out.println(e2);
		return false;
	    }
	catch (NoSuchElementException e1)
	    {
		return false;
	    }	
    }//end of readFromScanner

    //Pre: PrintWriter out
    //Post: nothing
    public void writeToFile(PrintWriter out)
    {
	out.print(this.getFlightNumber() + " " +
		    this.getOriginAirport() + " " +
		    this.getDestAirport() + " " +
		    this.getCost() + "\n" +
		    this.resList_ + "****");
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
    
    public void addReservation()
    {
    	Scanner in = new Scanner(System.in);
    	Reservation reservation = new Reservation();
    	String date;
    	String answer;
    	boolean worked = false;
    	System.out.println("Enter Departure Date (mm/dd/yyyy)");
    	date = in.nextLine();
    	reservation.setDepartureDate(date);
    	String fName = "";
    	String lName = "";
    	Passenger passenger;
    	do
    	{
    		System.out.println("Enter First Name");
    		fName = in.nextLine();
    		System.out.println("Enter Last Name");
    		lName = in.nextLine();
    		passenger = new Passenger (fName, lName);
    		reservation.addPassenger(passenger); //adding passenger to a reservation
    		System.out.println("Add Another Passenger? (y/n)");
    		answer = in.nextLine();
    	} while (answer.equals("y") || answer.equals("Y"));
    	//now we have a complete reservation object
    	//reservation created & populated
    	boolean result = this.resList_.add(reservation); //placing reservation into flight's reservation list
    	if(result)
    	{
    		System.out.println("Your Reservation " + reservation + " has been added");
    		System.out.println("Here is the Flight Information: " + this);
    	}
    	else
    	{
    		System.out.println("Unable to add reservation: " + reservation);
    	}
    	return;
    }//end of addReservation

	public void removeReservation() 
	{
		Reservation cancelled = this.resList_.cancelReservation();
		writeToLogFile(cancelled);
		return;
	}
    
    public void writeToLogFile(Reservation res)
    {
    	PrintWriter out = null;
    	try {
     		FileWriter infile = new FileWriter(new File("cancel.txt"),true);
    		out = new PrintWriter(infile);
    	}
    	catch (FileNotFoundException e)
    	{
    		System.out.println("unable to write to cancel.txt: " + res );
    		return;
    	} 
    	catch (IOException e) 
    	{
			System.out.println("Error: " + e);
		}
    	GregorianCalendar date = new GregorianCalendar();
    	String dateString = ""+(date.get(Calendar.MONTH ) + 1);
    	dateString += "/" + (date.get(Calendar.DAY_OF_MONTH));
    	dateString += "/" + (date.get(Calendar.YEAR));
    	out.println("Reservation: " + res + " Cancelled on " + dateString);
    	out.close();
    	return;
    }

	public void addPassenger() 
	{
		boolean worked = this.resList_.addPassenger();
		if(worked)
		{
			System.out.println(this);
		}
		else
		{
			System.out.println("Passenger addition unsuccessful");
		}
		return;
	}

}//end of class
