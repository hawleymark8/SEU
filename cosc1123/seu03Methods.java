//seu03Methods.java, Mark Hawley, 11 February 2010
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
//                    2/11/10:-Pasted Menu from seu03
//                    4/15/10:-Added genome.java        
//
import java.io.*;
import java.util.*;
public class seu03Methods
{
   
    //Menu Method
    //Pre:int choice
    //Post:int choice

    public static int seu03Menu(int choice)
    {
	//Variables


	Scanner cscan=new Scanner(System.in);


	//Welcome Menu
	
	System.out.println("******************************************");
	System.out.println("Welcome to the 1323 Menu System");
	System.out.println("Please choose an option");
	System.out.println("Option");
	System.out.println("1) Calculator Module");
	System.out.println("2) Find the Square Root of a number");
	System.out.println("3) Convert dollar cent amount to minimal coin amount");
	System.out.println("4) Sentence Analysis");
	System.out.println("5) Date and Time");
	System.out.println("6) Big Money");
	System.out.println("7) 1123 Farm");
	System.out.println("8) Genome\n");
	System.out.println("9) Exit\n");
	System.out.println("Choice:");

	choice=cscan.nextInt();

	return choice;
    }

	//Calculator Method
	//Pre: Double
	//Post: -----
	

	public static void calculator(double num1, double num2)
	{
	    //Variables

	    double sum=0;
	    double prod=0;
	    double diff=0;
	    double quot=0;

	    //Computations:

	    sum = num1 + num2;
	    prod = num1 * num2;
	    diff = num2 - num1;

	    if (num2 == 0)
		{
		    System.out.println("Cannot Compute Quotient (Cannot Divide by 0)");
		}
	    else
		{
		    quot = num1 / num2;
		    System.out.println("Quotient is: " + quot);
		}

	    //Display Messages

	    System.out.println("Sum is: " + sum);
	    System.out.println("Product is: " + prod);
	    System.out.println("Difference is: " + diff);

	    return;
	}

	//Square Root Method
	//Pre: Double
	//Post: -----

	public static void sqroot(double num)
	{
	    
	    //Variables

	    double sroot=0;

	    //Computation:

	    sroot=Math.sqrt(num);

	    //Display Messages:
	    
	    System.out.println("Square Root is " + sroot);

	    if (sroot * sroot == num)
		{
		    System.out.println("Square Root is Exact");
		}
	    else
		{
		    System.out.println("Square Root is not exact because there is limited memory to store the irrational square root result");
		}
	    return;
	}

	//Coins Method
	//Pre: Int
	//Post: -----

	public static void coins(int dolls, int cents)
	{
	    
	    //Variables

	    int pennies=0;
	    int nickels=0;
	    int dimes=0;
	    int quarters=0;
	    int total=0;

	    //Computation

	    total = 100 * dolls + cents;
	    
	    quarters = total / 25;

	    total = total % 25;
	    dimes = total / 10;
	    
	    total = total % 10;
	    nickels = total / 5;

	    total = total % 5;
	    pennies = total / 1;

	    //Display Messages

	    System.out.println("You entered " + dolls + " dollars and " + cents + " cents.");
	    System.out.println("The minimal number of coins is:");
	    System.out.println(quarters + " quarter(s)");
	    System.out.println(dimes + " dime(s)");
	    System.out.println(nickels + " nickel(s)");
	    System.out.println(pennies + " pennie(s)");
	    
	    return;
	}

	//Sentence Analysis 
	//Pre: String
	//Post: ----
	
	public static void sentenceAnalysis(String sent)
	{
	    
	    //Variables

	    int length=0;

	    //Computations

	    length = sent.length();

	    //Display Messages:

	    System.out.println("Sentence Length is: " + length);
	    System.out.println("First Letter is: " + sent.charAt(0));
	    System.out.println("Last Letter is: " + sent.charAt(length - 1));

	    System.out.print("Middle Character is: ");

	    if (length % 2 == 1)
		{
		    System.out.println(sent.charAt(length/2));
		}
	    else
		{
		    System.out.println(sent.charAt((length-1)/2));
		}
	    return;
	}

    //Big Money
    //Pre: ----
    //Post: ----
    
    public static void bigMoney()
    {
	
	//Variables

	String msg=" ";
	int num=0;
	int guess=0;
	int guesstry=0;

	Random rand = new Random();

	//Computations

	num=rand.nextInt(99) + 1;

	//Program Movie
	//System.out.println("Random Number is: " + num);
	
	System.out.println("Welcome to Big Money!");
	System.out.println("You get 5 tries to guess a random number between 0 and 100 exclusive. (i.e. 1-99)");
	System.out.println("If you guess in 1 try, $100, 2 tries, $50, 3 tries, $20, 4 tries, $10, and 5 tries $1.");
	System.out.println("Otherwise, no money.");

	while (guesstry < 5)
	    {    
		msg="Make a guess: ";
		guess=myMethods.getInt(msg);
	
		if (guess < num)
		    {
			System.out.println("Too Low");
			guesstry++;
		    }
		if (guess > num)
		    {
			System.out.println("Too High");
			guesstry++;
		    }
		if (guess == num)
		    {
			System.out.println("You guessed the correct number!");
			break;
		    }
	    }
	if (guesstry == 0)
	    {
		System.out.println("You win $100!");
	    }
	if (guesstry == 1)
	    {
		System.out.println("You win $50!");
	    }
	if (guesstry == 2)
	    {
		System.out.println("You win $20!");
	    }
	if (guesstry == 3)
	    {
		System.out.println("You win $10!");
	    }
	if (guesstry == 4)
	    {
		System.out.println("You win $1");
	    }
	if (guesstry == 5)
	    {
		System.out.println("Sorry, too many guesses.  No money");
	    }

	return;

    }//end of bigMoney

    //Genome
    //Pre:-----
    //Post:-----
    
    public static void genome()
    {
	String filename=" ";
	String msg=" ";
	String dna2= "  ";
       	double aCount = 0;
       	double cCount = 0;
       	double gCount = 0;
       	double tCount = 0;
       	double totalCount = 0;
	double aPercent = 0;
	double cPercent = 0;
	double gPercent = 0;
	double tPercent = 0;

     	Random rand = new Random();

	int num1 = 0;
	num1 = rand.nextInt(4);
	int num2 = 0;
	num2 = rand.nextInt(4);
	String[] lets={"a","c","g","t"};
	String S1=lets[num1] + lets[num2];
	int dinucCount = 0;
	int position = 0;
	int oneDinuc = 0;

	msg="Enter file name to open genome sequence: ";
	filename=myMethods.getString(msg);

	try
	    {

		Scanner ifile1=new Scanner(new File(filename));
		System.out.println("Opened file " + filename);
		
		while(ifile1.hasNext())
		    {
			//System.out.println("I'm at the while loop");
			String genomes = ifile1.nextLine();
			int genomeLength = genomes.length();

			for(int index = 0; index < genomeLength; index++)
			    {

				//Part 1 loop

				char dna = genomes.charAt(index);

				if(dna == 'a' || dna == 'A')
				    {
					aCount++;
					totalCount++;
				    }
				if(dna == 'c' || dna == 'C')
				    {
					cCount++;
					totalCount++;
				    }
				if(dna == 't' || dna == 'T')
				    {
					tCount++;
					totalCount++;
				    }
				if(dna == 'g' || dna == 'G')
				    {
					gCount++;
					totalCount++;
				    }

			    }//end of for loop

			//Percentage Calculations

		       	aPercent = (aCount / totalCount) * 100;
		       	cPercent = (cCount / totalCount) * 100;
		       	tPercent = (tCount / totalCount) * 100;
			gPercent = (gCount / totalCount) * 100;
			
			oneDinuc = genomes.indexOf(S1, 0);

			if (oneDinuc != -1)
			    {
				dinucCount++;
			    }

			position = genomes.indexOf(S1, 0);
	     		while(position != -1)
			    {
				position = genomes.indexOf(S1, position + 1);
				dinucCount++;
			    }

		    }//end of while loop

		//Report
		System.out.println("*********************************");
		System.out.println("Report from genome.java for file " + filename);
		System.out.println("Length of genome: " + totalCount + "\n");
		System.out.printf("%-10s %-10s %-10s\n", "a:", aCount, aPercent + "%");
		System.out.printf("%-10s %-10s %-10s\n", "c:", cCount, cPercent + "%");
		System.out.printf("%-10s %-10s %-10s\n", "g:", gCount, gPercent + "%");
		System.out.printf("%-10s %-10s %-10s\n", "t:", tCount, tPercent + "%\n");
		System.out.println("Random dinucleotide Report:");
	        System.out.printf("%-10s %-10s\n", S1 + ":", dinucCount);
		System.out.println("Location of the first dinucleotide is at character " + oneDinuc);
		System.out.println("*** End of Report ***");	

		aCount = 0;
		cCount = 0;
		gCount = 0;
		tCount = 0;
		totalCount = 0;
		aPercent = 0;
		cPercent = 0;
		gPercent = 0;
		tPercent = 0;
	        position = 0;
		oneDinuc = 0;
		
	    }//end of try block
	
	catch(FileNotFoundException e)
	    {
		System.out.println("File not found:" + e);
		return;
	    }

	catch(Exception e)
	    {
		System.out.println("Error: " + e);
		return;
	    }

	return;
	
    }//end of genome

}