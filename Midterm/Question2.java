/*
. (a) Describe using pseudo-code and implement, in Java or C++, an efficient sort algorithm for the
case where it is known that the list to be sorted has exactly 106 elements, which are approximately
uniformly distributed over the range 0 to 106
. (b) Estimate the time complexity of the algorithm
prior to implementation. (c) Compare the estimated complexity to the empirical results (from
your implementation) and explain any discrepancies. [40]

*/

import java.util.Scanner;
import java.util.Random;

class millionSort {
    // enter quantity, this can be any number, the question asks for one million
    static int quantity = 1000000;
    
    public static void main(String[] args) {
        
        // Create a pseudo uniform distribution of a million datapoints between 0 and 10^6
        int[] millionArray = generateMillion();
        // Print the unsorted array (this take alot of time and is irrelevant to complexity, can be commented out)
        System.out.print("Unsorted Array : ");
        for (int i = 0; i < millionArray.length ; i++){
            System.out.print(millionArray[i] + " ");
        }
        System.out.println();
        
        // Start counter for evaluating complexity
        long startTime = System.currentTimeMillis();
        
        // initiate counting sort
        millionArray = countingSort(millionArray);
        long stopTime = System.currentTimeMillis();
        
        // Print sorted array, Note that computation takes less than the actually outputing of a million numbers
        System.out.print("Sorted Array   : ");
        for (int i = 0; i < millionArray.length ; i++){ // go to each index of the indexarray
            for (int j = 0; j < millionArray[i]; j++){ // for each increment of the index
                System.out.print(i + " "); // print the value of the index once
            }
        }
        System.out.println();
        
        // stop the timer
        long elapsedTime = stopTime - startTime;
        // output time of computation and printing
        System.out.println(elapsedTime/1000.0000 + " Seconds to sort");
        System.out.println("Note that generating and printing the values take a lot of time and the timer only counts the sorting itself.");
       
   }
   
   // uniform distribution of n numbers. Depends on the "quantity" variable
   public static int[] generateMillion(){
       int[] array = new int[quantity]; // create empty array of 'quantity' length, filled with zeros
       for (int i = 0; i < quantity; i ++){ // 'quantity' times do
            array[i] = (int)(Math.random() * (quantity)); // generate a random number from 0 - 'quantity' and give it to array
       }
       return array;
   }
   
   // counting method
   public static int[] countingSort(int[] array){
       int[] countedArray = new int[quantity]; // create empty array of 'quantity' length, filled with zeros
       for ( int i = 0; i < countedArray.length; i++){ // 'quantity' times do
           int temp = array[i]; // get value at index
           countedArray[array[i]] += 1; // increment the index of that value by 1
       }
       return countedArray; // return an array that is the occurences of the indexes
   }
}