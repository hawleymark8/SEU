//Mark Hawley
//AirLineFlightList.java

import java.util.*;
import java.io.*;

public class AirLineFlightList implements SortedList
{
    private AirLineFlight[] list_;
    private int count_;
    private boolean saved_ = false;
    public static final int MAX_ELEMENTS = 30;
    
    //list constructor

    public AirLineFlightList()
    {
	this.count_ = 0;
	this.list_ = new AirLineFlight[MAX_ELEMENTS];
    }
    
    //accessors
    public getSaved()
    {
    	return this.saved_;
    }

    //methods

    //Pre: nothing
    //Post: String
    public String toString()
    {
	String line = "";
	for(int i = 0; i < count_; i++)
	    {
		line += list_[i] + " \n ";
	    }
	return line;
    }

    //Pre: nothing
    //Post: nothing
    public void readDataFromFile()
    {
	String filename = "";
	Scanner infile = null;
	AirLineFlight flight = new AirLineFlight();
	Scanner input = new Scanner(System.in);
	System.out.println("Enter file to read flight data from: ");
	filename = input.nextLine();
	try
	    {
		infile = new Scanner(new File(filename));
	    }
	catch(FileNotFoundException e)
	    {
		System.out.println("error: cannot open file " + filename +
				   " list is unchanged");
		return;
	    }
	//file exists, it's open, okay to read
	int index = 0;
	while(flight.readFromScanner(infile) && index < this.MAX_ELEMENTS)
	    {
		boolean addSuccess = this.add(flight);
		if(!addSuccess)
		    {
			System.out.println("Duplicate flight found: " + flight);
			saved_ = false;
		    }
		else
		    {
			index++;
			flight = new AirLineFlight();
		    }
	    }//end of while
	this.count_ = index;
	infile.close();
    }

    //Sorting Methods

    public void sortByFlightNumber()
    {
	for(int i = 1; i < this.count_; i++)
	    {
		int k = i;
		while(k > 0)
		    {
			if (list_[k].compareTo(list_[k-1]) < 0)
			    {
				AirLineFlight temp = list_[k];
				list_[k] = list_[k-1];
				list_[k-1] = temp;
				k--;
			    }			    
			else
			    {
				k = 0;
			    }
		    }//end of while
	    }//end of for
    }//end of sortByFlightNumber

    public void sortByCost()
    {
	for(int i = 1; i < this.count_; i++)
	    {
		int k = i;
		while(k > 0)
		    {
			if (list_[k].compareByCost(list_[k-1]) < 0)
			    {
			        AirLineFlight temp = list_[k];
				list_[k] = list_[k-1];
				list_[k-1] = temp;
				k--;
			    }
		       	else if (list_[k].compareByOrigin(list_[k-1]) == 0)
			    {
				if (list_[k].compareTo(list_[k-1]) < 0)
				    {
					AirLineFlight temp = list_[k];
					list_[k] = list_[k-1];
					list_[k-1] = temp;
					k--;
				    }
			else
			    {
				k = 0;
			    }

			    }//end of else if
			else
			    {
				k = 0;
			    }
		    }//end of while
	    }//end of for
    }//end of sortByCost

        public void sortByOrigin()
    {
	for(int i = 1; i < this.count_; i++)
	    {
		int k = i;
		while(k > 0)
		    {
			if (list_[k].compareByOrigin(list_[k-1]) < 0)
			    {
			        AirLineFlight temp = list_[k];
				list_[k] = list_[k-1];
				list_[k-1] = temp;
				k--;
			    }
		       	else if (list_[k].compareTo(list_[k-1]) == 0)
			    {
				if (list_[k].compareTo(list_[k-1]) < 0)
				    {
					AirLineFlight temp = list_[k];
					list_[k] = list_[k-1];
					list_[k-1] = temp;
					k--;
				    }
			else
			    {
				k = 0;
			    }

			    }//end of else if
			else
			    {
				k = 0;
			    }
		    }//end of while
	    }//end of for
    }//end of sortByOrigin

    private int binSearch(AirLineFlight flight)
    {
	int low = 0;
	int high = count_ - 1;
	while(low <= high)
	    {
		int mid = (low + high)/2;
		    if (list_[mid].compareTo(flight) == 0)
			{
			    return mid;
			}
		    else if (list_[mid].compareTo(flight) < 0)
			{
			    low = mid + 1;
			}
		    else
			{
			    high = mid - 1;
			}
	    }//end of while
	return -1;
    }//end of binSearch

    //Sorted List Overrides--------------
    
/** tests to see if the list has reached MAX_ELEMENTS
 *@return true if the list contains MAX_ELEMENTS false otherwise
 */
    public boolean isFull()
    {
	return this.count_ >= MAX_ELEMENTS;
    }

/** tests to see if the List has 0 elements
 *@ return true if the list is empty (has 0 elements) false otherwise;
 */
    public boolean isEmpty()
    {
	return this.count_ == 0;
    }
/** returns number of elements currently in list
 *@return - number of elements in list (always <= MAX_ELEMENTS)
 */
  public int size()
    {
	return count_;
    }

/** searches the list for a key element
 * @param  element - the Object being searched for (Comparable must be implemented)
 * @return true if the element is present in list,
              false if it is not in the list
 */
  public boolean contains(Object object)
    {
	if(!(object instanceof AirLineFlight))
	    {
		return false;
	    }
	AirLineFlight flight = (AirLineFlight)object;
	int index = binSearch(flight);
	if (index == -1)
	    {
		return false;
	    }
	else
	    {
		return true;
	    }
    }

/** adds the element to the list if its NOT already in the list
   assuming Comparable interface for elements is implemented,
   maintains sorted order of list.
   * @param element - the item to be added to the list (Comparable)
   * @return - true if succesfully added, false if no room or duplicate.
   */
    public boolean add(Object object)
    {
	if(this.isFull())
	    {
		return false;
	    }
	if(!(object instanceof AirLineFlight))
	    {
		return false;
	    }
	AirLineFlight flight = (AirLineFlight)object;
	if(binSearch(flight) != -1)
	    {
	        return false;
	    }
	else
	    {
		list_[count_] = flight;
		count_ ++;
		sortByFlightNumber();
		return true;
	    }
    }

/** removes element from list if its located maintains sorted list order
 * @param - element - the object to be removed (comparable equals)
 * @return - the object that was found and removed, null if not found  and
             thus not removed.
 */
  public Object remove(Object object)
    {
	if (!(object instanceof AirLineFlight))
	    {
		return null;
	    }
	else
	    {
		AirLineFlight flight = (AirLineFlight)object;
		int result = binSearch(flight);
		if(result == -1)
		    {
			return null;
		    }
		else
		    {
			flight = list_[result];
			for(int i = result + 1; i < count_; i++)
			    {
				list_[i-1] = list_[i];
			    }		
			count_--;
			return flight;
		    }//end of else
	    }//end of else
		
    }


/** removes all elements in the list so that it becomes empty.
 */
    public void removeAll()
    {
	for(int i = 0; i < MAX_ELEMENTS; i++)
	    {
		list_[i] = null;
	    }
	this.count_ = 0;
	return;
    }

    //Pre: String dest
    //Post: nothing
    public void findFlightsByDestination(String dest)
    {
	boolean foundFlag = false;
	for(int i = 0; i < count_; i++)
	    {
		if (list_[i].getDestAirport().compareToIgnoreCase(dest) == 0)
		    {
			System.out.println(list_[i]);
			foundFlag = true;
		    }
	    }
	if(foundFlag == false)
	    {
		System.out.println("No matches were found that match destination: " + 
				   dest);
	    }
	return;
    }

    //Pre: AirLineFlight flight
    //Post: nothing
    public void modifyCost(AirLineFlight flight)
    {
	Scanner input = new Scanner(System.in);
       	if(binSearch(flight) == -1)
	    {
		System.out.println("Flight " + flight.getFlightNumber() + " not found");
	    }
	else
	    {
		System.out.println("Enter the new cost: ");
		int flightCost = input.nextInt();
		int i = binSearch(flight);
		list_[i].setCost(flightCost);
		System.out.println("Flight Cost Changed: \n" + list_[i]);
	    }
    }//end of modifyCost

    //Pre: PrintWriter out
    //Post: nothing
    public void writeToFile(PrintWriter out)
    {
	for(int i = 0; i < count_; i++)
	    {
		list_[i].writeToFile(out);
	    }
	this.saved_ = true;
	out.close();
    }//end of writeToFile
    
}//end of class