//Mark Hawley
//PassengerList.java

import java.io.*;
import java.util.Scanner;

public class PassengerList implements LinearList
{
    private int count_;
    private Node<Passenger> first_;
    public final static int MAX_ELEMENTS = 30000;  //list is full after this number is reached.

    public PassengerList()
    {
	this.first_ = null;
	this.count_ = 0;
    }
    
    public int getCount()
    {
    	return this.count_;
    }

    public String toString()
    {
	String temp = "";
	for(Node<Passenger>p = this.first_; p != null; p = p.link_)
	    {
		temp += p.data_ + "\n";
	    }
	return temp;
    }

  /** tests to see if the LinearList has reached MAX_ELEMENTS
 *@return true if the list contains MAX_ELEMENTS false otherwise
 */
  public boolean isFull()
    {
	return false;//letting it get as full as it wants
    }
 
/** tests to see if the LinearList has 0 elements
 *@ return true if the LinearList is empty (has 0 elements) false otherwise;
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
	if(!(element instanceof Passenger))
	    {
		return false;
	    }
	Passenger key = (Passenger)element;
	for(Node<Passenger>p = this.first_; p != null; p = p.link_)
	    {
		if(p.data_.equals(key))
		    {
			return true;
		    }
	    }
	return false;
    }//end of contains


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
	if(!(element instanceof Passenger))
	    {
		return false;
	    }
	Passenger pass = (Passenger)element;
	Node<Passenger> p = new Node<Passenger>(pass, null);
	p.link_ = first_;
	first_ = p;
	count_++;
        return true;
    }

/** removes item from list if its located
 * @param - element - the object to be removed (equals is implemented)
 * @return - the element that was removed , null if not found 
              and thus not removed.
 */
  public Object remove(Object element)
    {
	if(!(element instanceof Passenger))
	    {
		return null;
	    }
	Passenger passenger = (Passenger)element;
	Node<Passenger> prev = null;
	Node<Passenger> curr = this.first_;
	while (curr != null)
	    {
		if(curr.data_.equals(passenger))
		    {
			break;//get out of loop
		    }
		prev = curr;
		curr = curr.link_;
	    }//end of while
	if (curr == null) //|| curr.data_.equals(passenger))
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
	for(Node<Passenger>p = this.first_; p != null; p = p.link_)
	{
		p.data_.writeToFile(out);
	}
	return;
}

public void readFromFile(Scanner in) 
{
	int count = in.nextInt();
	in.nextLine();
	for(int i = 0; i < count; i++)
	{
		Passenger pass = new Passenger();
		pass.readFromFile(in);
		this.add(pass);
	}
	return;
}

}//end of class  