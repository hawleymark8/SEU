//Mark Hawley
//Reservation.java

import java.io.PrintWriter;
import java.util.*;

public class Reservation implements Comparable<Reservation>
{
    private GregorianCalendar departureDate_;
    private String confirmationNumber_;
    private PassengerList passengerList_;
    private static String chars_ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static int randNumCount_ = 1;
    
    //Constructors

    public Reservation()
    {
	this.passengerList_ = new PassengerList();
	this.confirmationNumber_ = genRandomConfirmationNumber();
	this.departureDate_ = new GregorianCalendar(2000,0,1);
    }
    
    //Accessors
    public String getConfirmationNumber()
    {
	return this.confirmationNumber_;
    }
    public PassengerList getPassengerList()
    {
	return this.passengerList_;
    }
    public GregorianCalendar getDepartureDate()
    {
	return this.departureDate_;
    }

    //Modifiers
    public void setConfirmationNumber(String confirmationNumber)
    {
	this.confirmationNumber_ = confirmationNumber;
    }
    public void setPassengerList(PassengerList passengerList)
    {
	this.passengerList_ = passengerList;
    }
    public void setDepartureDate(GregorianCalendar date)
    {
	this.departureDate_ = date;
    }
    public void setDepartureDate(String date)
    {
	StringTokenizer str = new StringTokenizer(date,"/");
	try
	    {
		int month = Integer.parseInt(str.nextToken());
		month--;
		int day = Integer.parseInt(str.nextToken());
		int year = Integer.parseInt(str.nextToken());
		this.departureDate_ = new GregorianCalendar(year,month,day);
	    }
	catch (NumberFormatException e)
	    {
		System.out.println("NumberFormatException" + e);
	    }
    }

    //toString
    public String toString()
    {
	String line = ""; 
	    line += departureDateString() + " " + confirmationNumber_ + " " + passengerList_.getCount() + "\n" + passengerList_;
	return line;
    }
    
    //departureDateString()
    public String departureDateString()
    {
	String line = "";
	int year = departureDate_.get(Calendar.YEAR);
	int month = departureDate_.get(Calendar.MONTH);
	month++;
	int day = departureDate_.get(Calendar.DAY_OF_MONTH);
	line += month + "/" + day + "/" + year;
	return line;
    }

    //genRandomConfirmationNumber()
    public String genRandomConfirmationNumber()
    {
	String temp = "";
	int loc;
	Random rand = new Random();
	for(int i = 0; i < 6; i++)
	    {
		loc = rand.nextInt(35);
		temp += chars_.charAt(loc);
	    }
	//temp.charAt(5) = randNumCount_;
	randNumCount_++;
	return temp;
    }

     //Compare Methods

    //Pre: reservation object
    //Post: int
    public int compareTo(Reservation reservation)
    {
	return this.getConfirmationNumber().compareTo(reservation.getConfirmationNumber());
    }
    
    public void writeToFile(PrintWriter out)
    {
    	out.print(this.departureDateString() + " ");
    	out.print(this.confirmationNumber_ + " ");
    	out.print(this.passengerList_.size());
    	//String lineOut = writeToFileString();
    	//out.print(lineOut);
    	passengerList_.writeToFile(out);
    }
    public String writeToFileString()
    {
    	String line = this.departureDateString() + " " + this.confirmationNumber_ + " " +
    		this.passengerList_.size();
    	return line;
    }
    
    public void addPassenger(Passenger passenger)
    {
    	PassengerList list = this.passengerList_;
    	System.out.println("In Reservation.java about to add passenger to PassengerList");
    	boolean worked = list.add(passenger); //adds 1 passenger to the list
    	this.setPassengerList(list);
    	return;
    }

	public boolean readFromFile(Scanner in) 
	{
	 String date= in.next();
	 if(date.equals("****"))
	 {
		 return false;
	 }
		setDepartureDate(date);
		this.confirmationNumber_ = in.next();
		this.passengerList_.readFromFile(in);
		return true;
	}

}//end of class