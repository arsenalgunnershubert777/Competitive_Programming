package Problems.Codeforces;
import java.util.*;

public class Tavas_and_SaDDas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = Integer.toString(n);
        double num = Math.pow((double)2,(double) s.length()) -1;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i)=='7') {
                num+=Math.pow((double)2,(double)(s.length() - i -1));
            }
        }
        System.out.println((int)num);

    }
}

