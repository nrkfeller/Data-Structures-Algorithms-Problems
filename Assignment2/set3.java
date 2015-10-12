/*
Q2. Write a function with the following prototype that returns the sum of the digits of an integer.
int sumOfDigits(int x);
If x is 234, the function should return 2 + 3 + 4, that is, 9.
If x is 12, the function should return 1 + 2, which is 3.
If x is 39, the function should return 12.
If x is negative, ignore the minus sign. For example, -12 and 12 both return 3.
*/
import java.util.Scanner;

class sumOfDigits {
    
   public static void main(String[] args) { 
       
       // ENTER WHATEVER INTEGER HERE
       Scanner reader = new Scanner(System.in);
       System.out.print("Enter a number for split and add : ");
       int numberToSplit = reader.nextInt();
       //int numberToSplit = -12;
       
       System.out.println("The sum of digits is : " + sumOfDigits(numberToSplit));
   }
   
   public static int sumOfDigits(int x){
       x = Math.abs(x);
       int orderOfMagnitude = 1;
       int temp = 0;
       int answer = 0;
       while ( x > orderOfMagnitude){
           
           orderOfMagnitude = orderOfMagnitude * 10;
           
           temp = (x%orderOfMagnitude - answer)/(orderOfMagnitude/10);
           
           answer = answer + temp;
       }
       return answer;
   }
}