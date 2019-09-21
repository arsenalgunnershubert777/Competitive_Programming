package Testing;

import java.util.Scanner;

public class Big_O_permute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        permutation(sc.next());
    }
    static void permutation(String str) {
        permutation(str,"");
    }
    static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        }
        else {
            for (int i =0; i < str.length();i++) {
                String rem = str.substring(0,i) + str.substring(i+1);
                permutation(rem,prefix+str.charAt(i));
            }
        }
    }
}
