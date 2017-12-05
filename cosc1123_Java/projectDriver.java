import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class projectDriver
{
	public static void main (String[]args)
	{
		String input;
		int index;
		int code;
		double balance;
		String name;
		int companyCode;
		double companyBalance;
		String companyName;
		int numCompanies;
		project [] businesses = new project [9999];
		numCompanies = project.readInfo(businesses);
		
		input = JOptionPane.showInputDialog("What is the code of the company you want to update?");
		code = Integer.parseInt(input);
		index = project.getCompanyInfo(businesses, code, numCompanies);
		if (index != -1)
		{
			companyCode = businesses[index].getCode();
			companyBalance = businesses[index].getBalance();
			companyName = businesses[index].getName();
			input = JOptionPane.showInputDialog(companyCode+": Do you want to update the balance from " +companyBalance+"? Y or N");
			if (input.charAt(0) == 'Y' || input.charAt(0) == 'y')
			{
				input = JOptionPane.showInputDialog("What is the new balance?");
				balance = Double.parseDouble(input);
				businesses[index].setBalance(balance);
			}
			input = JOptionPane.showInputDialog(companyCode+": Do you want to change the "+companyName+"'s name? Y or N");
			if (input.charAt(0) == 'Y' || input.charAt(0) == 'y')
			{
				input = JOptionPane.showInputDialog("What is the new name?");
				name = input;
				businesses[index].setName(name);
			}
		}
		else
		{
			input = JOptionPane.showInputDialog("That code is not listed in the database. Would you like to add it Y or N?");
			if (input.charAt(0) == 'Y' || input.charAt(0) == 'y')
			{
				input = JOptionPane.showInputDialog("What is the new Company's name?");
				name = input;
				input = JOptionPane.showInputDialog("What is "+name+"'s balance?");
				balance = Double.parseDouble(input);
				project new1 = project.newCompany(code, balance, name);
				businesses[numCompanies] = new1;
				numCompanies = numCompanies +1;
			}
		}
		//int nCompanies= 0;
		//System.out.println("************************************************************************");
		//System.out.printf ("%-14s %-17s %-14s \n", "Company Code","Company Balance","Company Name");
		//for (int counter = 0; counter < numCompanies; counter++)
		  //  {
			//System.out.printf("%-14s %-16s %-3s \n", businesses[counter].getCode(),  
				//	  businesses[counter].getBalance(),
					//  businesses[counter].getName());
			//nCompanies++;
		    //}
		//System.out.println("\nTotal number of Companies: " +nCompanies);
		//System.out.println("************************************************************************");
		

	  }
	public static void projectMenu (project [] businesses)
	{
		String msg;
		char choice = ' ';
		System.out.println("Welcome to the program.");
		System.out.println("a) Show client list");
		System.out.println("b) Edit accounts");
		System.out.println("c) Delete an account");
		System.out.println("d) Add an account");
		System.out.println(" ");
		System.out.println("z) Save & Exit");
		msg = "Choice: ";
		try
		{
			while (choice != 'z' || choice != 'Z')
			{
				choice = myMethods.getChar(msg);
				switch (choice)
				{
				case 'a':
				case 'A':
					//call Show list
					break;
				case 'b':
				case 'B':
					//Edit accounts
					break;
				case 'c':
				case 'C':
					//Delete accounts
					break;
				case 'd':
				case 'D':
					//Add account
					break;
				case 'z':
				case 'Z':
					//Save N exit
					return;
					break;
					default:
						System.out.println("Invalid choice!@#");
				
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Error:" +e);
		}
		return;
			
	}
	
}
