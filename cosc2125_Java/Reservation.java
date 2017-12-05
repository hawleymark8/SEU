//Mark Hawley
//Reservation.java

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
	this.passengerList_ = null;
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
	    line += departureDateString() + confirmationNumber_ + passengerList_.getCount() + "\n" + passengerList_;
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
    	out.print(this.date_.toDateString() + " ");
    	out.print(this.confirmationNumber_ + " ");
    	out.println(this.passengerList_.size());
    	passengerList_.writeToFile();
    }

}//end of class