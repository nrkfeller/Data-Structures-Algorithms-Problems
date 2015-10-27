/*
Q1. Solve the Nine Queens problem recursively. The objective is to place nine queens on an empty chessboard so that no queen is �attacking� any other, i.e., no two queens are in the same row, the same column, or along the same diagonal? 

Q2. Find all permutations of a string of characters using recursion.

Q3. Solve the Knapsack Problem using recusrion: demonstrate the solution using the 
following example: 

Suppose we are given the set 5, 6, 3, 4, 2, and 8; 13 is the target.

Q4. Implement MergeSort recursively for sorting a set of words in ascending order.
*/

public class set2 {

   /***************************************************************************
    * Return true if queen placement q[n] does not conflict with
    * other queens q[0] through q[n-1]
    ***************************************************************************/
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }

   /***************************************************************************
    * Print out N-by-N placement of queens from permutation q in ASCII.
    ***************************************************************************/
    public static void printQueens(int[] q) {
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j)  System.out.print("Q ");
                else            System.out.print("* ");
            }
            System.out.println();
        }  
         System.out.println();
    }


   /***************************************************************************
    *  Try all permutations using backtracking
    ***************************************************************************/
    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int n) {
        int N = q.length;
        //if (n == N) printQueens(q);
        else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isConsistent(q, n)) enumerate(q, n+1);
            }
        }
    }  


    public static void main(String[] args) {
        int N = 8;
        enumerate(N);
    }

}