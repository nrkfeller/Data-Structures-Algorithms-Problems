/*
Q2. Design, build and test a recursive function that returns the 
nth prime number, with 1 being the first prime. Beware of the computational
demands of recursion in practice.
*/
import java.util.Scanner;
class primeApp{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("Which prime do you want : ");
        int A = reader.nextInt();
        
        System.out.println(nthprime(A, 1, 2));
    }
    
    // recursively find nthprime
    public static int nthprime(int A, int number, int test){
        if (A == 0){
            return number;
        } else {
            if (prime(test, 1) == 0){
                //System.out.println("true!");
                A--;
                number = test;
            }
            test = test+1;
            //System.out.println("false!");
            return nthprime(A, number, test);
        }
    }
    
    // recursively find if test is prime
    public static int prime(int test, int dividor){
        if (test % dividor == 0 && dividor != 1){
            if (test == dividor){
                return 0;
            } else {
                return 1;
            }
        } else {
            dividor = dividor +1;
            return prime(test, dividor);
        }
    }
}