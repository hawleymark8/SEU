// test.java   
// demonstrate input tools.  newline character
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class HW7Driver {

   public static void main( String args[] )
   {
     System.out.println("** Start of HW7 **");
       String ladderString = "in ladder";
       String strVowels = "a and A and another a";
       String strPali = "abba";
       String strPali2 = "abbaaa";
       int numVowels = 0;
       numVowels = myMethods.vowels(strVowels);
       System.out.println("back from vowels: " + numVowels +
			  " should be 8");
       Boolean isPali = false;
       isPali = myMethods.pali(strPali);
       System.out.println(strPali + " palindrome? " + isPali);
       isPali = myMethods.pali(strPali2);
       System.out.println(strPali2 + " palindrome? " + isPali);

       myMethods.ladder(ladderString);   
       System.out.println("** End of HW7 **");
       return;
   }
}
