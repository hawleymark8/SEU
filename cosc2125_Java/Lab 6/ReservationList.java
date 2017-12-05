//Mark Hawley
//ReservationList.java

import java.io.*;
import java.util.Scanner;

public class ReservationList implements SortedList
{
    private int count_;
    private Node<Reservation>first_;
    public final static int MAX_ELEMENTS = 20;
    //list is full after this number is reached.
    
    public ReservationList()
    {
	this.first_ = null;
	this.count_ = 0;
    }

    public String toString()
    {
	String temp = "";
	for(Node<Reservation>p = this.first_; p != null; p = p.link_)
	    {
		temp += p.data_ + "\n";
	    }
	return temp;
    }

/** tests to see if the list has reached MAX_ELEMENTS
 *@return true if the list contains MAX_ELEMENTS false otherwise
 */
  public boolean isFull()
    {
	return false; //letting it get as full as it wants
    }
 
/** tests to see if the list has 0 elements
 *@ return true if the list is empty (has 0 elements) false otherwise;
 */
  public boolean isEmpty()
    {
	return this.first_ == null;
    }
/** returns number of elements currently in list
 *@return - number of elements in list (always <= MAX_ELEMENTS)
 */
  public int size()
    {
	return this.count_;
    }

/** searches the list for a key element
 * @param  element - the Object being searched for (equals must be implemented)
 * @return true if the element  is present, false if it is not in the list
 */
  public boolean contains (Object element)
    {
	if(!(element instanceof Reservation))
	    {
		return false;
	    }
	Reservation key = (Reservation)element;
	for(Node<Reservation>p = this.first_; p != null; p = p.link_)
	    {
		if(p.data_.compareTo(key) == 0)
		    {
			return true;
		    }
		if(p.data_.compareTo(key) > 0)
		    {
			return false;
		    }
	    }//end of for
	return false;
    }

/** adds item to list
 * not allow duplicate primary key (implements equals method) items in list
 *@param element - item to be added
 *@return - true if item is added, false if not added (either full list or duplicate)
 */
  public boolean add(Object element)
    {
	if(this.isFull())
	    {
		return false;
	    }
	if(this.contains(element))
	    {
		return false;
	    }
	if(!(element instanceof Reservation))
	    {
		return false;
	    }
	Node<Reservation> prev = null;
	Node<Reservation> curr = this.first_;
	Reservation res = (Reservation)element;
	while(curr != null)
	    {
		if(curr.data_.compareTo(res) > 0)
		    {//insert now
			curr = null;
		    }
		else
		    {//reset prev and curr
			prev = curr;
			curr = curr.link_;
		    }
	    }//end of while
	//now code to insert reservation
	Node<Reservation> p = new Node<Reservation>(res, null);
	if(prev == null) //decide at front?
	    {
		p.link_ = first_;
		first_=p;
	    }
	else
	    {
		p.link_ = prev.link_;
		prev.link_ = p;
	    }
	count_++;
	return true;
    }//end of add

/** removes item from list if its located
 * @param - element - the object to be removed (equals is implemented)
 * @return - the element that was removed , null if not found 
              and thus not removed.
 */
  public Object remove(Object element)
    {
	//String temp = null; //to hold data item removing
	if(!(element instanceof Reservation))
	    {
		return null;
	    }
	Reservation reservation = (Reservation)element;
	Node<Reservation> prev = null;
	Node<Reservation> curr = this.first_;
	while(curr != null)
	    {
		if (curr.data_.compareTo(reservation) == 0)
		    {
			break;//get out of loop
		    }//end of if	 
			prev = curr;
			curr = curr.link_;
	    }//end of while
	if(curr == null || curr.data_.compareTo(reservation) != 0)
	    {
		return null;//never found it
	    }
	//disconnect node
	if (prev == null)//at front?
	    {
		first_ = first_.link_;
	    }
	else //not at front
	    {
		prev.link_ = curr.link_;
	    }
	count_--;
	return curr.data_;
    }//end of remove

/** removes all elements in the LinearList so that it becomes empty.
 */
  public void removeAll()
    {
	this.first_ = null;
	this.count_ = 0;
    }

  public void writeToFile(PrintWriter out)
  {
	  for(Node<Reservation>p = this.first_; p != null; p = p.link_)
	  {
		  p.data_.writeToFile(out);
	  }
  }//end of writeToFile

public Reservation cancelReservation() 
	{
	System.out.println("Enter Confirmation Number of Reservation to be Cancelled: ");
	Scanner input = new Scanner(System.in);
	String confirmNumber = input.nextLine();
	Reservation res = new Reservation();
	Node<Reservation> temp = null;
	res.setConfirmationNumber(confirmNumber);
	temp = this.findRes(res);
	if (temp == null)
	{
			System.out.println("Invalid confirmation number: " + confirmNumber);
			return res;
	}
	Object element = remove(res);
	Reservation removedRes = (Reservation) element;
	System.out.println("Reservation cancelled: " + removedRes);
	return removedRes;
	}

public void readFromFile(Scanner in) 
	{
	Reservation res = new Reservation();
	while(res.readFromFile(in))
    {
	boolean addSuccess = this.add(res);
	res = new Reservation();
	
    }//end of while
	return;
	}

public boolean addPassenger() 
{
	System.out.println("Enter Confirmation Number of Reservation to Add Passenger to: ");
	Scanner input = new Scanner(System.in);
	String confirmNumber = input.nextLine();
	Reservation res = new Reservation();
	Node<Reservation> temp = null;
	res.setConfirmationNumber(confirmNumber);
	temp = this.findRes(res);
	if (temp == null)
	{
			System.out.println("Invalid confirmation number: " + confirmNumber);
			return false;
	}
	String fName = "";
	String lName = "";
	Passenger passenger;
	String answer;
	Scanner in = new Scanner(System.in);
	do
	{
		System.out.println("Enter First Name");
		fName = in.nextLine();
		System.out.println("Enter Last Name");
		lName = in.nextLine();
		passenger = new Passenger (fName, lName);
		temp.data_.addPassenger(passenger); //adding passenger to a reservation
		System.out.println("Add Another Passenger? (y/n)");
		answer = in.nextLine();
	} while (answer.equals("y") || answer.equals("Y"));
	return true;	
}

public Node<Reservation> findPrev(Reservation res)
{
	Node<Reservation> prev = null;
	Node<Reservation> curr = this.first_;
	while(curr != null)
	    {
		if(curr.data_.compareTo(res) > 0)
		    {//insert now
			curr = null;
		    }
		else
		    {//reset prev and curr
			prev = curr;
			curr = curr.link_;
		    }
	    }//end of while
	return prev;
}

public Node<Reservation> findRes(Reservation res)
{
	Node<Reservation> prev = null;
	Node<Reservation> curr = this.first_;
	while(curr != null)
	    {
		if(curr.data_.compareTo(res) == 0)
		    {//insert now
			return curr;
		    }
		else
		    {//reset prev and curr
			prev = curr;
			curr = curr.link_;
		    }
	    }//end of while
	return null;//never found
}
}//end of class