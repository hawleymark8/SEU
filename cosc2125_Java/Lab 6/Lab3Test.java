//Lab3Test.java
//Mark Hawley

import java.util.*;
import java.io.*;

public class Lab3Test
{
    public static void main(String args[])
    {
	AirLineFlightList list = new AirLineFlightList();
	list.readDataFromFile();
	
	char option = '$';
	do
	    {
		displayMenuToUser();
		option = getUserSelection();
		switch(option)
		    {
		    case'a': menuAdd(list);
			break;
			
		    case'b': menuRemove(list);
			break;
			
		    case'c': menuSearch(list);
			break;
		    
		    case'd': menuEmpty(list);
			break;

		    case'e': menuFull(list);
			break;

		    case'f': menuSize(list);
			break;

		    case'g': menuRemoveAll(list);
			break;
			
		    case'h': System.out.println(list);
			break;
			
		    case'i': menuSearchByDestination(list);
			break;

		    case'j': menuModifyCost(list);
			break;

		    case'k': menuSaveFile(list);
			break;
			
		    case'l': menuAddReservation(list);
		    break;
		    
		    case'm': menuCancelReservation(list);
		    break;
		    
		    case'n': menuAddPassenger(list);
		    break;
		    
		    }//end of switch
	    }
	while(option != 'x');
	if(list.getSaved() == false)
    {
	Scanner input = new Scanner(System.in);
	System.out.println("Do you want to save the file? (y/n)");
    	String answer = input.nextLine();
	if (answer.equals("y") || answer.equals("Y"))
	    {
		menuSaveFile(list);
	    }
    }
	return;
    }//end of main

    //Pre:nothing
    //Post:nothing
    public static void displayMenuToUser()
    {
	System.out.println("Options: \n" +
			   "a: add flight \n" + "b: remove flight \n" + "c: search \n" + 
			   "d: test for empty \n" + "e: test for full \n" + 
			   "f: get size \n" + "g: remove all items \n" + 
			   "h: print list \n" + "i: search by flight destination \n" + 
			   "j: change flight cost \n" + "k: save file \n"  + 
			   "l: add reservation \n" + "m: cancel reservation \n" + "n: add passenger \n" +
			   "x: exit");
	return;
    }

    //Pre:nothing
    //Post: char
    public static char getUserSelection()
    {
	char choice;
	String answer;
	Scanner input = new Scanner (System.in);
	
	do
	    {
		System.out.print("Enter your selection: ");
		answer = input.nextLine();
		choice = Character.toLowerCase(answer.charAt(0));
	    }
	while ( choice != 'x' && choice != 'a' && choice != 'b' &&
		choice != 'c' && choice != 'd' && choice != 'e' &&
		choice != 'f' && choice != 'g' && choice != 'h' &&
		choice != 'i' && choice != 'j' && choice != 'k' &&
		choice != 'l' && choice != 'm' && choice != 'n');
	// 'a-n' are acceptable and x is quit
	return choice;
    }//end getUserSelection

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuAdd(AirLineFlightList myList)
    {
       	AirLineFlight flight = new AirLineFlight();
       	Scanner input = new Scanner (System.in);

       	System.out.println("Please enter the Airline Flight Number to create: ");
       	String flightNumber = input.nextLine();
       	flight.setFlightNumber(flightNumber);

       	System.out.println("Please enter the Airline Flight Origin: ");
       	String flightOrigin = input.nextLine();
       	flight.setOriginAirport(flightOrigin);

       	System.out.println("Please enter the Airline Flight Destination: ");
       	String flightDestination = input.nextLine();
       	flight.setDestAirport(flightDestination);

       	System.out.println("Please enter the Airline Flight Cost: ");
       	int flightCost = input.nextInt();
       	flight.setCost(flightCost);

	if(myList.add(flight))
	    {
		System.out.println("Flight Added: \n " + flight);
	    }
	else if(!(myList.add(flight)))
	    {
		System.out.println("Unable to add flight");
	    }
	return;
    }//end of menuAdd

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuRemove(AirLineFlightList myList)
    {
	AirLineFlight flight1 = new AirLineFlight();
	AirLineFlight flight2 = null;
	Scanner input = new Scanner (System.in);

	System.out.print("Please enter the Airline Flight Number of the flight " +
			   "to be removed: ");
	String flightNumber = input.nextLine();
	flight1.setFlightNumber(flightNumber);
        flight2 = (AirLineFlight) myList.remove(flight1);
	if(flight2 == null)
	    {
		System.out.println("could not remove flight " + flightNumber);
	    }
	else
	    {
		System.out.println("Flight Removed: \n" + flight2);
	    }
	return;
    }//end of menuRemove

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuSearch(AirLineFlightList myList)
    {
	AirLineFlight flight = new AirLineFlight();
	Scanner input = new Scanner (System.in);
	System.out.print("Airline Flight Number to search for: ");
        String flightNumber = input.nextLine();
	flight.setFlightNumber(flightNumber);
	if(myList.contains(flight))
	    {
		System.out.println("Flight Number: " + flight.getFlightNumber() + 
				   " is in the list");
	    }
	else
	    {
		System.out.println("Flight Number: " + flight.getFlightNumber() +
				   " is not in the list");
	    }
	return;
    }

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuEmpty(AirLineFlightList myList)
    {
	if(myList.isEmpty())
	    {
		System.out.println("The list is empty");
	    }
	else
	    {
		System.out.println("The list is not empty");
	    }
	return;
    }//end of menuEmpty

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuFull(AirLineFlightList myList)
    {
	if(myList.isFull())
	    {
		System.out.println("The list is full");
	    }
	else
	    {
		System.out.println("The list is not full");
	    }
    }//end of menuFull

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuSize(AirLineFlightList myList)
    {
	System.out.println("Size of List: " + myList.size());
    }//end of menuSize

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuRemoveAll(AirLineFlightList myList)
    {
	myList.removeAll();
	System.out.println("All flights removed from list");;
    }

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuSearchByDestination(AirLineFlightList myList)
    {
	Scanner input = new Scanner(System.in);
	System.out.println("Airline Flight Destination to search for: ");
	String dest = input.nextLine();
	myList.findFlightsByDestination(dest);
    }

    //Pre: AirLineFlightList
    //Post: nothing
    public static void menuModifyCost(AirLineFlightList myList)
    {
       	AirLineFlight flight = new AirLineFlight();
	Scanner input = new Scanner(System.in);
	System.out.println("Airline Flight Number of flight to be changed: ");
	String flightNumber = input.nextLine();
	flight.setFlightNumber(flightNumber);
	myList.modifyCost(flight);
    }			

    //Pre: AirLineFlightList
    //Post: nothing    
    public static void menuSaveFile(AirLineFlightList myList)
    {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter File Name: ");
	String filename = input.nextLine();
	File file = new File(filename);
	if(file.exists())
	    {
		System.out.println("File already exists. \n" + 
				   "Do you want to overwrite this file? (y/n)");
		String answer = input.nextLine();
		if(answer.equals("n") || answer.equals("n"))
		    {
			System.out.println("File Not Saved");
			return;  // nothing saved
		    }
	    }
	PrintWriter out = null;
	try
	    {
		out = new PrintWriter(file);
		myList.writeToFile(out);
	    }
	catch(FileNotFoundException e)
	    {
		System.out.println("Cannot open file for output: " +
				   filename);
		return;
	    }			
	return;
    }//end of menuOpenFile

	public static void menuAddReservation(AirLineFlightList list) 
	{
		AirLineFlight flight = new AirLineFlight();
		Scanner input = new Scanner (System.in);
		System.out.println("Enter Flight Number to Add Reservation to: ");
		String flightNumber = input.nextLine();
		flight.setFlightNumber(flightNumber);
		list.addReservation(flight);
		/**if(!worked)
		{
			System.out.println("addReservation did not work");
		} */
		return;
	}//end of menuAddReservation
	
	public static void menuCancelReservation(AirLineFlightList list)
	{
		AirLineFlight flight = new AirLineFlight();
		Scanner input = new Scanner (System.in);
		System.out.println("Enter Flight Number to Cancel Reservation From: ");
		String flightNumber = input.nextLine();
		flight.setFlightNumber(flightNumber);
		list.removeReservation(flight);
		return;		
	}

	private static void menuAddPassenger(AirLineFlightList list) 
	{
		AirLineFlight flight = new AirLineFlight();
		Scanner input = new Scanner (System.in);
		System.out.println("Enter Flight Number to add Passenger to: ");
		String flightNumber = input.nextLine();
		flight.setFlightNumber(flightNumber);
		list.addPassenger(flight);
		return;		
	}
	
}//end of class