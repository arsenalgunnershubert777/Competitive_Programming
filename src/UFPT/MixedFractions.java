package UFPT;

import java.util.*;
public class MixedFractions {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            int den = sc.nextInt();
            if (num==0 && den == 0) {
                break;
            }
            int whole = num/den;
            int mod = num%den;
            System.out.println(whole + " " + mod + " / " + den);
        }
    }
}