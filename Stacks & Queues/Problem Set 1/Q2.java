import java.util.Arrays;

public class Q2 {
    private String[] people;
    private int[] numbers;
    private String[] friend;
    public static void main(String[] args) {
        // Names
        String[] people = {"Tu", "Katherine","James","Nicolas","Eve","Jinbee","Abel","Paul"};
        // Numbers associated with each name
        int[] numbers = {3,      6,          8,      2,      4,      9,      1,      7};
        Q2.findThreeFriends(people,numbers);
        
    }
    public static int[] findThreeFriends(String[] names, int[]numbers) {
        
        for (int i = 0; i != names.length; i++) {
            int[] closest = new int[names.length];
            for (int j = 0; j != names.length; j++) {
                int distance = numbers[i] - numbers[j];
                closest[j] = Math.abs(distance);
                
            }
            System.out.println(Arrays.toString(closest));
            Q2.findClosest(closest,0)
            /*
            System.out.print(names[i] + "'s closest friends are : ");
            System.out.print(names[closest[1]] + " ");
            System.out.print(names[closest[2]] + " ");
            System.out.print(names[closest[3]] + " ");
            System.out.println();
            */
        }
        return numbers;
    }
    public static int[] findClosest(int[] closest, int lowerbound){
        
    }
    
}