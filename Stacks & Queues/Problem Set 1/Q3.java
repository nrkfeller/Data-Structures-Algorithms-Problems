// Q3. Write a function to reverse the order of words in a string in place.
import java.util.Arrays;
public class Q3{
    String str;
    String splited;
    public static void main(String[] args) {
        
        String str = "My name is Nicolas and I love potatoes and Burritos";
        String[] splited = str.split("\\s+");
        String[] revSplited = Q3.reverse(splited);
        for (int i = 0; i < revSplited.length; i++) {
            System.out.print(revSplited[i] + " ");
        }
        System.out.println();
        
    }
    
    public static String[] reverse(String[] original) {
        for(int i = 0; i < original.length / 2; i++)
        {
            String temp = original[i];
            original[i] = original[original.length - i - 1];
            original[original.length - i - 1] = temp;
        }
        return original;
    }
    
}