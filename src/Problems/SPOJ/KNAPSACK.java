package Problems.SPOJ;

import java.io.DataInputStream;
import java.io.InputStream;
import Tools.Reader;


public class KNAPSACK {

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }
    public static void main(String[] args) throws Exception {
        Reader in = new Reader(System.in);
        int maxWeight = in.nextInt();
        int numItems = in.nextInt();

        int[] weights = new int[numItems+1];
        int[] values= new int[numItems+1];
        int[][] dp = new int[numItems+1][maxWeight+1];
        for (int i = 1;i <= numItems; i++) { //filling in weight and value tables
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }

        for (int i = 0; i <= numItems; i++) { //going down rows and calculating
            for (int j = 0; j <= maxWeight; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (weights[i] <= j) { //if you can fit weight, have to make decision
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                }
                else { //if not continue with optimal from above row
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        System.out.println(dp[numItems][maxWeight]);
    }
}
