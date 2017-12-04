//myMethods.java, Mark Hawley, 18 February 2010
//Purpose: contains methods for getInt, getDouble, getString, getChar, and others
//
//Revision History: 2/18/10:-Created methods
//                          -getInt, getDouble, getString, getChar
//
//

import java.util.Scanner;
public class myMethods
{

    //getInt Method-------------------------------------------------------------------------------
    //Pre: String msg
    //Post: int

    public static int getInt(String msg)
    {
	int tries=1;
	int i1=0;
	boolean b1=true;
	Scanner cscan = new Scanner(System.in);

	//Program Movie
	//System.out.println("here i am");


	while ((tries <= 3) && (b1 == true))
	    {
		
		try
		    {
			System.out.println(msg);
		       	i1=cscan.nextInt();
			cscan.nextLine();
			b1=false;
		    }
		catch (Exception awwShift)
		    {
			System.out.println("A non int was entered: " + awwShift);
			cscan.nextLine();
			i1=-999999;
		    }
		tries++;
	    }

	return i1;
    }

    //getDouble Method---------------------------------------------------------------------------
    //Pre: String msg
    //Post: double

    public static double getDouble(String msg)
    {
	
	int tries=1;
	double d1=0;
	boolean b2=true;
	Scanner cscan = new Scanner(System.in);

	//Program Movie
	//System.out.println("here i am");

	while ((tries <= 3) && (b2 == true))
	    {
		try
		    {
			System.out.println(msg);
			d1=cscan.nextDouble();
			cscan.nextLine();
			b2=false;
		    }
		catch (Exception muckMe)
		    {
			System.out.println("A non double was entered: " + muckMe);
			cscan.nextLine();
			d1=-999999;
		    }
		tries++;
	    }

	return d1;
    }

    //getString Method-----------------------------------------------------------------------
    //Pre: String msg
    //Post: String

    public static String getString(String msg)
    {
	String s1=" ";
	Scanner cscan = new Scanner(System.in);

	//Program Movie
	//System.out.println("here i am");

	System.out.println(msg);
	s1=cscan.nextLine();
	s1=s1.trim();

	return s1;
    }

    //getChar Method--------------------------------------------------------------------------
    //Pre: String msg
    //Post: char

    public static char getChar(String msg)
    {
	String s2=" ";
	char letter=' ';
	Scanner cscan = new Scanner(System.in);

	//Program Movie
	//System.out.println ("here i am");

	try
	    {
	System.out.println(msg);
	s2=cscan.nextLine();
       	letter=s2.trim().charAt(0);
	    }
	catch (Exception ohSnap)
	    {
		System.out.println("Error: " + ohSnap);
	    }
	return letter;
    }

    //Ladder Method--------------------------------------------------------------------------
    //Pre: String
    //Post: nothing

    public static void ladder(String sentence)
    {
	//Program Movie
	System.out.println("Here I am in ladder and received sentence: " + sentence);
    }

    //Vowels Method---------------------------------------------------------------------------
    //Pre: String
    //Post: Int
    
    public static int vowels(String S1)
    {
	int letters=0;
	int vowels=0;
	char indx=' ';
	
	letters=S1.length();
	
	while(letters >= 0)
	    {
		indx=S1.charAt(letters);
		if (indx=='a' || indx=='A' || indx=='e' || indx=='E' || indx=='i' || indx=='I' || indx=='o' || indx=='O' || indx=='u' || indx=='U')
		    {
			vowels++;
		    }
		letters--;
	    }

	return vowels;
    }

    //Palindrome Method----------------------------------------------------------------------
    //Pre: String
    //Post: boolean
    
    public static boolean pali(String S1)
    {
	int indx1=0;
	int indx2=0;
	boolean palindrome=false;
	
	indx2=S1.length();

	while (indx2 >= indx1)
	    {
		if (S1.charAt(indx2)==S1.charAt(indx1))
		    {
			indx2--;
			indx1++;
			palindrome=true;
		    }
		else
		    {
			palindrome=false;
		    }
	    }
	
	return palindrome;
    }

}