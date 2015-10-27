/*
Q1. Design, build and test a recursive function that returns the 
greatest common divisor (GCD) of two integers.
*/
import java.util.Scanner;
class gcdApp{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int A = reader.nextInt();
        
        System.out.print("Enter second number : ");
        int B = reader.nextInt(); 
        
        System.out.println(gcd(A, B, 1, 1));
        
    }
    
    public static int gcd(int A, int B, int dividor, int temp){
        
        if (temp == A || temp == B ){
            return dividor;
        } else {
            temp += 1;
            if ((A % temp) == 0 && (B % temp) == 0){
                dividor = temp;
            }
            return gcd(A, B, dividor, temp);
        }
    }
}