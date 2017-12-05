//Mark Hawley
//Passenger.java

public class Passenger
{
    private String firstName_;
    private String lastName_;

    //Constructors
    public Passenger()
    {
	this.firstName_ = "xxx";
	this.lastName_ = "xxx";
    }
    public Passenger(String firstName, String lastName)
    {
	this.firstName_ = firstName;
	this.lastName_ = lastName;
    }
    
    //Accessors
    public String getFirstName()
    {
	return this.firstName_;
    }
    public String getLastName()
    {
	return this.lastName_;
    }

    //Modifiers
    public void setFirstName(String firstName)
    {
	this.firstName_ = firstName;
    }
    public void setLastName(String lastName)
    {
	this.lastName_ = lastName;
    }

    //toString
    public String toString()
    {
	String line = lastName_ + "\n" + firstName_;
	return line;
    }

    //equals Override

    public boolean equals(Object object)
    {
	if (this == object)
	    {
		return true;
	    }
	else if (!(object instanceof Passenger))
	    {
		return false;
	    }
	else if (object == null)
	    {
		return false;
	    }
	else
	    {
		Passenger passenger = (Passenger) object;
		return (this.getLastName().equals(passenger.getLastName()) &&
			this.getFirstName().equals(passenger.getFirstName()));
	    }
    }//end of equals
}//end of class