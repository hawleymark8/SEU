//farm.java, Mark Hawley, 11 March 2010
//
//
//Revision History: 3/11/10:-Creation
//
//
//
//
//
//****************************************************

import java.util.*;
public class farm
{
    //attributes
    private String farmName;
    private int acres;
    private in numHorses;

    //methods------------Constructors---------------------
    //
    //
    //
    //
    
    //---------------Accessors/Getters------------------------
    
    //Pre:object
    //Post:return name (String)
    public String getFarmName()
    {
	return farmName;
    }

    //Pre:object
    //Post:return acres (int)
    public int getAcres()
    {
	return acres;
    }

    //Pre:object
    //Post:return numHorses (int)
    public int getNumHorses()
    {
	return numHorses;
    }

    //--------------Mutators/Setters---------------------------
    
    //Pre:object, String name
    //Post:nothing (sets name)
    public void setName(String newName)
    {
	name = newName;
	return;
    }

    //Pre:object, int acres
    //Post:nothing (sets acres)
    public void setAcres(int newAcres)
    {
	acres = newAcres;
	return;
    }

    //Pre:object, int numHorses
    //Post:nothing (sets numHorses)
    public void setNumHorses(int newNHorse)
    {
	numHorses = newNHorse;
	return;
    }

    //-------------To String---------------------------------

    //Pre:object farm
    //Post:String - a String report of object attributes to be printed
    public String toString()
    {
	String line=" ";
	line = " Name: " + name + " Acres: " + acres + " Horses: " + numHorses;

	return line;
    }


    //-------------Utilities----------------------------------
    
    //Pre:object farm
    //Post:nothing
    public static void farmMenu()
    {
	String msg=" ";
	char choice=' ';
	
	System.out.println("Welcome to the 1123 Farm: " + name + " " + acres + " acres " + numHorses + " Horses.");
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
				showHorses();
				break;

			    case 'b':
			    case 'B':

				//System.out.println("Calling addHorse");
				break;

			    case 'c':
			    case 'C':
				
				//System.out.println("Calling deleteHorse");
				break;
				
			    case 'f':
			    case 'F':
				
				//System.out.println("Calling addFarm");
				break;
				
			    case 'y':
			    case 'Y':
				
				//System.out.println("Exiting and calling bedHorses");
				break;

			    case 'z':
			    case 'Z':
				
				//System.out.println("Exit without saving changes");
				break;

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

    //Pre: object farm
    //Post: nothing
    public static void showHorses()
    {
	System.out.println("Insert logic for Show Horses");
    }

    //Pre: object farm
    //Post: nothing
    public static void addHorse()
    {
	System.out.println("Insert logic for addHorse");
    }

    //Pre: object farm
    //Post: nothing
    public static void deleteHorse()
    {
	System.out.println("Insert logic for deleteHorse");
    }

    //Pre: object farm
    //Post: nothing
    public static void bedHorses()
    {
	System.out.println("Insert logic for bedHorses");
    }

    //Pre: object farm
    //Post: nothing
    public static void getHorses()
    {
	System.out.println("Insert logic for getHorses");
    }

    //Pre: object farm
    //Post: nothing
    public static void addFarm()
    {
	System.out.println("Insert logic for addFarm");
    }

}//end of class