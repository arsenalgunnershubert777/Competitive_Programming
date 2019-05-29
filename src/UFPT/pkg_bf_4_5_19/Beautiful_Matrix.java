package UFPT.pkg_bf_4_5_19;
import java.util.*;
import java.math.*;
public class Beautiful_Matrix {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int posX =0;
        int posY = 0;

        for (int i = 1; i <=5;i++) {
            for (int j = 1; j<=5;j++) {
                if (sc.nextInt() == 1) {
                    posX = i;
                    posY = j;

                }
            }
        }
        System.out.println(Math.abs(3-posX) + Math.abs(3-posY));
    }
}
