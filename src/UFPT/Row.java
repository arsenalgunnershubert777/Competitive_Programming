package UFPT;
import java.util.*;
public class Row {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int numBlank = 0;
        boolean seated = false;
        boolean maximal = true;

        for (int i = 0;i < n; i++) {
            if (n == 1 && s.charAt(0) == '0') {
                maximal = false;
                break;
            }
            if (s.charAt(i) == '1' && seated == false) {
                numBlank = 0;
                seated = true;
            }
            else if (s.charAt(i)== '1' && seated == true) {
                maximal = false;
                break;
            }
            else {
                seated = false;
                numBlank++;
            }
            if (numBlank == 3 || ((numBlank == 2) && (i == 1 || i == n-1))) {
                maximal = false;
                break;
            }
        }
        System.out.println(maximal == true ? "Yes" : "No");

    }
}
