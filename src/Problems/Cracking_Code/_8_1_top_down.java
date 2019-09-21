package Problems.Cracking_Code;
import java.util.*;
public class _8_1_top_down {
    private static int[] memo;
    private static int n = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[n+1];
        System.out.println(explore_step(0));


    }

    static int explore_step(int sum) {
        int count = 0;
        if (sum == n) {
            return 1;
        }
        if (memo[sum] != 0) {
            return memo[sum];
        }
        for (int i =1; i<=3;i++) {
            if (n-i-sum>=0) {
                count+=explore_step(sum+i);
            }
        }
        memo[sum]=count;
        return count;

    }


}
