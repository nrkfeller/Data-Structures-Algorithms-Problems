// Q4. Given a sorted array of integers, how can you find the location of a particular integer x?
import java.util.Arrays;
public class Q4{
    
    public static void main(String[] args) {
        int[] sortedArray = {3,5,7,8,10,15,17,19,24,28,30,34,37};
        int searchedInt = 28;
        Q4.findInt(sortedArray, searchedInt);
    }
    
    public static int[] findInt(int[] array, int num){
        int len = array.length;
        if ( (array[len/2]) == num ) {
            System.out.println("found!");
            return array;
        } else {
            System.out.println("not it");
            return array;
        }
        
        /*
        int[] firstHalf = Arrays.copyOfRange(array, 0, len/2);
        int[] secondHalf = Arrays.copyOfRange(array, len/2, len);
        
        System.out.println(Arrays.toString(firstHalf));
        System.out.println(Arrays.toString(secondHalf));
        return firstHalf;
        */
    }
    
    
}