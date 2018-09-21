package UFPT;
//https://odzkskevi.qnssl.com/4270e162486cb23ab316262c5b1795fd?v=1536892856
import java.util.*;
import java.io.*;
public class Box_Of_Bricks {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s= "";
        int count = 1;
        while ((s = input.readLine()) != null) {


            int size = Integer.parseInt(s);
            if (size == 0)
                break;

            String r = input.readLine();
            String[] strs = r.trim().split("\\s+");
            int total = 0;
            int[] array = new int[size];
            for (int i = 0; i < strs.length; i++) {
                int num = Integer.parseInt(strs[i]);
                total += num;
                array[i] = num;
            }
            int avg = total/size;
            int k = 0;
            for (int i = 0; i < size; i++) {
                if (array[i] < avg) {
                    k+= avg - array[i];
                }
            }
            System.out.println("Set #" + count);
            System.out.println("The minimum number of moves is " + k + ".");
            System.out.println();
            count++;
        }
    }

}
