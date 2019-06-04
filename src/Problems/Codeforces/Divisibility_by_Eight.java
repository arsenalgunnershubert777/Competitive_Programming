package Problems.Codeforces;
import java.util.*;

public class Divisibility_by_Eight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        boolean divisible = true;
        for (int i = 0; i < 125; i++) {
            String eight = Integer.toString((i*8));
            int currIndex = 0;
            divisible = true;
            for (int j = 0; j < eight.length(); j++) {
                int test = num.indexOf(eight.charAt(j), currIndex);
                if (test != -1) {
                    currIndex = test+1;
                }
                else {
                    divisible = false;
                    break;
                }
            }
            if (divisible) {
                System.out.println("YES");
                System.out.println(eight);
                break;
            }

        }
        if (!divisible) {
            System.out.println("NO");
        }

    }
}
