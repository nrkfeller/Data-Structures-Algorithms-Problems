import java.util.Scanner;

class FactorialApp{
    static int theNumber;
    
    public static void main(String[] args){
        
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a Number:");;
        int theNumber = reader.nextInt(); 
        int theAnswer = factorial(theNumber);
        System.out.println("Factorial : " + theAnswer);
        
    }
    
    public static int factorial(int num){
        if (num == 1){
            return num;
        } else {
            return (num * factorial(num-1));
        }
    }
}