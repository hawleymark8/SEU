import java.io.File;
import java.util.Scanner;


public class project
{
	private int code;
	private double balance;
	private String name;

		public project (int newCode, double newBalance, String newName)
		{	
			code = newCode;
			balance = newBalance;
			name = newName;

		}
		public void setName (String newName)
		{
			name = newName;
		}	
		public void setCode (int newCode)
		{
			code = newCode;
		}
		public void setBalance (double newBalance)
		{
			balance = newBalance;
		}
		public String getName ()
		{
			return name;
		}
		public int getCode ()
		{
			return code;
		}
		public double getBalance ()
		{
			return balance;
		}
		public static int readInfo (project [] businesses1)
		{
			File file1 = new File("C:\\Users\\SWHTX\\Documents\\clients.dat");
			// *** Let's get the Corporate info Now! ***
			try
			{	
				Scanner ifile1 = new Scanner(file1);
				String companyName;
				int companyCode;
				double companyBalance;
				int numCompanies = 0;
				while (ifile1.hasNext())
			    {
					companyCode = ifile1.nextInt();
					companyBalance = ifile1.nextDouble();
					companyName = ifile1.nextLine();
					project c1 = new project (companyCode, companyBalance, companyName);
					businesses1 [numCompanies] = c1;
					numCompanies++;
			    }
				ifile1.close();
				return numCompanies;
		    }
			catch (Exception e)
			{
				System.out.println("Error!! " + e);
				return 0;
			}
		}
		public static int getCompanyInfo (project [] businesses, int companyCode,int nCompanies)
		{
			int default1 = -1;
			for (int index = 0; index < nCompanies; index++)
			{
				if (companyCode == businesses[index].getCode())
				{
					return index; 
				}
			}
			return default1;
		}
		public static project newCompany (int newCode, double newBalance, String newName)
		{
			project new1 = new project(newCode,newBalance,newName);
			return new1;
		}
		
		public String toString (int option)
		{
			if (option == 1)
			{
				return "" +code;
			}
			if (option == 2)
			{
				return ""+balance;
			}
			else
			{
				return "";
			}
		}
}