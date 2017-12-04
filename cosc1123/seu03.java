//seu03.java, Mark Hawley, 11 February 2010
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
//

import java.util.Scanner;
public class seu03
{
    public static void main(String[]args)
    {

	//Variables

	double num1=0;
	double num2=0;
	double num=0;
	double sqroot=0;
	int dolls=0;
	int cents=0;
	int choice=0;
	String msg=" ";
	String sent=" ";
	Scanner cscan=new Scanner(System.in);
	Scanner cscantwo=new Scanner(System.in);
	Scanner cscanthree=new Scanner(System.in);
	Scanner cscanfour=new Scanner(System.in);

	try
	    {

	while (choice != 9)
	 {
	     choice=seu03Methods.seu03Menu(choice);

	//Choices


	switch(choice)
	    {
	  
		
		case 1:
		
		msg="Input Number One:";
		num1=myMethods.getDouble(msg);

		msg="Input Number Two:";
		num2=myMethods.getDouble(msg);
		
		if (num1 == -999999 || num2 == -999999)
		    {
			System.out.println("3 Tries per number without error exceeded. Try again.");
		    }
		else
		    {
			seu03Methods.calculator(num1, num2);
		    }

		break;
		
		
	    case 2:
		
		msg="Input Number for Square Root Module";
		num=myMethods.getDouble(msg);
		
		if(num == -999999)
		    {
			System.out.println("3 Tries without error exceeded.  Try again.");
		    }

		    if (num >= 0)
			{
			    seu03Methods.sqroot(num);
			}
		    if (num < 0 && num != -999999)
			{
			    System.out.println("Cannot Compute Square Root of Negative Number");
			}
		break;

	    case 3:
		
		msg="Input Dollars";
		dolls=myMethods.getInt(msg);
		msg="Input Cents";
		cents=myMethods.getInt(msg);

		if (dolls == -999999 || cents == -999999)
		    {
			System.out.println("3 Tries per number without error exceeded.  Try again.");
		    }
		else
		    {
			seu03Methods.coins(dolls, cents);
		    }

		break;

	    case 4: 

		msg="Please Enter Sentence to be Analyzed";
		try
		    {
			sent=myMethods.getString(msg);
			seu03Methods.sentenceAnalysis(sent);
		    }
		catch (Exception e)
		    {
			System.out.println(" Error: " + e);
		    }

		break;

	    case 5:
		
		System.out.println("Date and Time is:\n");
		System.out.println(testDate.getDateTime());
		

		break;

	    case 6:
		
		seu03Methods.bigMoney();

		break;
		
	    case 7:

	       	//System.out.println("Insert logic to get farmDriver");
		farmDriver.farmDriver();

       		break;
		
	    case 8:
		
		seu03Methods.genome();

		break;

	    case 9:

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
	 

	System.out.println("Thanks for using the 1323 Menu Program " + System.getProperty("user.name"));

	return;
    }

}