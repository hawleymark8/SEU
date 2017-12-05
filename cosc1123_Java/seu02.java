//***********************************
//seu02.java Author: Mark Hawley
//
//***********************************
import java.util.Scanner;
public class seu02
{
    public static void main(String[]args)
    {
	double num1=0;
	double num2=0;
	double sum=0;
	double prod=0;
	double diff=0;
	double quot=0;
	double sroot=0;
	Scanner cscan=new Scanner(System.in);
	System.out.println("***********************************************");
	System.out.println("Welcome to seu02.java, the calculator program");
	System.out.println("This program will prompt for and accept two numbers ");
	System.out.println("from a user, print appropriate messages, compute the sum, ");
	System.out.println("difference (second minus first), product and quotient ");
	System.out.println("(first divided by second), the square root of the second ");
	System.out.println("and display the results in a nice format.");
	
	System.out.println("Please enter the first number:");
	
	num1=cscan.nextDouble();
	
	System.out.println("Please enter the second number (not zero):");

	num2=cscan.nextDouble();

	System.out.println("You entered "+num1+" and "+num2);

	sum = num1 + num2;
	prod = num1 * num2;
	diff = num2 - num1;
	
	System.out.println("Results:");

	if (num2 == 0)
	    {
		System.out.println("Cannot Compute Quotient");
	    }
	else 
	    {
		quot = num1 / num2;
		System.out.println("Quotient is: " + quot);
	    }
	
	if (num2 >= 0)
	    {
		sroot = Math.sqrt(num2);
		System.out.println("Square Root of " + num2 + " is: " + sroot);
	    }
	else
	    {
		System.out.println("Cannot Compute Square Root");
	    }
       	if (sroot * sroot == num2)
	    {
		System.out.println("Square Root is exact");
	    }
	else
	    {
		System.out.println("Square Root is not exact");
	    }
	
	System.out.println("Sum is: " + sum);
	System.out.println("Product is: " + prod);
	System.out.println("Difference is: " + diff);
	System.out.println("Thank you for using the calculator");
	    
	System.out.println("**End of program seu02.java**");
	System.out.println("***********************************************");
    }
}
