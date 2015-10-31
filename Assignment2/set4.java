/*
Q7. Write a recursive function (use no while loops or for loops) that prints all the elements of an array of integers, one per line. The parameters to the function should be int a[], and int size.
*/

import java.util.Scanner;

class recursivePrinter {
    
   public static void main(String[] args) {
       
       Scanner reader = new Scanner(System.in);
       // prompt user for size of the array
       System.out.print("What should be the size of you array? : ");
       int lengthOfArray = reader.nextInt(); 
       
       int toPrint[] = new int[lengthOfArray];
       
       // enter all values of the array
       for (int i = 0; i < lengthOfArray ; i++){
           System.out.print("Enter a number, " + (lengthOfArray - i) + " remaining : ");
           int newNumber = reader.nextInt(); 
           toPrint[i] = newNumber;
       }
       
       System.out.println("Here is your recursively printer array of length : " + lengthOfArray);
       // print the array
       printer(toPrint, lengthOfArray);
   }
   
   
   public static int printer(int a[], int size){
       // if array is completely chunked down, break recursion
       if ( size == 0 ){
           return 0;
       } else { // unincrement 'size' to grab newer value and print new value
           System.out.println(a[-size+a.length]);
           size = size - 1;
           return printer(a,size);
       }
   }
}