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
       
       // prompt user for input
       Scanner reader = new Scanner(System.in);
       System.out.print("Enter a number for split and add : ");
       int numberToSplit = reader.nextInt();
       //int numberToSplit = -12;
       
       // output the result!
       System.out.println("The sum of digits is : " + sumOfDigits(numberToSplit));
   }
   
   public static int sumOfDigits(int x){
       
       // only take positive values
       x = Math.abs(x);
       // start with first order of magniture
       int orderOfMagnitude = 1;
       // user temp to store new values
       int temp = 0;
       // user answer to store all old values
       int answer = 0;
       
       // as long as we havnt reached the order of magnitude of the input keep chunking it off
       while ( x > orderOfMagnitude){
           // increment order of magnitude
           orderOfMagnitude = orderOfMagnitude * 10;
           // get value of the digit at newest order of magnitude
           temp = (x%orderOfMagnitude - answer)/(orderOfMagnitude/10);
           // add new value to the answer
           answer = answer + temp;
       }
       return answer;
   }
}