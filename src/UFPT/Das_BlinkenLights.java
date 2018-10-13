package UFPT;
import java.util.*;
public class Das_BlinkenLights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int blink1 = sc.nextInt();
        int blink2 = sc.nextInt();
        int second = sc.nextInt();
        int product = blink1*blink2;
        int gcd;

        if (blink1 >= blink2) {
            gcd = gcd(blink1, blink2);
        }
        else {
            gcd = gcd(blink2, blink1);
        }
        int lcm = product/gcd;
        if (lcm <= second) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }

    }
    static int gcd(int x, int y) {
        int remainder;
        int divisor = y;
        int dividend = x;
        do {
            remainder =  dividend%divisor;
            dividend = divisor;
            divisor = remainder;
        }
        while (remainder != 0);
        return dividend;
    }
}

