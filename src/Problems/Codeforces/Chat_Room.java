package Problems.Codeforces;
import java.util.*;
public class Chat_Room {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = 0;
        int j = 0;
        char[] hello = {'h','e','l','l','o'};
        while (i < s.length() && j < hello.length) {
            if (s.charAt(i) == hello[j]) {

                j++;
            }
            i++;
        }
        System.out.println((j == hello.length ? "YES" : "NO"));


    }
}
