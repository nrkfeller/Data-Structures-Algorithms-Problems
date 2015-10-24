import java.util.Scanner;

class TriangleApp{
    static int theNumber;
    
    public static void main(String[] args){
        
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a Number:");;
        int theNumber = reader.nextInt(); 
        int theAnswer = triangle(theNumber);
        System.out.println("Triangle : " + theAnswer);
        
    }
    
    public static int triangle(int num){
        if (num == 0){
            return num;
        } else {
            return (num + triangle(num-1));
        }
    }
}