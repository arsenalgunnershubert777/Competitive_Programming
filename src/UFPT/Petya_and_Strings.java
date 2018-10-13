package UFPT;
import java.util.*;

public class Petya_and_Strings {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String one = sc.next();
        String two = sc.next();
        if (one.compareToIgnoreCase(two) < 0) {
            System.out.println(-1);
        }
        else if (one.compareToIgnoreCase(two) > 0) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
        

    }
}
