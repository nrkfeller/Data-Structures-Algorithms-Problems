import java.util.Arrays;

public class coinBalancer {
    
    public static void main(String[] args) {
        // set weight of lighter coins
        int c = 1;
        //set weight of heavier coin
        int ch = 2;
        // place all coins in array, with only one heavier coin
        int[] anArrayOfCoins = {c,c,c,c,c,c,c,ch}; //,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c};
        
        int[] Answer = coinBalancer.balance(anArrayOfCoins);
    }
    
    public static int[] balance(int[] array) {
        if (array.length == 1){
            return array;
        } else {
            int len = array.length;
            // split array into two
            int[] firstHalf = Arrays.copyOfRange(array, 0, len/2);
            int[] secondHalf = Arrays.copyOfRange(array, len/2, len);
            // place each side on scale and keep only heaviest side
            if( (coinBalancer.sum(firstHalf)) > (coinBalancer.sum(secondHalf)) ) {
                // do this recursively
                System.out.println(Arrays.toString(firstHalf));
                return coinBalancer.balance(firstHalf);
            } 
            else {
                // do this recursively
                System.out.println(Arrays.toString(secondHalf));
                return coinBalancer.balance(secondHalf);
            }
        }
        
    }
    // Get the of all weights in an array
    public static int sum(int[] array) {
        int total = 0;
        for (int i = 0; i != array.length; i++) {
            total = total + array[i];
        }
        return total;
    }
}