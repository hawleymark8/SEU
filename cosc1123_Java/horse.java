//horse.java         Author: Mark Hawley
//Purpose: provides attributes and methods for horse objects
//Modification History: 3/2/10:-Created
//                      3/4/10:-Added Build Horse Method

import java.util.*;

public class horse
{
    //attributes
    private String name;
    private String breed;
    private int weight;
    private char gender;

    //methods --------- Constructors -------------------
    //Pre: nothing
    //Post: object (horse)
    public horse( )
    {
    }

    //Pre: String name, String breed, int weight, char gender
    //Post: object (horse)
    public horse(String theName, String theBreed, int theWeight, char theGender)
    {
	name = theName;
	breed = theBreed;
	weight = theWeight;
	gender = theGender;
    }
    
    //-------- accessors / getters ------------------------------------------

    //Pre:object
    //Post:return the name of horse (String)
    public String getName()
    {
	return name;
    }

    //Pre:object
    //Post:return the breed of the horse (String)
    public String getBreed()
    {
	return breed;
    }

    //Pre:object
    //Post:return the weight of the horse (int)
    public int getWeight()
    {
	return weight;
    }

    //Pre:object
    //Post: return the gender of the horse (char)
    public char getGender()
    {
	return gender;
    }

    //----------- mutators / setters ----------------------------------------------

    //Pre:object, String name
    //Post:nothing (sets name)
    public void setName(String newName)
    {
	name = newName;
	return;
    }


    //Pre:object, int weight
    //Post:nothing (sets weight)
    public void setWeight(int newWeight)
    {
	weight = newWeight;
	return;
    }


    //--------------------------------------------------------------------------------
    //Pre:object
    //Post: String - a String report of object attributes to be printed
    public String toString()
    {
	String line = " ";
	line = " name: " + name + "\n breed: " + breed + "\n weight: " + weight + "\n gender: " + gender + "\n";

	return line;
    }

    //--------------------------------------------------------------------------------
    //Build Horse Method
    //Pre:nothing
    //Post: nothing, creates horse
    public static horse buildHorse()
    {
	String msg = " ";
	String name1= " ";
	String breed1=" ";
	int weight1 = 0;
	char gender1 = ' ';
	Scanner cscan = new Scanner(System.in);

	msg=" Input Horse's Name: ";
	name1=myMethods.getString(msg);
	
	msg="\n Input Horse's Breed: ";
	breed1=myMethods.getString(msg);
	
	msg="\n Input Horses's Weight: ";
	weight1=myMethods.getInt(msg);
	
	while(gender1 != 'F' || gender1 != 'M')
	    {

		msg="\n Input Horse's Gender: ";
		gender1=myMethods.getChar(msg);

		if(gender1=='f' || gender1=='F')
		    {
			gender1='F';
			break;
		    }

		if(gender1=='m' || gender1=='M')
		    {
			gender1='M';
			break;
		    }
		else
		    {
			System.out.println("not a valid gender, try again");
		    }
	    }

	horse h1a=new horse(name1,breed1,weight1,gender1);

	return h1a;
    }


} //end of class