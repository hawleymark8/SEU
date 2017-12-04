/*main8.c*/
#include <stdio.h>
void printList (float list[], int numElements);
void sortList (float list[], int numElements);
int readList (float list[]);
float calcAvgNasm (float [], int);
float calcAveC (float [], int);
#define MAX 10;
int main();
	{
	 float list [MAX];
	 int numElements;
	 int avg;
	 numElements = readList(list);

	 printf("\n Original List \n");
	 printList(list, numElements);

	 sortList(list, numElements);
	 printf("\n Sorted List \n");
	 printList(list, numElements);

	 avg = calcAvgNasm(list, numElements);
	 printf("\n Average in Nasm: %d \n", avg);

	 avg = calcAvgC (float [], int);
	 printf("\n Average in C: %d \n", avg);
	 }