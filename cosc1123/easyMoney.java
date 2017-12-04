
import java.util.Random;
public class easyMoney
{
    public static void main (String[]args)
    {
	int num1=0;
	int num2=0;

	num1 = oneDie();
	num2 = oneDie();

	System.out.println("Easy Money!!");
	
	System.out.println("You rolled a " + num1 + " and a " + num2);

	if ( (num1 + num2 == 7) || (num1 + num2 == 11))
	    {
		System.out.println("Winner!!");
	    }
	else
	    {
		System.out.println("Roll Again!");
	    }
	
	return;
    }

    //oneDie Method
    //Pre: -----
    //Post: int

    public static int oneDie()
    {
	int die=0;

	Random randy=new Random();
	die = randy.nextInt(6) + 1;

	return die;
    }

}