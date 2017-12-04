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
import java.io.*;
import java.util.*;
public class farm
{
    //attributes
    private String farmName;
    private int acres;
    private int numHorses;

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
	farmName = newName;
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
	line = " Name: " + farmName + " Acres: " + acres + " Horses: " + numHorses;

	return line;
    }


    //-------------Utilities----------------------------------
    


    //Pre: object farm
    //Post: nothing
    public static void showHorses(farm f1, horse [] h1)
    {
	
	
	//System.out.println("Insert logic for Show Horses");
	System.out.println("************************************");
	System.out.println(f1);
	System.out.println("Name\tBreed\tWeight\tGender");
        
	for(int index=0;index < f1.getNumHorses();index++)
	    {
		System.out.printf("%-14s %-14s %-14s %-14s\n", h1[index].getName(), h1[index].getBreed(), h1[index].getWeight(), h1[index].getGender());
	    }
	System.out.println("************************************");
    }

    //Pre: herd, farm
    //Post:
    public static void addHorse(horse[]H1, farm f1123)
    {
	//System.out.println("Insert logic for addHorse");
	
	try
	    {

		if (f1123.getNumHorses() < H1.length)
		    {
			String name3=" ";
			horse h5=horse.buildHorse();
			name3 = h5.getName();
			int pos=checkHerd(H1, name3, f1123);
			if (pos == -1)
			    {
				H1[f1123.getNumHorses()] = h5;
				f1123.setNumHorses(f1123.getNumHorses()+1);
				System.out.println("Horse created");
			    }
			else
			    {
			System.out.println("Already a horse in there named " + h5.getName());
			    }
		    }

		else
		    {
			System.out.println("Too many horses");
		    }
	    }

	catch (Exception e)
	    {
		System.out.println("Error: " + e);
	    }

	farmDriver.farmMenu(f1123, H1);

	return;
		
    } //end of addHorse

    //Pre: herd, farm
    //Post: nothing
    public static void deleteHorse(horse[]H1, farm f1123)
    {
	//System.out.println("Insert logic for deleteHorse");

	String msg;
	String horseName;
	msg = "Which horse would you like to terminate?";
        horseName = myMethods.getString(msg);
	int there = checkHerd(H1, horseName, f1123);
	if (there != -1)
	    {
		H1[there]=null;
		for(int index=there; index<f1123.getNumHorses(); index++)
		    {
			H1[index]=H1[index+1];
		    }
	       	System.out.println(horseName + " has been terminated");
		f1123.setNumHorses(f1123.getNumHorses()-1);
	    }
	else
	    {
		System.out.println("Horse does not exist");
	    }
	
	farmDriver.farmMenu(f1123, H1);

	return;
    } //end of deleteHorse

    //Pre: object farm
    //Post: boolean
    public static boolean bedHorses(horse[]H1, farm f1123)
    {
	//System.out.println("Insert logic for bedHorses");

	boolean successful;

	try
	    {
		String filename;
		String msg;
		msg = "Please enter the file name for the horses to be saved to";
		filename = myMethods.getString(msg);
		PrintWriter ofile1 = new PrintWriter(filename);
		ofile1.println(f1123.getFarmName());
		ofile1.println(f1123.getAcres());
		
		for (int index = 0; index<f1123.getNumHorses(); index++)
		    {
			ofile1.println(H1[index].getName() + " " + H1[index].getBreed() + " " + H1[index].getWeight() + " " + H1[index].getGender());
		    }

		ofile1.close();
		successful=true;
		System.out.println("Horses have been put to bed in " + filename);
	    }
	
	catch (Exception e)
	    {
		successful=false;
	    }

	return successful;

    } //end of bedHorses


    //Pre: 
    //Post: nothing
    public static void addFarm()
    {

	//System.out.println("Insert logic for addFarm");

	String msg;

	farm farmNew=new farm();
	horse[]herd=new horse[50];
	
	String fName;
	int fAcres;
	msg = "Please enter the name of the new farm";
	fName = myMethods.getString(msg);
	msg = "Please enter the number of acres";
	fAcres = myMethods.getInt(msg);

	farmNew.setName(fName);
	farmNew.setAcres(fAcres);
	farmNew.setNumHorses(0);

	System.out.println("Farm " + fName + " created");

	farmDriver.farmMenu(farmNew, herd);

	return;

    } // end of addFarm

    //Pre: horse[], String (index of horse)
    //Post: int- the index of the horse if found, -1 if not found
    public static int checkHerd(horse[]H1, String hname, farm f1)
    {
	int position=-1;
	int index=0;
	while(index<f1.getNumHorses() && position == -1)
	    {
		
		if(H1[index].getName().equals(hname))
		    {
			position=index;
		    }
		else
		    {
			index++;
		    }
	    }
	return position;
    }

}//end of class