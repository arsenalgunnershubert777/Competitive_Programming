package UFPT;
import java.util.*;
public class Bus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean seats = false;
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            strings[i] = s;
            if (!seats) {
                if (s.charAt(0) == 'O' && s.charAt(1) == 'O') {
                    seats = true;
                    strings[i] = "++|" + strings[i].substring(3);

                }
            }

            if (!seats) {

                if (s.charAt(3) == 'O' && s.charAt(4) == 'O') {
                    strings[i] = strings[i].substring(0,3) + "++";
                    seats = true;


                }
            }

        }
        if (!seats) {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                System.out.println(strings[i]);
            }
        }

    }
}
