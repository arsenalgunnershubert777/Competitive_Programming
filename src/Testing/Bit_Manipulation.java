package Testing;

import java.util.Scanner;

public class Bit_Manipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp1 = n;
        int temp2 = n;
        int temp3 = n;
        int temp4= n;

        temp1 &= ((~0)<<(3+1));
        temp2 &= ~((1<<(3+1))-1);
        System.out.println(temp1);
        System.out.println(temp2);

        temp3 |= ((1<<(3+1))-1)<<4;
        temp4 |= ((~0)>>>(32-(3+1))) << 4;
        System.out.println(temp3);
        System.out.println(temp4);

    }
}
