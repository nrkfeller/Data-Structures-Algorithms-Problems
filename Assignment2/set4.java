/*
Q5. Given a string, compute recursively the number of lowercase 'x' chars in the string. 

countX("xxhixx") : 4
countX("xhixhix") : 3
countX("hi") : 0

Q6. Given a non-negative int n, return the sum of its digits recursively. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12). 

sumDigits(126) : 9
sumDigits(49) : 13
sumDigits(12) : 3

Q7. Write a recursive function (use no while loops or for loops) that prints all the elements of an array of integers, one per line. The parameters to the function should be int a[], and int size.

Q8. Study QuickSort, implement it using a recursive algorithm, then test it and exhibit your results.
*/

import java.util.Scanner;

class recursivePrinter {
    
   public static void main(String[] args) {
       
       Scanner reader = new Scanner(System.in);
       System.out.print("What should be the size of you array? : ");
       int lengthOfArray = reader.nextInt(); 
       
       int toPrint[] = new int[lengthOfArray];
       
       for (int i = 0; i < lengthOfArray ; i++){
           System.out.print("Enter a number, " + (lengthOfArray - i) + " remaining : ");
           int newNumber = reader.nextInt(); 
           toPrint[i] = newNumber;
       }
       System.out.println("Here is your recursively printer array of length : " + lengthOfArray);
       printer(toPrint, lengthOfArray);
   }
   
   public static int printer(int a[], int size){
       if ( size == 0 ){
           return 0;
       } else {
           System.out.println(a[-size+a.length]);
           size = size - 1;
           return printer(a,size);
       }
   }
}