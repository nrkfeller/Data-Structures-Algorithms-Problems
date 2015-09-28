/*
Q1. Integers in an array are unique and increasingly sorted. Please write a function/method to find an
integer from the array who equals to its index. For example, in the array {-3, -1, 1, 3, 5}, the number 
3 equals its index 3.
*/

import java.util.Arrays;
public class indexEqualsValue {
    int[] numbers;
    
    public static void main(String[] args) {
        int[] numbers = {9,5,4,3,4,1,6};
        // input this should print 3 4 6
        indexEqualsValue.findEquals(numbers);
    }
    
    public static void findEquals(int[] array){
        
        for (int i = 0; i != array.length; i++){
            if ( (array[i]) == i){
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
    
}