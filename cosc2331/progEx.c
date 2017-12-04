// progEx.c
// a simple program that tests isNumeric method from C
// 

#include <stdio.h>
#include <string.h>

int isNumeric(char *, int);

int main()
{
  char string[100]; // way oversized to hold enough space for string
  int result;

  printf("Enter your string for testing isNumeric: ");
  fgets(string, 100, stdin); // reads as string of up to 99 chars and stores '\0'
  // we have to strip off newline as fgets leaves it at end of string if it was read
  string[strlen(string)-1]='\0';  // removes \n off of string replaces it with null
  printf("String length of %s is %d\n", string, strlen(string));
 
  result = isNumeric(string, strlen(string));

  printf("Returning from isNumeric...\n");
  if(result) {
    printf("Your string %s is numeric. \n", string);
  }
  else
   {
         printf("Your string %s is NOT numeric. \n", string);
    }

  return 0;
}
