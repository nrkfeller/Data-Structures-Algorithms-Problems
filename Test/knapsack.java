/* Q4. Design, build and test a recursive algorithmic solution to the 
 Knapsack Problem described on pages 305-6 of the textbook.


*/
import java.util.Scanner;
class knapsackApp{
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.print("How many pounds can the knapsack carry? : ");
        int maxWeight = reader.nextInt();
        
        System.out.print("How many items to choose from? : ");
        int lengthOfArray = reader.nextInt(); 
           
        int items[] = new int[lengthOfArray];
           
        for (int i = 0; i < lengthOfArray ; i++){
            System.out.print("Weight of an item, " + (lengthOfArray - i) + " remaining : ");
            int newNumber = reader.nextInt(); 
            items[i] = newNumber;
        }
        int[] answer = new int[lengthOfArray];
        sackIt(maxWeight, items,  answer);
    }
    
    public static int[] sackIt(int weight, int[] items, int[] answer){
        if ()
    }
}