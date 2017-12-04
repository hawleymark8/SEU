//horseDriver.java      Author: Mark Hawley
//Purpose: create horse and prints attributes and mutates name and weight
//Modification History:3/4/10:-Created

import java.util.*;

public class horseDriver
{
    public static void main (String[]args)
    {
	System.out.println("Welcome to the horseDriver program");

	horse h3 = new horse();
	horse h11 = new horse();
	horse h12 = new horse("Trigger","Percheron",740,'M');
	
	System.out.println(h11.toString());
	System.out.println(h12.toString());
	
	h11.setName("Henry");
	h12.setWeight(800);

	System.out.println(h11.toString());
	System.out.println(h12.toString());
	
	//buildHorse
	
	h3=horse.buildHorse();
	System.out.println(h3.toString());
	
	return;
    }
}//end of class