//farmDriver.java, Mark Hawley, 11 February 2010
//Purpose: To provide a menu to the user to perform the tasks: calculator,
//         Square Root, Coin, Message, Exit
//
//Revision History:  1/23/10:-Created Menu
//                           -Variables
//                           -Choices (1,2,3,4,9)
//                           -Invalid Choice
//                    2/4/10:-Switch Statement
//                           -Methods (1,2,3,4)
//                           -Sent. Analysis
//                    2/11/10-Moved Methods to seu03Methods.java
//                           -Looped Menu
//                           -Added Case 5
//                     3/6/10-Added Case 6
//                    3/11/10-Added Case 7
//

import java.io.*;
import java.util.*;
public class farmDriver
{
    public static void farmDriver()
    {
	horse[]herd=new horse[999999999];
	farm farm1123=new farm();
	getFarm(farm1123, herd);
	System.out.println(farm1123);
	farmMenu(farm1123, herd);


	return;
    }

    //Pre:object farm
    //Post:nothing
    public static void farmMenu(farm f3, horse[] h3)
    {
	String msg=" ";
	char choice=' ';
	
	System.out.println("Welcome to the 1123 Farm: ");
	System.out.println("a. Show all Horses");
	System.out.println("b. Add a Horse");
	System.out.println("c. Delete a Horse\n");
	System.out.println("f. Add a new farm.");
	System.out.println("y. Exit with all changes to the herd.");
	System.out.println("z. Exit with no changes to the herd.");

	msg = "Choice: ";

	try
	    {
		
		while (choice != 'z' || choice != 'Z' || choice != 'y' || choice != 'Y')
		    {
			choice=myMethods.getChar(msg);

			//Choices

			switch(choice)
			    {

			    case 'a':
			    case 'A':
				
				//System.out.println("Calling showHorses");
				farm.showHorses(f3, h3);
				break;

			    case 'b':
			    case 'B':

				//System.out.println("Calling addHorse");
				farm.addHorse(h3, f3);
				break;

			    case 'c':
			    case 'C':
				
				//System.out.println("Calling deleteHorse");
				farm.deleteHorse(h3, f3);
				break;
				
			    case 'f':
			    case 'F':
				
				//System.out.println("Calling addFarm");
			        farm.addFarm();
				break;
				
			    case 'y':
			    case 'Y':
				
				//System.out.println("Exiting and calling bedHorses");
				boolean worked = farm.bedHorses(h3, f3);
				if (worked == false)
				    {
					System.out.println("Bed Horses Failed");
				    }
				return;

			    case 'z':
			    case 'Z':
				
				System.out.println("Exiting without saving changes");
			        return;

			    default:
				
				System.out.println("Invalid Choice, Try Again");
			    }
		    }


	       }

	catch (Exception e)
	    {
		System.out.println("Error: " + e);
	    }

	return;
    }

    //Pre: farm, horse
    //Post: nothing
    public static void getFarm(farm f1, horse[] h1)
    {
	String filename=" ";
	String msg=" ";
	msg="Enter file name (or new to create a farm): ";
	filename=myMethods.getString(msg);

	if (filename.equalsIgnoreCase("new"))
	    {
		farm.addFarm();
	    }

	try
	    {
		Scanner ifile1=new Scanner(new File(filename));
		System.out.println("Opened file " + filename);
	
		String fname=" ";
		int facres=0;
		int farm=0;
		int numHorses=0;
		String hname=" ";
		String hbreed=" ";
		int hweight=0;
		char hgender=' ';
		String sgender=" ";
	
		fname = ifile1.nextLine();
		facres = ifile1.nextInt();
		ifile1.nextLine();
		f1.setName(fname);
		f1.setAcres(facres);

		while(ifile1.hasNext())
		    {
			hname = ifile1.next();
			hbreed = ifile1.next();
			hweight = ifile1.nextInt();
			sgender = ifile1.nextLine();
			sgender = sgender.trim();
			hgender = sgender.charAt(0);

			horse h2 = new horse(hname, hbreed, hweight, hgender);
			h1[numHorses] = h2;
			numHorses++;

		    }

		f1.setNumHorses(numHorses);
		
	    }
	catch(InputMismatchException e4)
	    {
		System.out.println("Data in farm is not input correctly. Enter 'Z' to exit the farm to avoid permanently terminating all of the horses in the process. Edit data appropriately and then re-open");
		
	    }
	catch(FileNotFoundException e)
	    {
		System.out.println("File not found:" + e);
		
	    }
	catch(NoSuchElementException e2)
	    {
		System.out.println("Error: " + e2 + "\n This is a blank farm.  Please open a farm that already has data");
		
	    }
	catch(ArrayIndexOutOfBoundsException e3)
	    {
		System.out.println("Too many horses. Enter 'Z' to exit the farm to avoid permanently terminating all of the horses in the process. Load a farm that contains 50 horses or less");
		
	    }

	return;
    }

}